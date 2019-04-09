package ro.razvan.testCoroutines.data

import io.reactivex.Flowable

interface DogUseCases {

    fun getDogs(): Flowable<List<Dog>>

    suspend fun insertDog(dog: Dog): Boolean

    suspend fun deleteDog(dog: Dog): Boolean

}