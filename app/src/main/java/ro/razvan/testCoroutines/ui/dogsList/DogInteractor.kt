package ro.razvan.testCoroutines.ui.dogsList

import ro.razvan.testCoroutines.data.Dog
import ro.razvan.testCoroutines.data.DogDataSource
import ro.razvan.testCoroutines.data.DogUseCases

class DogInteractor(private val dogRepository: DogDataSource) : DogUseCases {

    override fun getDogs() = dogRepository.getAllRxStream()

    override suspend fun insertDog(dog: Dog): Boolean {
        return dogRepository.insert(dog) > 0
    }

    override suspend fun deleteDog(dog: Dog): Boolean {
        return dogRepository.delete(dog) > 0
    }

}