package de.mlex.myquote2v2.data

import kotlinx.coroutines.flow.Flow

class QuoteRepository(private val quoteDao: QuoteDao) {

    val readAllQuotes: Flow<List<Quote>> = quoteDao.getQuotes()

    suspend fun insertQuote(quote: Quote) {
        quoteDao.insertQuote(quote)
    }

    suspend fun deleteQuote(quote: Quote) = quoteDao.deleteQuote(quote)

}