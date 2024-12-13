package ie.setu.musician_jpc.firebase.services

import ie.setu.musician_jpc.data.model.ClipModel
import kotlinx.coroutines.flow.Flow

typealias Clip = ClipModel
typealias Clips = Flow<List<Clip>>

interface FirestoreService {

    suspend fun getAll(email: String) : Clips
    suspend fun get(email: String, donationId: String) : Clip?
    suspend fun insert(email: String, donation: Clip)
    suspend fun update(email: String, donation: Clip)
    suspend fun delete(email: String, donationId: String)
}