package ro.razvan.testCoroutines.ui.dogsList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ro.razvan.testCoroutines.data.Dog
import ro.razvan.testCoroutines.data.DogUseCases

class DogsListViewModel(private val dogUseCases: DogUseCases) : ViewModel() {

    private val disposables = CompositeDisposable()

    val dogs = MutableLiveData<List<Dog>>()

    init {

        setDogs()

    }

    private fun setDogs() {

        disposables.add(
                dogUseCases.getDogs()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { dogs.value = it }
        )

    }

    suspend fun deleteDog(dog: Dog): Boolean {
        return dogUseCases.deleteDog(dog)
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }


}