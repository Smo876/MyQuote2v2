package de.mlex.myquote2v2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.mlex.myquote2v2.ui.theme.MyQuote2V2Theme
import de.mlex.myquotesii.data.DataProvider.quotes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyQuote2V2Theme {
                // A surface container using the 'background' color from the theme
                QuoteScreen()
            }
        }
    }
}

@Preview
@Composable
private fun QuoteScreen() {
    Surface(
        modifier = Modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        val openAlertDialog = remember { mutableIntStateOf(0) }
        Box() {
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                if (quotes.size > 0) MyQuote()
                else EmptyList()
            }
        }

//        when (openAlertDialog.intValue) {
//            1 -> {
//                DialogNewQuote(openAlertDialog)
//            }
//        }
    }

}