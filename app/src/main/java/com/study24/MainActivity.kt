package com.study24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.study24.ui.theme.Study24Theme
import com.study24.ui.views.OnboardingScreen
import com.study24.ui.views.PostOnboarding
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
private fun MainScreen(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    logD("Composable", "MainScreen($shouldShowOnboarding)")

    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            PostOnboarding(modifier)
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun MainScreenPreview() {
    Study24Theme {
        MainScreen()
    }
}