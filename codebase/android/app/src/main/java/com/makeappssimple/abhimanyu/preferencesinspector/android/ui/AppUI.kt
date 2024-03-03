package com.makeappssimple.abhimanyu.preferencesinspector.android.ui

import androidx.compose.runtime.Composable
import com.makeappssimple.abhimanyu.preferencesinspector.android.ui.home.HomeScreen
import com.makeappssimple.abhimanyu.preferencesinspector.android.ui.theme.PreferencesInspectorTheme

@Composable
fun AppUI() {
    PreferencesInspectorTheme {
        HomeScreen()
    }
}
