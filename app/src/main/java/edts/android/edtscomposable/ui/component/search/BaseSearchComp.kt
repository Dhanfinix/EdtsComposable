package edts.android.edtscomposable.ui.component.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import edts.android.app.composable.R
import edts.android.edtscomposable.ui.theme.ColorNeutral40
import edts.android.edtscomposable.ui.theme.ColorNeutral70
import edts.android.edtscomposable.ui.theme.inter

@Composable
fun BaseSearchComp(
    modifier: Modifier = Modifier,
    searchBoxType: SearchBoxType = SearchBoxType.NORMAL,
    uiState: SearchBoxState,
    hint: String = "",
    delegate: SearchBoxDelegate? = null
) {
    var text by remember { mutableStateOf(uiState.text) }

    // Compare before invoking the callback to prevent multiple callback
    LaunchedEffect(text) {
        if (text != uiState.text) {
            delegate?.onTextChanged(text)
        }
    }

    BasicTextField (
        modifier = modifier
            .background(searchBoxType.bgColor, RoundedCornerShape(10.dp))
            .border(1.dp, searchBoxType.borderColor, RoundedCornerShape(10.dp))
            .padding(vertical = 6.dp, horizontal = 8.dp)
        ,
        value = text,
        textStyle = inter(fontSize = 12, weight = FontWeight.Medium, colors = ColorNeutral70),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = { delegate?.onSearch(text) }
        ),
        onValueChange = { text = it },
        decorationBox = { innerTextField ->
            Row(
                Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_search_edtscomp),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        delegate?.onSearch(text)
                    }
                )

                Spacer(Modifier.width(4.dp))

                Box(Modifier.weight(1f)) {
                    if (text.isEmpty() && hint.isNotEmpty())
                        Text(
                            hint,
                            style = inter(
                                fontSize = 12, weight = FontWeight.Medium, ColorNeutral40
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                    )
                    innerTextField()
                }
            }
        }
    )
}

@Preview
@Composable
private fun BaseSearchPreview(
    @PreviewParameter(PreviewProvider::class)
    state: SearchBoxType
) {
    MaterialTheme {
        Surface(
            Modifier.padding(4.dp)
        ) {
            BaseSearchComp(
                modifier = Modifier.padding(4.dp),
                hint = "Sample Hint",
                searchBoxType = state,
                uiState = SearchBoxState(if (state == SearchBoxType.NORMAL) "Sample Text" else "")
            )
        }
    }
}

private class PreviewProvider: PreviewParameterProvider<SearchBoxType>{
    override val values = sequenceOf(
        SearchBoxType.NORMAL,
        SearchBoxType.DISABLE,
        SearchBoxType.ERROR,
    )
}