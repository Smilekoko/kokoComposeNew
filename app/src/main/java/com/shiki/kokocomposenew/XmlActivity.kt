package com.shiki.kokocomposenew

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shiki.kokocomposenew.databinding.ActivityXmlBinding
import com.shiki.kokocomposenew.component.dialog.AlertDialogExample
import com.shiki.kokocomposenew.text.QinyuanSpringSnowColumn

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

        binding.composeView.setContent {
//            QinyuanSpringSnowColumn()
            AlertDialogExample()
        }
    }
}