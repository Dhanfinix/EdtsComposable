package edts.android.edtscomposable.ui.component.form

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

typealias OnRadioItemClicked = (index: Int, name: String) -> Unit

@Composable
fun RadioGroupComp(
    modifier: Modifier = Modifier,
    state: RadioGroupState,
    onItemClicked: OnRadioItemClicked = { _, _ -> }
) {
    var selectedIndex by remember { mutableIntStateOf(state.currentSelectedId) }

    LazyColumn(
        modifier = modifier
    ) {
        itemsIndexed(state.items ?: emptyList()) { index, item ->
            RadioItemComp(
                 text = item,
                selected = index == selectedIndex
            ) {
                selectedIndex = index
                onItemClicked(selectedIndex, item)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RadioGroupBottom() {
    MaterialTheme {
        RadioGroupComp(
            state = (RadioGroupState(items = listOf("item 1", "item 2", "item 3")))
        ) { _, _ ->

        }
    }
}