package ro.razvan.testCoroutines.data

import io.reactivex.Observable

class DogLocalDataSource(private val dogDao: DogDao) : DogDataSource {

    override suspend fun getAllSuspending(): List<Dog> {
        return dogDao.getAll()
    }

    override suspend fun insert(element: Dog): Long {
        return dogDao.insert(element)
    }

    override suspend fun delete(element: Dog) {
        return dogDao.delete(element)
    }

    override fun getAllRxStream(): Observable<Dog> {
        return dogDao.getAllRxStream()
    }

}