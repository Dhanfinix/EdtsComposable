package edts.android.edtscomposable.ui.component.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import edts.android.edtscomposable.ui.theme.inter

@Composable
fun BaseButtonComp(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(12.dp),
    contentAlignment: Alignment = Alignment.Center,
    buttonRadius: Int = 8,
    buttonType: ButtonType = ButtonType.PRIMARY,
    text: String,
    textSize: Int = 12,
    @DrawableRes drawableStart: Int? = null,
    @DrawableRes drawableEnd: Int? = null,
    drawableStartSpacer: Int = 8,
    drawableEndSpacer: Int = 2,
    drawableEndFullSpacer: Boolean = false,
    onClick: () -> Unit
) {
    val containerColor = buttonType.containerColor
    val contentColor = buttonType.contentColor
    val borderColor = buttonType.borderColor
    val roundedCornerShape = RoundedCornerShape(buttonRadius.dp)

    Box(
        contentAlignment = contentAlignment,
        modifier = modifier
            .height(IntrinsicSize.Min)
            .background(
                color = containerColor,
                roundedCornerShape
            )
            .border(1.dp, borderColor, roundedCornerShape)
            .clip(roundedCornerShape)
            .clickable {
                if (buttonType.isEnabled) onClick()
            }
    ) {
        Row(
            modifier = Modifier.padding(contentPadding),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            drawableStart?.let {
                Image(
                    painter = painterResource(id = drawableStart),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(contentColor)
                )
                Spacer(modifier = Modifier.width(drawableStartSpacer.dp))
            }

            Text(
                text = text,
                style = inter(
                    fontSize = textSize,
                    weight = FontWeight.Bold,
                    colors = contentColor
                )
            )

            drawableEnd?.let {
                if (drawableEndFullSpacer) Spacer(modifier = Modifier.weight(1f))
                else Spacer(modifier = Modifier.width(drawableEndSpacer.dp))
                Image(
                    painter = painterResource(id = drawableEnd),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(contentColor)
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewButton(
    @PreviewParameter(PreviewProvider::class) buttonType: ButtonType
) {
    MaterialTheme {
        BaseButtonComp(
            modifier = Modifier.fillMaxWidth(),
            buttonType = buttonType,
            text = "Button Text",
        ) { }
    }
}

private class PreviewProvider: PreviewParameterProvider<ButtonType> {
    override val values = sequenceOf(
        ButtonType.PRIMARY,
        ButtonType.SECONDARY,
        ButtonType.SECONDARY_NO_BORDER,
        ButtonType.ALTERNATIVE_ORANGE,
        ButtonType.ALTERNATIVE_WHITE,
        ButtonType.TAB,
        ButtonType.TAB_SELECTED,
        ButtonType.DISABLED,
        ButtonType.DANGER
    )
}