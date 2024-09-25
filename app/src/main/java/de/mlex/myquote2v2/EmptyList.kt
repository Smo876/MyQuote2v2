package de.mlex.myquote2v2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmptyList(modifier: Modifier = Modifier) {

    OutlinedCard(
        modifier = modifier
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
        ) {
            Text(
                text = "Add a new quote!",
                fontSize = 50.sp,
                fontStyle = FontStyle.Italic,
                color = Color.Gray,
                lineHeight = 50.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(10.dp)
            )

        }
    }
}