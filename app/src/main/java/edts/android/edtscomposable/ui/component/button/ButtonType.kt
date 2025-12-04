package edts.android.edtscomposable.ui.component.button

import edts.android.edtscomposable.ui.theme.ColorFFF
import edts.android.edtscomposable.ui.theme.ColorGrey10
import edts.android.edtscomposable.ui.theme.ColorGrey66
import edts.android.edtscomposable.ui.theme.ColorGreyE5
import edts.android.edtscomposable.ui.theme.ColorNeutral30
import edts.android.edtscomposable.ui.theme.ColorPrimary10
import edts.android.edtscomposable.ui.theme.ColorPrimary30
import edts.android.edtscomposable.ui.theme.ColorRed30
import edts.android.edtscomposable.ui.theme.ColorSemitransparent
import edts.android.edtscomposable.ui.theme.ColorSupport
import edts.android.edtscomposable.ui.theme.ColorWarning

enum class ButtonType {
    PRIMARY,
    SECONDARY {
        override val containerColor = ColorFFF
        override val contentColor = ColorPrimary30
        override val borderColor = ColorPrimary30
    },
    SECONDARY_NO_BORDER {
        override val containerColor = ColorSupport
        override val contentColor = ColorPrimary30
        override val borderColor = ColorSupport
    },
    ALTERNATIVE_ORANGE {
        override val containerColor = ColorWarning
        override val contentColor = ColorFFF
        override val borderColor = ColorWarning
    },
    ALTERNATIVE_WHITE {
        override val containerColor = ColorFFF
        override val contentColor = ColorGrey66
        override val borderColor = ColorGreyE5
    },
    DISABLED {
        override val containerColor = ColorNeutral30
        override val contentColor = ColorFFF
        override val borderColor = ColorNeutral30
        override val isEnabled = false
    },
    TRANSPARENT {
        override val containerColor = ColorSemitransparent
        override val contentColor = ColorFFF
        override val borderColor = ColorSemitransparent
    },
    TAB {
        override val containerColor = ColorGrey10
        override val contentColor = ColorGrey66
        override val borderColor = ColorGrey10
    },
    TAB_SELECTED {
        override val containerColor = ColorPrimary10
        override val contentColor = ColorPrimary30
        override val borderColor = ColorPrimary30
    },
    DANGER {
        override val containerColor = ColorRed30
        override val contentColor = ColorFFF
        override val borderColor = ColorRed30
    };

    open val containerColor = ColorPrimary30 // Button Background
    open val contentColor = ColorFFF // Button Content
    open val borderColor = ColorPrimary30 // Button Border
    open val isEnabled = true

}