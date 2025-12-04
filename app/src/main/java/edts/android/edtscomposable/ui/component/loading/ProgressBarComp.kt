package edts.android.edtscomposable.ui.component.loading

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edts.android.edtscomposable.ui.theme.ColorPrimary10
import edts.android.edtscomposable.ui.theme.ColorPrimary30

@Composable
fun ProgressBarComp(
    modifier: Modifier = Modifier,
    height: Int = 8,
    baseColor: Color = ColorPrimary10,
    progressColor: Color = ColorPrimary30,
    shape: Shape = RoundedCornerShape(8.dp),
    progressPercentage: Float, /** Must Be <= 1.0 */
    initialPercentage: Float = 0f
) {
    var baseWidthPx by remember { mutableFloatStateOf(initialPercentage) }
    val density = LocalDensity.current

    val animatedProgress by animateFloatAsState(
        targetValue = progressPercentage.coerceIn(0f, 1f),
        animationSpec = tween(durationMillis = 200),
        label = "progress animation"
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height.dp)
            .background(
                color = baseColor,
                shape = shape
            )
            .onGloballyPositioned {
                baseWidthPx = it.size.width.toFloat()
            }
    ) {
        val progressWidthPx = baseWidthPx * animatedProgress
        val progressWidthDp = with(density) { progressWidthPx.toDp() }

        Box(
            modifier = Modifier
                .width(progressWidthDp)
                .height(height.dp)
                .background(
                    color = progressColor,
                    shape = shape
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProgressBarPrev() {
    MaterialTheme {
        ProgressBarComp(
            modifier = Modifier
                .padding(8.dp),
            progressPercentage = 0.3f
        )
    }
}