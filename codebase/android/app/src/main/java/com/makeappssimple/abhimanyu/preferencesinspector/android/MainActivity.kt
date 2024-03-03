package com.makeappssimple.abhimanyu.preferencesinspector.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.makeappssimple.abhimanyu.preferencesinspector.android.ui.AppUI

class MainActivity : ComponentActivity() {
    override fun onCreate(
        savedInstanceState: Bundle?,
    ) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppUI()
        }
    }
}
