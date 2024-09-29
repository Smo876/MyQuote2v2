package de.mlex.myquote2v2.data

import android.app.Application
import kotlinx.coroutines.flow.Flow

class QuoteRepository(application: Application) {
    private var quoteDao: QuoteDao

    init {
        val database = AppDatabase.getDatabase(application)
        quoteDao = database.quoteDao()
    }

    val readAllQuotes: Flow<List<Quote>> = quoteDao.getQuotes()
    suspend fun insertQuote(quote: Quote) {
        quoteDao.insertQuote(quote)
    }

    suspend fun deleteQuoteById(id: Int) {
        quoteDao.deleteQuoteById(id)
    }

    init {
        val database = AppDatabase.getDatabase(application)
        quoteDao = database.quoteDao()
    }
}