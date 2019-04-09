package ro.razvan.testCoroutines.di

import org.koin.dsl.module
import ro.razvan.testCoroutines.data.DogUseCases
import ro.razvan.testCoroutines.ui.dogsList.DogInteractor

val useCases = module {

    single { DogInteractor(get()) as DogUseCases }

}