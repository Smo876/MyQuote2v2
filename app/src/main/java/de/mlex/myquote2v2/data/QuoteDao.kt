package de.mlex.myquote2v2.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuoteDao {
    @Query("SELECT * FROM quotes ORDER BY id ASC")
    fun getQuotes(): Flow<List<Quote>>

    @Insert
    suspend fun insertQuote(quote: Quote)

    @Query("DELETE FROM quotes WHERE id = :id")
    suspend fun deleteQuoteById(id: Int): Int

    @Delete
    suspend fun deleteQuote(quote: Quote)
}