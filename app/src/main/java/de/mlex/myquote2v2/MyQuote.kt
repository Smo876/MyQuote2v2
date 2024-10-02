package de.mlex.myquote2v2

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.mlex.myquote2v2.data.Quote
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyQuote(
    items: List<Quote>,
    scrollToEnd: MutableState<Boolean>,
    pagerState: PagerState
) {
    HorizontalPager(
        state = pagerState,
    ) { index ->
        OutlinedCard(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = items[index].text,
                    fontSize = 50.sp,
                    fontStyle = FontStyle.Italic,
                    color = Color.Gray,
                    lineHeight = 50.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Text(
                    text = "-- ${items[index].author}\n${items[index].year}",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Right,
                )
            }
        }
    }
    val coroutineScope = rememberCoroutineScope()
    if (scrollToEnd.value) {
        coroutineScope.launch {
            pagerState.animateScrollToPage(items.size - 1)
        }
        scrollToEnd.value = false
    }

}
