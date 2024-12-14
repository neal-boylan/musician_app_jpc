package ie.setu.musician_jpc.firebase.database;

import com.google.firebase.firestore.FirebaseFirestore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ie.setu.musician_jpc.firebase.services.AuthService;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class FirestoreRepository_Factory implements Factory<FirestoreRepository> {
  private final Provider<AuthService> authProvider;

  private final Provider<FirebaseFirestore> firestoreProvider;

  public FirestoreRepository_Factory(Provider<AuthService> authProvider,
      Provider<FirebaseFirestore> firestoreProvider) {
    this.authProvider = authProvider;
    this.firestoreProvider = firestoreProvider;
  }

  @Override
  public FirestoreRepository get() {
    return newInstance(authProvider.get(), firestoreProvider.get());
  }

  public static FirestoreRepository_Factory create(Provider<AuthService> authProvider,
      Provider<FirebaseFirestore> firestoreProvider) {
    return new FirestoreRepository_Factory(authProvider, firestoreProvider);
  }

  public static FirestoreRepository newInstance(AuthService auth, FirebaseFirestore firestore) {
    return new FirestoreRepository(auth, firestore);
  }
}
