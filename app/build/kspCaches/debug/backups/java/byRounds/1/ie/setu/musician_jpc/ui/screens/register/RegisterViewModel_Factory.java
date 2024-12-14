package ie.setu.musician_jpc.ui.screens.register;

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
public final class RegisterViewModel_Factory implements Factory<RegisterViewModel> {
  private final Provider<FirebaseAuth> authProvider;

  private final Provider<AuthService> authServiceProvider;

  public RegisterViewModel_Factory(Provider<FirebaseAuth> authProvider,
      Provider<AuthService> authServiceProvider) {
    this.authProvider = authProvider;
    this.authServiceProvider = authServiceProvider;
  }

  @Override
  public RegisterViewModel get() {
    return newInstance(authProvider.get(), authServiceProvider.get());
  }

  public static RegisterViewModel_Factory create(Provider<FirebaseAuth> authProvider,
      Provider<AuthService> authServiceProvider) {
    return new RegisterViewModel_Factory(authProvider, authServiceProvider);
  }

  public static RegisterViewModel newInstance(FirebaseAuth auth, AuthService authService) {
    return new RegisterViewModel(auth, authService);
  }
}
