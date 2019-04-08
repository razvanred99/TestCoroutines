package ro.razvan.testCoroutines.data

import io.reactivex.Observable

interface DogDataSource {

    suspend fun getAllSuspending(): List<Dog>

    fun getAllRxStream(): Observable<Dog>

    suspend fun insert(element: Dog): Long

    suspend fun delete(element: Dog)

}