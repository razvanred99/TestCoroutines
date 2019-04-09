package ro.razvan.testCoroutines.data

import io.reactivex.Flowable

interface DogDataSource {

    suspend fun getAllSuspending(): List<Dog>

    fun getAllRxStream(): Flowable<List<Dog>>

    suspend fun insert(element: Dog): Long

    suspend fun delete(element: Dog): Int

}