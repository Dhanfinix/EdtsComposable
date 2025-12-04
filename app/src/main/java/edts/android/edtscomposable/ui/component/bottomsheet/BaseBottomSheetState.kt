package edts.android.edtscomposable.ui.component.bottomsheet

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable

data class BaseBottomSheetState(
    val shouldOverflow: Boolean = false, /** Handle if content is scrollable with sticky footer **/
    val skipPartialExpand: Boolean = false, /** Set true for bottom sheet to fully displayed instantly */
    val maxHeightRatio: Float = 0.8f, /** Max height for the whole bottom sheet contrast to screen height **/
    val isDismissible: Boolean = true,
    val wrapContent: Boolean = false,

    @get:StringRes val title: Int? = null,
    val contentComp: @Composable (ColumnScope.() -> Unit),
    val footerComp: @Composable ((ColumnScope.() -> Unit))? = null,
    val onDismiss: () -> Unit = {}
)