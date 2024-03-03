package com.makeappssimple.abhimanyu.preferencesinspector.android.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.makeappssimple.abhimanyu.preferencesinspector.android.model.PreferenceFile

@Composable
fun PreferenceFileUI(
    preferenceFile: PreferenceFile,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                all = 16.dp,
            ),
    ) {
        Column {
            Text(
                text = preferenceFile.fileName,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(
                        all = 16.dp,
                    ),
            )
            preferenceFile.preferences.map {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = it.key,
                        modifier = Modifier
                            .padding(
                                horizontal = 16.dp,
                                vertical = 8.dp,
                            ),
                    )
                    Text(
                        text = it.value.toString(),
                        modifier = Modifier
                            .padding(
                                horizontal = 16.dp,
                                vertical = 8.dp,
                            ),
                    )
                }
            }
        }
    }
}
