package edts.android.edtscomposable.ui.component.dialog.confirmation

import androidx.compose.ui.text.style.TextAlign
import edts.android.edtscomposable.ui.component.button.ButtonType

data class ConfirmationDialogState(
    val title: String,
    val desc: String?,
    val positiveText: String,
    val negativeText: String?,
    val titleTextAlign: TextAlign = TextAlign.Start,
    val descTextAlign: TextAlign = TextAlign.Start,
    val delegate: ConfirmationDialogDelegate?,
    val isDismissible: Boolean = true,
    val positiveButtonStyle: ButtonType = ButtonType.PRIMARY,
    val negativeButtonStyle: ButtonType = ButtonType.SECONDARY,
)