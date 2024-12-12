package ie.setu.musician_jpc.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ie.setu.musician_jpc.data.ClipModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ClipDAO {
    @Query("SELECT * FROM clipmodel")
    fun getAll(): Flow<List<ClipModel>>

    @Insert
    suspend fun insert(clip: ClipModel)

    @Query("UPDATE clipmodel SET description=:description WHERE id = :id")
    suspend fun update(id: Int, description:String)

    @Delete
    suspend fun delete(clip: ClipModel)

    @Query("SELECT * FROM clipmodel WHERE id=:id")
    fun get(id: Int): Flow<ClipModel>
}