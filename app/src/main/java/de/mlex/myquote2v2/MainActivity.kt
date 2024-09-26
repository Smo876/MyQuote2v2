package de.mlex.myquote2v2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "MutableCollectionMutableState")
@Preview
@Composable
private fun QuoteScreen() {
    Surface(
        modifier = Modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        val items by remember { mutableStateOf(quotes) }
        val openAlertDialog = remember { mutableIntStateOf(0) }
        Scaffold(bottomBar = { Buttons(openAlertDialog) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                if (quotes.size > 0) MyQuote(items)
                else EmptyList()
            }
        }

        when (openAlertDialog.intValue) {
            1 -> {
                DialogNewQuote(openAlertDialog)
            }
        }
    }

}