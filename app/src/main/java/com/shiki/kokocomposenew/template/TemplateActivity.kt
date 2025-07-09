package com.shiki.kokocomposenew.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.shiki.kokocomposenew.template.login.LoginScreen
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme

class TemplateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val templateType = intent.extras?.getString("templateType") ?: ""

        setContent {
            KokoComposeNewTheme { TemplateApp(templateType) }
        }

    }
}

@Composable
fun TemplateApp(templateType: String = "Login") {
    when (templateType) {
        "Login" -> LoginScreen()
    }
}

