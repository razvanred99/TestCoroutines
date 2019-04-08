package ro.razvan.testCoroutines.di

import org.koin.dsl.module
import ro.razvan.testCoroutines.data.AppDatabase

val daos = module {

    single { get<AppDatabase>().dogDao() }

}