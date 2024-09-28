package de.mlex.myquote2v2.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class QuoteViewModel(appObj: Application) : AndroidViewModel(appObj) {

    private val quoteRepository: QuoteRepository = QuoteRepository(appObj)
    fun getQuotes(): List<Quote> {
        return quoteRepository.readAllQuotes
    }

    fun insertQuote(quote: Quote) {
        viewModelScope.launch {
            quoteRepository.insertQuote(quote = quote)
        }

    }

    fun deleteQuoteById(id: Long) {
        viewModelScope.launch {
            quoteRepository.deleteQuoteById(id)
        }

    }

}