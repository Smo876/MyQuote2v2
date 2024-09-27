package de.mlex.myquote2v2.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {
    @Query("SELECT * FROM quotes ORDER BY id ASC")
    fun getQuotes(): List<Quote>

    @Insert
    suspend fun insertQuote(quote: Quote)

    @Query("DELETE FROM quotes WHERE id = :id")
    fun deleteQuoteById(id: Long): Int

    //@Delete
    //fun delete(quote: Quote)
}