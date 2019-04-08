package ro.razvan.testCoroutines.data

import androidx.room.Entity
import androidx.room.PrimaryKey

const val DOGS = "DOGS"

@Entity(tableName = DOGS)
data class Dog(val name: String){

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}