package ie.setu.musician_jpc.data.api

import ie.setu.musician_jpc.data.model.ClipModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RetrofitRepository @Inject
constructor(private val serviceApi: ClipService)  {

    suspend fun getAll(email: String): List<ClipModel>
    {
        return withContext(Dispatchers.IO) {
            val clips = serviceApi.getall(email)
            clips.body() ?: emptyList()
        }
    }

    suspend fun get(email: String, id: String): List<ClipModel>
    {
        return withContext(Dispatchers.IO) {
            val clip = serviceApi.get(email, id)
            clip.body() ?: emptyList()
        }
    }

    suspend fun insert(email: String, clip: ClipModel) : ClipWrapper
    {
        return withContext(Dispatchers.IO) {
            val wrapper = serviceApi.post(email, clip)
            wrapper
        }
    }

    suspend fun update(email: String, clip: ClipModel) : ClipWrapper
    {
        return withContext(Dispatchers.IO) {
            val wrapper = serviceApi.put(email, clip._id,clip)
            wrapper
        }
    }

    suspend fun delete(email: String, clip: ClipModel) : ClipWrapper
    {
        return withContext(Dispatchers.IO) {
            val wrapper = serviceApi.delete(email, clip._id)
            wrapper
        }
    }
}