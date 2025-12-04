package edts.android.edtscomposable.ui.component.tab

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import edts.android.edtscomposable.ui.theme.ColorFFF
import edts.android.edtscomposable.ui.theme.ColorGrey66
import edts.android.edtscomposable.ui.theme.ColorPrimary30
import edts.android.edtscomposable.ui.theme.inter

@Composable
fun BaseTabComponent(
    modifier: Modifier = Modifier,
    tabs: List<String>,
    uiState: BaseTabState?,
    onTabSelected: (Int) -> Unit
) {
    val selectedTabIndex = uiState?.index ?: 0

    SecondaryTabRow(
        modifier = modifier,
        selectedTabIndex = selectedTabIndex,
        contentColor = ColorPrimary30,
        containerColor = ColorFFF,
    ) {
        tabs.forEachIndexed { index, title ->
            val isSelected = selectedTabIndex == index
            Tab(
                selected = isSelected,
                onClick = { onTabSelected(index) },
                text = {
                    Text(
                        text = title,
                        style = inter(
                            fontSize = 14,
                            weight = FontWeight.Bold,
                            colors = if (isSelected) ColorPrimary30 else ColorGrey66
                        )
                    )
                }
            )
        }
    }
}

@Preview
@Composable
private fun BaseTabPrev() {
    MaterialTheme {
        BaseTabComponent(
            tabs = listOf("Laporan Planogram", "Daftar Modis"),
            uiState = BaseTabState(1),
        ) { }
    }
}