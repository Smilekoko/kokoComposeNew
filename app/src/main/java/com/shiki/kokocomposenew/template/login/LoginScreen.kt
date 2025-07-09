@file:OptIn(ExperimentalFoundationApi::class)

package com.shiki.kokocomposenew.template.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.OverscrollEffect
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.overscroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shiki.kokocomposenew.R
import com.shiki.kokocomposenew.lottie.LottieWorkingLoadingView
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme


@Composable
fun LoginScreen() {

    Scaffold { paddingValues ->

        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }

        var hasError by remember { mutableStateOf(false) }

        //用于跟踪和管理文本字段的交互状态的
        val emailInteractionState = remember { MutableInteractionSource() }
        val isFocused by emailInteractionState.collectIsFocusedAsState()

        val passwordInteractionState = remember { MutableInteractionSource() }
        //密码可见性状态
        var passwordVisualTransformation by remember { mutableStateOf<VisualTransformation>(PasswordVisualTransformation()) }

        // 使用 CompositionLocalProvider 包裹需要禁用 overscroll 效果的组件
        CompositionLocalProvider(
            LocalOverscrollConfiguration provides null
        ){
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {

                item { Spacer(modifier = Modifier.height(20.dp)) }
                item { LottieWorkingLoadingView() }
                item {
                    Text(
                        "Welcome Back",
                        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold),
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                item {
                    Text(
                        "We have missed you, Let's start by Sign In!",
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )
                }
                item {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        maxLines = 1,
                        isError = hasError,
                        value = email,
                        colors = TextFieldDefaults.colors().copy(
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = if (isFocused) Color.Blue else Color.Gray,
                            focusedLabelColor = if (isFocused) Color.Blue else Color.Gray
                        ),
                        keyboardOptions =
                            KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                        leadingIcon = {
                            Icon(
                                ImageBitmap.imageResource(R.drawable.email),
                                contentDescription = "Email",
                                tint = Color.Unspecified//保持原本颜色
                            )
                        },
                        label = { Text(text = "Email address") },
                        placeholder = { Text(text = "abc@gmail.com") },
                        onValueChange = { email = it },
                        interactionSource = emailInteractionState,
                    )
                }
                item {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        maxLines = 1,
                        isError = hasError,
                        value = password,
                        colors = TextFieldDefaults.colors().copy(
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = if (isFocused) Color.Blue else Color.Gray,
                            focusedLabelColor = if (isFocused) Color.Blue else Color.Gray
                        ),
                        keyboardOptions =
                            KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Done
                            ),
                        leadingIcon = {
                            Icon(
                                ImageBitmap.imageResource(R.drawable.password),
                                contentDescription = "Password",
                                tint = Color.Unspecified//保持原本颜色
                            )
                        },
                        trailingIcon = {
                            val eyeDrawable =
                                if (passwordVisualTransformation == VisualTransformation.None) R.drawable.eye_open else R.drawable.eye_close
                            Icon(
                                ImageBitmap.imageResource(eyeDrawable),
                                modifier = Modifier.clickable(onClick = {
                                    passwordVisualTransformation =
                                        if (passwordVisualTransformation != VisualTransformation.None) {
                                            VisualTransformation.None
                                        } else {
                                            PasswordVisualTransformation()
                                        }
                                }),
                                contentDescription = "",
                                tint = Color.Unspecified,
                            )
                        },
                        label = { Text(text = "Password") },
                        placeholder = { Text(text = "kokoloveloveni") },
                        onValueChange = { password = it },
                        interactionSource = passwordInteractionState,
                        visualTransformation = passwordVisualTransformation,
                    )
                }
                item {
                    var loading by remember { mutableStateOf(false) }
                    Button(
                        onClick = {
                            if (invalidInput(email.text, password.text)) {
                                loading = false
                                hasError = true
                            } else {
                                hasError = false
                                loading = true
                            }

                        }, modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                            .height(50.dp)
                            .clip(CircleShape)
                    ) {

                        if (loading) {
                            HorizontalDottedProgressBar()
                        } else {
                            Text("Login In")
                        }
                    }
                }
                item {
                    Box(
                        modifier = Modifier.padding(vertical = 16.dp)
                    ) {
                        Spacer(
                            modifier =
                                Modifier
                                    .align(Alignment.Center)
                                    .height(1.dp)
                                    .fillMaxWidth()
                                    .background(Color.LightGray)
                        )
                        Text(
                            text = "Or use",
                            color = Color.LightGray,
                            modifier =
                                Modifier
                                    .align(Alignment.Center)
                                    .background(MaterialTheme.colorScheme.background)
                                    .padding(horizontal = 16.dp)
                        )
                    }
                }
                item {
                    OutlinedButton(
                        onClick = {}, modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Icon(
                            ImageBitmap.imageResource(R.drawable.facebook),
                            contentDescription = "",
                            tint = Color.Unspecified
                        )
                        Text(
                            text = "Sign in with Facebook",
                            style = MaterialTheme.typography.headlineSmall.copy(fontSize = 14.sp),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                item { Spacer(modifier = Modifier.height(8.dp)) }
                item {
                    OutlinedButton(
                        onClick = {}, modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Icon(
                            ImageBitmap.imageResource(R.drawable.google),
                            contentDescription = "",
                            tint = Color.Unspecified
                        )
                        Text(
                            text = "Sign in with Gmail",
                            style = MaterialTheme.typography.headlineSmall.copy(fontSize = 14.sp),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                item {
                    val primaryColor = MaterialTheme.colorScheme.primary
                    val text = "Don't have an account? Register"
                    val spanText = "Register"
                    val annotatedString = remember {
                        AnnotatedString.Builder(text).apply {
                            addStyle(style = SpanStyle(color = primaryColor), text.indexOf(spanText), text.length)
                        }
                    }
                    Text(
                        text = annotatedString.toAnnotatedString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                            .clickable(onClick = {}),
                        textAlign = TextAlign.Center
                    )
                }
                item { Spacer(modifier = Modifier.height(100.dp)) }

            }
        }
    }
}

fun invalidInput(email: String, password: String) = email.isBlank() || password.isBlank()


@Preview
@Composable
fun LoginScreenPreview() {
    KokoComposeNewTheme {
        LoginScreen()
    }
}
