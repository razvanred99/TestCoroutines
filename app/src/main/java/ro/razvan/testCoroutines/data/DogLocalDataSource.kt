package ro.razvan.testCoroutines.data

class DogLocalDataSource(private val dogDao: DogDao) : DogDataSource {

    override suspend fun getAllSuspending(): List<Dog> {
        return dogDao.getAll()
    }

    override suspend fun insert(element: Dog): Long {
        return dogDao.insert(element)
    }

    override suspend fun delete(element: Dog) = dogDao.delete(element)

    override fun getAllRxStream() = dogDao.getAllRxStream()

}