package edts.android.edtscomposable.ui.component.divider

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import edts.android.edtscomposable.ui.theme.ColorNeutral30

@Composable
fun DividerComp(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = ColorNeutral30,
    isHorizontal: Boolean = true
) {
    if (isHorizontal) {
        HorizontalDivider(
            modifier = modifier,
            thickness = thickness,
            color = color
        )
    }
    else {
        VerticalDivider(
            modifier = modifier,
            thickness = thickness,
            color = color
        )
    }
}