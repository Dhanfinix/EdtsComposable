package edts.android.edtscomposable.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun inter(
    fontSize: Int,
    weight: FontWeight = FontWeight.Normal,
    colors: Color = MaterialTheme.colorScheme.onSurface,
    fontStyle: FontStyle? = null,
    textDecoration: TextDecoration? = null
) = TextStyle(
    color = colors,
    fontSize = fontSize.sp,
    fontFamily = InterFamily,
    fontWeight = weight,
    fontStyle = fontStyle,
    textDecoration = textDecoration
)

@Composable
fun rubik(
    fontSize: Int,
    weight: FontWeight = FontWeight.Normal,
    colors: Color = MaterialTheme.colorScheme.onSurface
) = TextStyle(
    color = colors,
    fontSize = fontSize.sp,
    fontFamily = RubikFamily,
    fontWeight = weight
)