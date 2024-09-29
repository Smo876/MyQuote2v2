package de.mlex.myquote2v2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import de.mlex.myquote2v2.data.QuoteViewModel
import de.mlex.myquote2v2.ui.theme.MyQuote2V2Theme
import org.koin.android.ext.koin.androidContext
import org.koin.compose.koinInject
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        startKoin {
            androidContext(this@MainActivity)
            modules(androidModule)
        }
        setContent {
            MyQuote2V2Theme {
                // A surface container using the 'background' color from the theme
                QuoteScreen()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "MutableCollectionMutableState")
@Composable
private fun QuoteScreen() {
    Surface(
        modifier = Modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        val quoteViewModel = koinInject<QuoteViewModel>()
        val items by quoteViewModel.quotes.collectAsState()
        //val items = remember { mutableStateListOf<Quote>() }
        val openAlertDialog = remember { mutableIntStateOf(0) }
        val scrollToEnd = remember { mutableStateOf(false) }
        val listIsNotEmpty = remember { mutableStateOf(items.isNotEmpty()) }
        val pagerState = rememberPagerState(pageCount = { items.size })
        Scaffold(
            topBar = { TopBar() },
            bottomBar = { Buttons(openAlertDialog, items) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                if (items.isNotEmpty()) MyQuote(
                    items,
                    scrollToEnd,
                    pagerState
                )
                else EmptyList()
            }
        }

        when (openAlertDialog.intValue) {
            1 -> DialogNewQuote(openAlertDialog, scrollToEnd, listIsNotEmpty) {
                quoteViewModel.insertQuote(it)
            }

            2 -> DialogDeleteQuote(openAlertDialog) {
                quoteViewModel.deleteQuote(items[pagerState.currentPage])
            }
        }
    }
}