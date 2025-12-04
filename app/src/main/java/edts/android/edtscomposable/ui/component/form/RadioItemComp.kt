package edts.android.edtscomposable.ui.component.form

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edts.android.edtscomposable.ui.theme.ColorFFF
import edts.android.edtscomposable.ui.theme.ColorNeutral40
import edts.android.edtscomposable.ui.theme.ColorPrimary30
import edts.android.edtscomposable.ui.theme.inter

@Composable
fun RadioItemComp(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    extraComp: @Composable (() -> Unit)? = null,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(16.dp)
                .border(
                    width = 1.dp,
                    color = if (selected) ColorPrimary30 else ColorNeutral40,
                    shape = CircleShape
                )
                .background(
                    color = if (selected) ColorPrimary30 else ColorFFF,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            if (selected) {
                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .background(ColorFFF, CircleShape)
                )
            }
        }

        Spacer(Modifier.width(12.dp))

        Text(
            text = text,
            style = inter(
                fontSize = 16,
                weight = FontWeight.Medium
            )
        )

        extraComp?.let {
            Spacer(Modifier.width(8.dp))

            extraComp()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SelectableBulletItemPrev() {
    MaterialTheme {
        RadioItemComp(
            modifier = Modifier,
            text = "Selectable Bullet",
            selected = false
        ) { }
    }
}