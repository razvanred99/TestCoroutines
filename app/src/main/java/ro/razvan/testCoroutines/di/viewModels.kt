package ro.razvan.testCoroutines.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ro.razvan.testCoroutines.ui.dogsList.DogsListViewModel

val viewModels = module {

    viewModel { DogsListViewModel(get()) }

}