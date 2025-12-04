package edts.android.edtscomposable.ui.component.dialog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import edts.android.edtscomposable.ui.theme.ColorSemitransparent

@Composable
fun BaseDialogComp(
    dismissible: Boolean = true,
    useDefaultWidth: Boolean = true,
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = {
            onDismiss()
        },
        properties = DialogProperties(
            dismissOnBackPress = dismissible,
            dismissOnClickOutside = dismissible,
            usePlatformDefaultWidth = useDefaultWidth
        )
    ) {
        content()
    }
}

@Composable
fun BaseDialogOnBoxComp(
    modifier: Modifier = Modifier,
    dismissible: Boolean = true,
    onDismiss: () -> Unit,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = ColorSemitransparent,
            onClick = {
                if (dismissible){
                    onDismiss()
                }
            }
        ) {}
        content()
    }
}