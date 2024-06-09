package com.study24.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study24.ui.theme.Study24Theme
import com.study24.utils.logD

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    logD("Composable", "Greeting($name)")

    // LEARN: State and MutableState are interfaces that hold some value and trigger UI updates (recompositions) whenever that value changes.
    // LEARN: remember{} is a composable that remembers the value of a variable across recompositions.
    // LEARN: here, return type of remember{} is MutableState<T> where T is the type of the value.
    val expanded = remember { mutableStateOf(false) }

    val extraPadding = if (expanded.value) 48.dp else 0.dp

    // Surface has default but dynamic values too.
    // Example: textColor will be white with MaterialTheme.colorScheme.primary,
    // and textColor will be black with MaterialTheme.colorScheme.inversePrimary.
    Surface(color = MaterialTheme.colorScheme.primary) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text(text = "Hello")
                Text(text = "$name!")
            }
            ElevatedButton(
                onClick = { expanded.value = !expanded.value },
            ) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    Study24Theme {
        Greeting("Compose")
    }
}