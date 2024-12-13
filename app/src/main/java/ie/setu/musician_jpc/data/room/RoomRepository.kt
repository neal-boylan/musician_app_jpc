package ie.setu.musician_jpc.data.room

import ie.setu.musician_jpc.data.model.ClipModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomRepository @Inject
constructor(private val clipDAO: ClipDAO) {
    fun getAll(): Flow<List<ClipModel>> = clipDAO.getAll()

    fun get(id: Int) = clipDAO.get(id)

    suspend fun insert(clip: ClipModel)
    { clipDAO.insert(clip) }

    suspend fun update(clip: ClipModel)
    { clipDAO.update(clip.id, clip.description) }

    suspend fun delete(clip: ClipModel)
    { clipDAO.delete(clip) }
}