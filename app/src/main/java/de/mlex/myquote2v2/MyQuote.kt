package de.mlex.myquote2v2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.mlex.myquotesii.data.Quote


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyQuote(items: List<Quote>) {
    val pagerState = rememberPagerState(pageCount = { items.size })

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
}
