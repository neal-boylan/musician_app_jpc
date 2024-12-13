package ie.setu.musician_jpc.firebase.database

import ie.setu.musician_jpc.firebase.services.Clip
import ie.setu.musician_jpc.firebase.services.Clips
import ie.setu.musician_jpc.firebase.services.FirestoreService
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.dataObjects
import ie.setu.musician_jpc.data.rules.Constants.CLIP_COLLECTION
import ie.setu.musician_jpc.data.rules.Constants.USER_EMAIL
import ie.setu.musician_jpc.firebase.services.AuthService
import kotlinx.coroutines.tasks.await
import java.util.Date
import javax.inject.Inject
import com.google.firebase.firestore.toObject

class FirestoreRepository
@Inject constructor(private val auth: AuthService,
                    private val firestore: FirebaseFirestore
) : FirestoreService {

    override suspend fun getAll(email: String): Clips {

        return firestore.collection(CLIP_COLLECTION)
            .whereEqualTo(USER_EMAIL, email)
            .dataObjects()
    }

    override suspend fun get(email: String,
                             clipId: String): Clip? {
        return firestore.collection(CLIP_COLLECTION)
            .document(clipId).get().await().toObject()
    }

    override suspend fun insert(email: String,
                                clip: Clip
    )
    {
        val clipWithEmail = clip.copy(email = email)

        firestore.collection(CLIP_COLLECTION)
            .add(clipWithEmail)
            .await()

    }

    override suspend fun update(email: String,
                                clip: Clip
    )
    {
        val clipWithModifiedDate =
            clip.copy(dateModified = Date())

        firestore.collection(CLIP_COLLECTION)
            .document(clip._id)
            .set(clipWithModifiedDate).await()
    }

    override suspend fun delete(email: String,
                                clipId: String)
    {
        firestore.collection(CLIP_COLLECTION)
            .document(clipId)
            .delete().await()
    }
}