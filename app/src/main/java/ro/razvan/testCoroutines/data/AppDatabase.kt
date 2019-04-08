package ro.razvan.testCoroutines.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
        version = 1,
        entities = [Dog::class],
        exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dogDao(): DogDao

}