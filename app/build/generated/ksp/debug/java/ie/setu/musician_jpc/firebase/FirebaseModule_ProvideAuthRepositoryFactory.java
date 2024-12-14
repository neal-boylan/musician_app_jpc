package ie.setu.musician_jpc.firebase;

import com.google.firebase.auth.FirebaseAuth;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class FirebaseModule_ProvideAuthRepositoryFactory implements Factory<AuthService> {
  private final Provider<FirebaseAuth> authProvider;

  public FirebaseModule_ProvideAuthRepositoryFactory(Provider<FirebaseAuth> authProvider) {
    this.authProvider = authProvider;
  }

  @Override
  public AuthService get() {
    return provideAuthRepository(authProvider.get());
  }

  public static FirebaseModule_ProvideAuthRepositoryFactory create(
      Provider<FirebaseAuth> authProvider) {
    return new FirebaseModule_ProvideAuthRepositoryFactory(authProvider);
  }

  public static AuthService provideAuthRepository(FirebaseAuth auth) {
    return Preconditions.checkNotNullFromProvides(FirebaseModule.INSTANCE.provideAuthRepository(auth));
  }
}
