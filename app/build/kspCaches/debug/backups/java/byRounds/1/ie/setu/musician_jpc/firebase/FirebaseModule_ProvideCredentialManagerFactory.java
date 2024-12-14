package ie.setu.musician_jpc.firebase;

import android.content.Context;
import androidx.credentials.CredentialManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class FirebaseModule_ProvideCredentialManagerFactory implements Factory<CredentialManager> {
  private final Provider<Context> contextProvider;

  public FirebaseModule_ProvideCredentialManagerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public CredentialManager get() {
    return provideCredentialManager(contextProvider.get());
  }

  public static FirebaseModule_ProvideCredentialManagerFactory create(
      Provider<Context> contextProvider) {
    return new FirebaseModule_ProvideCredentialManagerFactory(contextProvider);
  }

  public static CredentialManager provideCredentialManager(Context context) {
    return Preconditions.checkNotNullFromProvides(FirebaseModule.INSTANCE.provideCredentialManager(context));
  }
}
