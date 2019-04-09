package ro.razvan.testCoroutines.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ro.razvan.testCoroutines.ui.dogsList.DogsListViewModel
import ro.razvan.testCoroutines.ui.newDog.NewDogViewModel

val viewModels = module {

    viewModel { DogsListViewModel(get()) }
    viewModel { NewDogViewModel(get()) }

}