package ie.setu.musician_jpc.firebase;

import androidx.credentials.GetCredentialRequest;
import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class FirebaseModule_GetCredentialRequestFactory implements Factory<GetCredentialRequest> {
  private final Provider<GetGoogleIdOption> googleIdOptionProvider;

  public FirebaseModule_GetCredentialRequestFactory(
      Provider<GetGoogleIdOption> googleIdOptionProvider) {
    this.googleIdOptionProvider = googleIdOptionProvider;
  }

  @Override
  public GetCredentialRequest get() {
    return getCredentialRequest(googleIdOptionProvider.get());
  }

  public static FirebaseModule_GetCredentialRequestFactory create(
      Provider<GetGoogleIdOption> googleIdOptionProvider) {
    return new FirebaseModule_GetCredentialRequestFactory(googleIdOptionProvider);
  }

  public static GetCredentialRequest getCredentialRequest(GetGoogleIdOption googleIdOption) {
    return Preconditions.checkNotNullFromProvides(FirebaseModule.INSTANCE.getCredentialRequest(googleIdOption));
  }
}
