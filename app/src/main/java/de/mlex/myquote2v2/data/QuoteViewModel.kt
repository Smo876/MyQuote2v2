package de.mlex.myquote2v2.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class QuoteViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    val quotes: StateFlow<List<Quote>> = quoteRepository.readAllQuotes.onEach(::println).stateIn(
        viewModelScope,
        SharingStarted.Lazily, emptyList()
    )

    fun insertQuote(quote: Quote) {
        viewModelScope.launch {
            quoteRepository.insertQuote(quote = quote)
        }
    }

    fun deleteQuote(quote: Quote) {
        viewModelScope.launch {
            quoteRepository.deleteQuote(quote)
        }
    }
}