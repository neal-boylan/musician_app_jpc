package ie.setu.musician_jpc.firebase.database

import android.net.Uri
import androidx.browser.customtabs.CustomTabsClient.getPackageName
import com.google.firebase.auth.UserProfileChangeRequest
import ie.setu.musician_jpc.firebase.services.Clip
import ie.setu.musician_jpc.firebase.services.Clips
import ie.setu.musician_jpc.firebase.services.FirestoreService
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.dataObjects
import ie.setu.musician_jpc.data.rules.Constants.CLIP_COLLECTION
import ie.setu.musician_jpc.data.rules.Constants.USER_EMAIL
import ie.setu.musician_jpc.data.rules.Constants.TITLE
import ie.setu.musician_jpc.firebase.services.AuthService
import kotlinx.coroutines.tasks.await
import java.util.Date
import javax.inject.Inject
import com.google.firebase.firestore.toObject
import ie.setu.musician_jpc.R
import ie.setu.musician_jpc.firebase.auth.Response
import ie.setu.musician_jpc.firebase.services.StorageService
import timber.log.Timber

class FirestoreRepository
@Inject constructor(private val auth: AuthService,
                    private val firestore: FirebaseFirestore,
                    private val storageService: StorageService
) : FirestoreService {

    override suspend fun getAll(email: String): Clips {
        return firestore.collection(CLIP_COLLECTION)
            .whereEqualTo(USER_EMAIL, email)
            .dataObjects()
    }

    override suspend fun getSearch(searchText: String): Clips {

        return firestore.collection(CLIP_COLLECTION)
//            .whereEqualTo(TITLE, searchText.lowercase())
//            .dataObjects()

            .whereGreaterThanOrEqualTo(TITLE, searchText)
            .whereLessThan(TITLE, searchText +'z')
            .dataObjects()
    }

    override suspend fun getAllClips(): Clips {

        return firestore.collection(CLIP_COLLECTION)
            .dataObjects()
    }

    override suspend fun get(email: String,
                             clipId: String): Clip? {
        return firestore.collection(CLIP_COLLECTION)
            .document(clipId).get().await().toObject()
    }

    override suspend fun insert(email: String, clip: Clip)
    {
        val uri = Uri.parse("android.resource://ie.setu.musician_jpc/" + R.raw.guitar)

        val clipWithEmailAndImage =
            clip.copy(
                email = email,
                imageUri = auth.customPhotoUri!!.toString(),
                videoURI = uploadCustomVideoUri(uri).toString()
            )

        firestore.collection(CLIP_COLLECTION)
            .add(clipWithEmailAndImage)
            .await()

    }

    override suspend fun update(email: String, clip: Clip)
    {
        val uri = Uri.parse("android.resource://ie.setu.musician_jpc/" + R.raw.guitar)
        val clipWithModifiedDate =
            clip.copy(
                dateModified = Date(),
                videoURI = uploadCustomVideoUri(uri).toString()
            ) //uri.toString())

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

    override suspend fun updatePhotoUris(email: String, uri: Uri) {

        firestore.collection(CLIP_COLLECTION)
            .whereEqualTo(USER_EMAIL, email)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    Timber.i("FSR Updating ID ${document.id}")
                    firestore.collection(CLIP_COLLECTION)
                        .document(document.id)
                        .update("imageUri", uri.toString())
                }
            }
            .addOnFailureListener { exception ->
                Timber.i("Error $exception")
            }
    }

    private suspend fun uploadCustomVideoUri(uri: Uri) : Uri {
        if (uri.toString().isNotEmpty()) {
            val urlTask = storageService.uploadFile(uri = uri, "videos")
            val url = urlTask.addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Timber.e("task not successful: ${task.exception}")
                }
            }.await()
            return url
        }
        return Uri.EMPTY
    }

}