package com.makeappssimple.abhimanyu.preferencesinspector.android.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.makeappssimple.abhimanyu.preferencesinspector.android.preference.PreferenceManager
import com.makeappssimple.abhimanyu.preferencesinspector.android.preference.PreferenceManagerImpl
import com.makeappssimple.abhimanyu.preferencesinspector.android.ui.PreferenceFileUI

@Composable
fun HomeScreen(
    preferenceManager: PreferenceManager = PreferenceManagerImpl(
        context = LocalContext.current,
    ),
) {
    val preferenceFiles = preferenceManager.getPreferenceFiles()
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(
                    paddingValues = innerPadding,
                ),
        ) {
            items(
                items = preferenceFiles,
                key = {
                    it.fileName
                },
            ) { preferenceFile ->
                PreferenceFileUI(
                    preferenceFile = preferenceFile,
                )
            }
        }
    }
}
