package edts.android.edtscomposable.ui.component.search

interface SearchBoxDelegate {
    fun onSearch(value: String)
    fun onTextChanged(value: String)
}