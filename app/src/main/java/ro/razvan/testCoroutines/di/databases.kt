package ro.razvan.testCoroutines.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import ro.razvan.testCoroutines.data.AppDatabase

val databases = module {

    single { Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "DogsDatabase.db").build() }

}