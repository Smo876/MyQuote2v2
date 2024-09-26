package de.mlex.myquote2v2

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.mlex.myquotesii.data.Quote
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyQuote(items: MutableList<Quote>, scrollToEnd: MutableIntState, deleteQuote: MutableIntState) {
    val pagerState = rememberPagerState(pageCount = { items.size })
    val page = remember { derivedStateOf { pagerState.currentPage } }
    HorizontalPager(
        state = pagerState,
    ) { index ->
        OutlinedCard(
            modifier = Modifier
                .padding(horizontal = 24.dp)
        ) {
            Column {
                Text(
                    text = items[index].text,
                    fontSize = 50.sp,
                    fontStyle = FontStyle.Italic,
                    color = Color.Gray,
                    lineHeight = 50.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                )
                Text(
                    text = "-- ${items[index].author}\n${items[index].year}",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Right,
                    modifier = Modifier
                        .padding(20.dp)
                        .align(alignment = Alignment.End)
                )
            }
        }
    }
    val coroutineScope = rememberCoroutineScope()
    when (scrollToEnd.intValue) {
        1 -> {
            coroutineScope.launch {
                pagerState.animateScrollToPage(items.size - 1)
            }
            scrollToEnd.intValue = 0
        }
    }
    when (deleteQuote.intValue) {
        1 -> {
            items.removeAt(page.value)
            deleteQuote.intValue = 0
        }
    }

}
