package de.mlex.myquote2v2.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class Quote(
    val text: String,
    val author: String,
    val year: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)