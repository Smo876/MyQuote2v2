package de.mlex.myquote2v2

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar() {
    Text(
        text = "Quotes",
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        color = Color.Gray,
        style = TextStyle(
            shadow = Shadow(
                color = Color.LightGray, offset = Offset(5.0f, 10.0f), blurRadius = 3f
            )
        ),
        modifier = Modifier
            .padding(12.dp)

    )


}