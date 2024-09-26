package de.mlex.myquote2v2

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import de.mlex.myquotesii.data.DataProvider.quotes
import de.mlex.myquotesii.data.Quote

@Composable
fun DialogNewQuote(openAlertDialog: MutableIntState, scrollToEnd: MutableIntState, listIsNotEmpty: MutableState<Boolean>) {
    val context = LocalContext.current
    var quote by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }

    Dialog(onDismissRequest = { }) {
        Card(
            modifier = Modifier
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Text(
                    text = "Enter a new quote:",
                    modifier = Modifier.padding(16.dp),
                )
                TextField(
                    value = quote,
                    onValueChange = { quote = it },
                    label = { Text("Quote") },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value = author,
                    onValueChange = { author = it },
                    label = { Text("Author") },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value = year,
                    onValueChange = { year = it },
                    label = { Text("Year") },
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TextButton(
                        onClick = { openAlertDialog.intValue = 0 },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Dismiss")
                    }
                    TextButton(
                        onClick = {
                            if (quote == "") {
                                Toast.makeText(
                                    context,
                                    "You have to enter a quote!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                if (author == "") author = "unknown"
                                if (year == "") year = "unknown"
                                quotes.add(
                                    Quote(quote, author, year)
                                )
                                scrollToEnd.intValue = 1
                                openAlertDialog.intValue = 0
                                listIsNotEmpty.value = true

                            }
                        },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Confirm")
                    }
                }
            }
        }
    }
}