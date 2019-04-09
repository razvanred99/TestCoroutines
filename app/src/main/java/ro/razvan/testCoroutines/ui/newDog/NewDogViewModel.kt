package ro.razvan.testCoroutines.ui.newDog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ro.razvan.testCoroutines.data.Dog
import ro.razvan.testCoroutines.data.DogUseCases

class NewDogViewModel(private val dogUseCases: DogUseCases) : ViewModel() {

    val name = MutableLiveData<String>()

    suspend fun save(): Boolean {

        val name = name.value ?: return false

        return dogUseCases.insertDog(Dog(name))
    }

}