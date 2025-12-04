package edts.android.edtscomposable.ui.component.dialog.confirmation

interface ConfirmationDialogDelegate {
    fun onDismiss() {}
    fun onPositive() {}
    fun onNegative() {}
}