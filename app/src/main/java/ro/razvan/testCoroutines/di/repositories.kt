package ro.razvan.testCoroutines.di

import org.koin.dsl.module
import ro.razvan.testCoroutines.data.DogDataSource
import ro.razvan.testCoroutines.data.DogLocalDataSource

val repositories = module {

    single { DogLocalDataSource(get()) as DogDataSource }

}