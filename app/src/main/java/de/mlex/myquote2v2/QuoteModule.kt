package de.mlex.myquote2v2

import androidx.room.Room
import de.mlex.myquote2v2.data.AppDatabase
import de.mlex.myquote2v2.data.QuoteRepository
import de.mlex.myquote2v2.data.QuoteViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    single { Room.databaseBuilder(
        androidContext(),
        AppDatabase::class.java,
        "quotes.db"
    ).build() }

    single { QuoteRepository(get<AppDatabase>().quoteDao()) }

    viewModel {
        QuoteViewModel(get())
    }
}