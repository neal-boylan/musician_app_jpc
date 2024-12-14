package ie.setu.musician_jpc.ui.screens.profile;

import com.google.firebase.auth.FirebaseAuth;
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
public final class ProfileViewModel_Factory implements Factory<ProfileViewModel> {
  private final Provider<AuthService> authServiceProvider;

  private final Provider<FirebaseAuth> authProvider;

  public ProfileViewModel_Factory(Provider<AuthService> authServiceProvider,
      Provider<FirebaseAuth> authProvider) {
    this.authServiceProvider = authServiceProvider;
    this.authProvider = authProvider;
  }

  @Override
  public ProfileViewModel get() {
    return newInstance(authServiceProvider.get(), authProvider.get());
  }

  public static ProfileViewModel_Factory create(Provider<AuthService> authServiceProvider,
      Provider<FirebaseAuth> authProvider) {
    return new ProfileViewModel_Factory(authServiceProvider, authProvider);
  }

  public static ProfileViewModel newInstance(AuthService authService, FirebaseAuth auth) {
    return new ProfileViewModel(authService, auth);
  }
}
