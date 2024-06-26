package com.study24.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study24.ui.theme.Study24Theme
import com.study24.utils.logD

@Composable
fun RadioButtonGroup(
    label: String,
    options: List<String>,
    selectedIndex: Int = 0,
    onOptionSelected: (Int, String) -> Unit
) {
    // https://youtu.be/fFLBCgoHHys
    // LEARN: if savedSelectedIndex's value is changed, relevant composable(s) will be re-composed.
    // LEARN: here, due to 'by', savedSelectedIndex is a var Int, not a val MutableState<Int>.
    var savedSelectedIndex by rememberSaveable { mutableIntStateOf(selectedIndex) }

    Column {
        logD("Composable", "RadioButtonGroup > Column")
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
        )
        Spacer(modifier = Modifier.height(2.dp))

        Column(Modifier.selectableGroup()) {
            logD("Composable", "RadioButtonGroup > Column > Column")
            options.forEachIndexed { index, option ->

                val isSelected = index == savedSelectedIndex // still each row gets recomposed

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                        .wrapContentHeight()
                        .selectable(
                            selected = isSelected,
                            onClick = {
                                savedSelectedIndex = index
                                onOptionSelected(index, option)
                            },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    logD("Composable", "RadioButtonGroup > Column > Column > Row($index)")
                    RadioButton(
                        selected = isSelected,
                        onClick = null // null recommended for accessibility with screen readers
                    )
                    Text(
                        text = option,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun RadioButtonGroupPreview() {
    Study24Theme {
        RadioButtonGroup(
            "Select an option from below:",
            listOf("Option 1", "Option 2", "Option 3"),
            1
        ) { _, _ -> }
    }
}