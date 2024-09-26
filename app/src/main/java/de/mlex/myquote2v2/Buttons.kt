package de.mlex.myquote2v2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Buttons(openAddQuoteDialog: MutableIntState) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.End
    ) {
        IconButton(onClick = { openAddQuoteDialog.intValue = 1 }) {
            Icon(
                Icons.Filled.AddCircle,
                contentDescription = "Add",
                tint = androidx.compose.ui.graphics.Color.Gray,
                modifier = Modifier.size(30.dp)
            )
        }

        IconButton(
            onClick = {
                //DataProvider.quotes.removeAt(index.intValue)
                //if (DataProvider.quotes.size > 0 && index.intValue == DataProvider.quotes.size) index.intValue--
                //model.deleteQuote(index)
            }) {
            Icon(
                Icons.Filled.Delete,
                contentDescription = "Add",
                tint = androidx.compose.ui.graphics.Color.Gray,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}


