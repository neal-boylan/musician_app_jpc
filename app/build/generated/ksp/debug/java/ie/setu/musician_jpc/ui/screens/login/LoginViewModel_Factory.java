package ie.setu.musician_jpc.ui.screens.login;

import androidx.credentials.CredentialManager;
import androidx.credentials.GetCredentialRequest;
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
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<AuthService> authServiceProvider;

  private final Provider<CredentialManager> credentialManagerProvider;

  private final Provider<GetCredentialRequest> credentialRequestProvider;

  public LoginViewModel_Factory(Provider<AuthService> authServiceProvider,
      Provider<CredentialManager> credentialManagerProvider,
      Provider<GetCredentialRequest> credentialRequestProvider) {
    this.authServiceProvider = authServiceProvider;
    this.credentialManagerProvider = credentialManagerProvider;
    this.credentialRequestProvider = credentialRequestProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(authServiceProvider.get(), credentialManagerProvider.get(), credentialRequestProvider.get());
  }

  public static LoginViewModel_Factory create(Provider<AuthService> authServiceProvider,
      Provider<CredentialManager> credentialManagerProvider,
      Provider<GetCredentialRequest> credentialRequestProvider) {
    return new LoginViewModel_Factory(authServiceProvider, credentialManagerProvider, credentialRequestProvider);
  }

  public static LoginViewModel newInstance(AuthService authService,
      CredentialManager credentialManager, GetCredentialRequest credentialRequest) {
    return new LoginViewModel(authService, credentialManager, credentialRequest);
  }
}
