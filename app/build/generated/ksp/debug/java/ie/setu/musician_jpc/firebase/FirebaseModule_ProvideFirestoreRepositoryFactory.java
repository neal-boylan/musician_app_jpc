package ie.setu.musician_jpc.firebase;

import com.google.firebase.firestore.FirebaseFirestore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ie.setu.musician_jpc.firebase.services.AuthService;
import ie.setu.musician_jpc.firebase.services.FirestoreService;
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
public final class FirebaseModule_ProvideFirestoreRepositoryFactory implements Factory<FirestoreService> {
  private final Provider<AuthService> authProvider;

  private final Provider<FirebaseFirestore> firebaseFirestoreProvider;

  public FirebaseModule_ProvideFirestoreRepositoryFactory(Provider<AuthService> authProvider,
      Provider<FirebaseFirestore> firebaseFirestoreProvider) {
    this.authProvider = authProvider;
    this.firebaseFirestoreProvider = firebaseFirestoreProvider;
  }

  @Override
  public FirestoreService get() {
    return provideFirestoreRepository(authProvider.get(), firebaseFirestoreProvider.get());
  }

  public static FirebaseModule_ProvideFirestoreRepositoryFactory create(
      Provider<AuthService> authProvider, Provider<FirebaseFirestore> firebaseFirestoreProvider) {
    return new FirebaseModule_ProvideFirestoreRepositoryFactory(authProvider, firebaseFirestoreProvider);
  }

  public static FirestoreService provideFirestoreRepository(AuthService auth,
      FirebaseFirestore firebaseFirestore) {
    return Preconditions.checkNotNullFromProvides(FirebaseModule.INSTANCE.provideFirestoreRepository(auth, firebaseFirestore));
  }
}
