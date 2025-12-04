package edts.android.edtscomposable.ui.component.search

import edts.android.edtscomposable.ui.theme.ColorFFF
import edts.android.edtscomposable.ui.theme.ColorNeutral20
import edts.android.edtscomposable.ui.theme.ColorNeutral30
import edts.android.edtscomposable.ui.theme.ColorRed40
import edts.android.edtscomposable.ui.theme.ColorWeak

enum class SearchBoxType {
    NORMAL,
    DISABLE{
        override val bgColor = ColorNeutral20
        override val borderColor = ColorNeutral20
    },
    ERROR{
        override val bgColor = ColorWeak
        override val borderColor = ColorRed40
    };
    open val bgColor = ColorFFF
    open val borderColor = ColorNeutral30
}