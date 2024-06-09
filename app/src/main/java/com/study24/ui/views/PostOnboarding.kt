package com.study24.ui.views

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.study24.utils.logD

@Composable
fun PostOnboarding(modifier: Modifier = Modifier) {
    logD("Composable", "PostOnboarding")

    Column(modifier.padding(5.dp)) {

        logD("Composable", "PostOnboarding > Column")

        val names = listOf("World", "Compose")

        names.forEachIndexed { index, name ->
            Greeting(name = name)
            if (index < names.size - 1) {
                Spacer(modifier = Modifier.height(5.dp))
            }
        }

        RadioButtonGroup(
            options = listOf("Option 1", "Option 2", "Option 3"),
            onOptionSelected = { index, option ->
                Log.d("PostOnboarding", "Selected #$index: $option")
            }
        )
    }
}