package edts.android.edtscomposable.ui.component.dialog.confirmation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edts.android.edtscomposable.ui.component.button.BaseButtonComp
import edts.android.edtscomposable.ui.component.dialog.BaseDialogComp
import edts.android.edtscomposable.ui.theme.ColorFFF
import edts.android.edtscomposable.ui.theme.ColorNeutral50
import edts.android.edtscomposable.ui.theme.ColorNeutral70
import edts.android.edtscomposable.ui.theme.inter

@Composable
fun ConfirmationDialogComp(
    modifier: Modifier = Modifier,
    state: ConfirmationDialogState
) {
    val context = LocalContext.current
    BaseDialogComp(
        dismissible = state.isDismissible,
        onDismiss = { state.delegate?.onDismiss() }
    ) {
        Column(
            modifier
                .background(ColorFFF, RoundedCornerShape(8.dp))
                .padding(horizontal = 16.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = state.title,
                style = inter(fontSize = 16, weight = FontWeight.Bold),
                color = ColorNeutral70,
                textAlign = state.titleTextAlign
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                text = state.desc ?: "",
                style = inter(fontSize = 14, weight = FontWeight.Medium),
                color = ColorNeutral50,
                textAlign = state.descTextAlign
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier
                    .fillMaxWidth()
            ) {
                state.negativeText?.let {
                    BaseButtonComp(
                        modifier = Modifier
                            .weight(1f),
                        buttonType = state.negativeButtonStyle,
                        text = state.negativeText,
                        onClick = { state.delegate?.onNegative() }
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                BaseButtonComp(
                    modifier = Modifier
                        .weight(1f),
                    buttonType = state.positiveButtonStyle,
                    text = state.positiveText,
                    onClick = { state.delegate?.onPositive() }
                )
            }
        }
    }
}

@Preview
@Composable
private fun ConfirmationDialogPreview() {
    MaterialTheme {
        ConfirmationDialogComp(
            modifier = Modifier,
            state = ConfirmationDialogState(
                title = "Are you sure?",
                desc = "This action cannot be undone.",
                positiveText = "Yes",
                negativeText = "Cancel",
                delegate = null,
                isDismissible = true
            )
        )
    }
}