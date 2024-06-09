package com.study24

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study24.ui.theme.Study24Theme
import com.study24.ui.views.Greeting
import com.study24.ui.views.RadioButtonGroup
import com.study24.utils.logD

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Study24Theme { // code can run without a theme as well
                Scaffold( // material3
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Yellow)
                ) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
private fun MainScreen(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose"),
) {
    logD("Composable", "MyApp")

    Column(modifier.padding(5.dp)) {

        logD("Composable", "MyApp > Column")

        names.forEachIndexed { index, name ->
            Greeting(name = name)
            if (index < names.size - 1) {
                Spacer(modifier = Modifier.height(5.dp))
            }
        }

        RadioButtonGroup(
            options = listOf("Option 1", "Option 2", "Option 3"),
            onOptionSelected = { index, option ->
                Log.d("MainActivity", "Selected #$index: $option")
            }
        )
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun MyAppPreview() {
    Study24Theme {
        MainScreen()
    }
}