package ie.setu.musician_jpc.firebase.services

import ie.setu.musician_jpc.data.model.ClipModel
import kotlinx.coroutines.flow.Flow

typealias Clip = ClipModel
typealias Clips = Flow<List<Clip>>

interface FirestoreService {

    suspend fun getAll(email: String) : Clips
    suspend fun get(email: String, clipId: String) : Clip?
    suspend fun insert(email: String, clip: Clip)
    suspend fun update(email: String, clip: Clip)
    suspend fun delete(email: String, clipId: String)
}