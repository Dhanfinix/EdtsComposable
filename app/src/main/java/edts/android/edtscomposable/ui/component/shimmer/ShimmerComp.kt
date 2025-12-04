package edts.android.edtscomposable.ui.component.shimmer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun ShimmerComp(
    modifier: Modifier = Modifier,
    height: Dp = 15.dp
) {
    Box(
        modifier
            .height(height)
            .shimmer()
    )
}

@Composable
fun ShimmerRandomWidthComp(
    modifier: Modifier = Modifier,
    height: Dp = 15.dp,
) {
    val ownedNumbers = listOf(100, 150, 175, 200)
    val randomIndex = Random.nextInt(ownedNumbers.size)
    val shimmerModifier = modifier.width(ownedNumbers[randomIndex].dp)

    Box(
        shimmerModifier
            .height(height)
            .shimmer()
    )
}