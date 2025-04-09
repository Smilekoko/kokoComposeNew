package com.shiki.kokocomposenew

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.postDelayed
import androidx.lifecycle.lifecycleScope
import com.shiki.kokocomposenew.component.chip.AssistChipExample
import com.shiki.kokocomposenew.databinding.ActivityXmlBinding
import com.shiki.kokocomposenew.component.dialog.AlertDialogExample
import com.shiki.kokocomposenew.component.lazygrid.LazyVerticalGridExample
import com.shiki.kokocomposenew.component.modalbottomsheet.ModalBottomSheetExample
import com.shiki.kokocomposenew.component.page.HorizontalPagerExample
import com.shiki.kokocomposenew.component.page.VerticalPagerExample
import com.shiki.kokocomposenew.component.radioButton.RadioButtonSingleSelection
import com.shiki.kokocomposenew.component.slider.SliderAdvancedExample
import com.shiki.kokocomposenew.component.slider.SliderExample
import com.shiki.kokocomposenew.component.snackbar.SnackbarBaseExample
import com.shiki.kokocomposenew.component.switch.SwitchExample
import com.shiki.kokocomposenew.component.text.QinyuanSpringSnowColumn
import com.shiki.kokocomposenew.modifier.ModifierOrderExample
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class XmlActivity : AppCompatActivity() {

    private lateinit var binding: ActivityXmlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityXmlBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.root.postDelayed({
            binding.composeView.setContent {
//            QinyuanSpringSnowColumn()
//            AlertDialogExample()
//            SwitchExample()
//            RadioButtonSingleSelection()
//            AssistChipExample()
//            SnackbarBaseExample()
//            SliderAdvancedExample()
//                ModifierOrderExample()
//                HorizontalPagerExample()
//                VerticalPagerExample()
                ModalBottomSheetExample()
            }
        }, 0)


    }
}