package ie.setu.musician_jpc.data.repository

import ie.setu.musician_jpc.data.ClipModel
import ie.setu.musician_jpc.data.room.ClipDAO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomRepository @Inject
constructor(private val clipDAO: ClipDAO) {
    fun getAll(): Flow<List<ClipModel>>
            = clipDAO.getAll()

    suspend fun insert(donation: ClipModel)
    { clipDAO.insert(donation) }

    suspend fun update(donation: ClipModel)
    { clipDAO.update(donation) }

    suspend fun delete(donation: ClipModel)
    { clipDAO.delete(donation) }
}