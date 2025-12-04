package edts.android.edtscomposable.ui.component.bottomsheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import edts.android.app.composable.R
import edts.android.edtscomposable.ui.component.divider.DividerComp
import edts.android.edtscomposable.ui.theme.ColorFFF
import edts.android.edtscomposable.ui.theme.ColorNeutral70
import edts.android.edtscomposable.ui.theme.inter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseBottomSheetComp(
    modifier: Modifier = Modifier,
    uiState: BaseBottomSheetState?,
    onDismiss: () -> Unit
) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val maxHeight = screenHeight * (uiState?.maxHeightRatio ?: 0.8f)
    var sheetHeight by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = uiState?.shouldOverflow == true || uiState?.skipPartialExpand == true || uiState?.wrapContent == true,
        confirmValueChange = { target ->
            if (uiState?.isDismissible == true) {
                true
            } else {
                target != SheetValue.Hidden
            }
        }
    )

    val properties = ModalBottomSheetDefaults.properties(
        shouldDismissOnBackPress = uiState?.isDismissible == true,
    )

    ModalBottomSheet(
        modifier = modifier,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        containerColor = ColorFFF,
        onDismissRequest = { onDismiss() },
        dragHandle = {},
        sheetState = sheetState,
        properties = properties
    ) {
        uiState?.let {
            val containerModifier =
                if (it.wrapContent) Modifier else Modifier.heightIn(max = maxHeight)

            Box(modifier = containerModifier) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    androidx.compose.foundation.layout.Column(modifier = Modifier.fillMaxWidth()) {
                        it.title?.let { title ->
                            Row(
                                Modifier.padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    modifier = Modifier.weight(1f),
                                    text = stringResource(title),
                                    style = inter(
                                        fontSize = 16,
                                        weight = FontWeight.Bold,
                                        colors = ColorNeutral70
                                    )
                                )
                                Icon(
                                    modifier = Modifier.clickable { onDismiss() },
                                    painter = painterResource(id = R.drawable.ic_close_edtscomp),
                                    contentDescription = null
                                )
                            }

                            DividerComp()
                        }

                        if (it.shouldOverflow) {
                            Box(modifier = Modifier.weight(1f)) {
                                it.contentComp(this@Column)
                            }
                        } else {
                            it.contentComp(this)
                        }

                        uiState.footerComp?.invoke(this)
                    }
                }
            }
        }
    }
}