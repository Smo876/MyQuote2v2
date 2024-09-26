package de.mlex.myquote2v2.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {
    @Query("SELECT * FROM quotes ORDER BY id ASC")
    fun getQuotes(): LiveData<List<Quote>>

    @Insert
    suspend fun insert(quote: Quote)

    @Query("DELETE FROM quotes WHERE id = :id")
    fun deleteQuote(id: Long) : Int
}