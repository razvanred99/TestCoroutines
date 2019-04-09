package ro.razvan.testCoroutines.data

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface DogDao : GenericDao<Dog>{

    @Query("SELECT * FROM $DOGS")
    suspend fun getAll(): List<Dog>

    @Query("SELECT * FROM $DOGS")
    fun getAllRxStream(): Flowable<List<Dog>>

}