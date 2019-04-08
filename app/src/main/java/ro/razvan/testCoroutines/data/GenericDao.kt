package ro.razvan.testCoroutines.data

import androidx.room.Delete
import androidx.room.Insert

interface GenericDao<T> {

    @Insert
    suspend fun insert(element: T): Long

    @Delete
    suspend fun delete(element: T)

}