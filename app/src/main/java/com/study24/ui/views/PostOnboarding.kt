package com.study24.ui.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study24.utils.logD

@Composable
fun PostOnboarding(modifier: Modifier = Modifier) {
    logD("Composable", "PostOnboarding")

    val names: List<String> = List(1000) { "$it" }

    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {

        logD("Composable", "PostOnboarding > LazyColumn")

        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Preview
@Composable
fun PostOnboardingPreview() {
    PostOnboarding()
}