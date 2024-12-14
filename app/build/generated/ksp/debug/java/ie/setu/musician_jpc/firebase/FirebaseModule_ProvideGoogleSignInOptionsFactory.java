package ie.setu.musician_jpc.firebase;

import android.app.Application;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
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
public final class FirebaseModule_ProvideGoogleSignInOptionsFactory implements Factory<GoogleSignInOptions> {
  private final Provider<Application> appProvider;

  public FirebaseModule_ProvideGoogleSignInOptionsFactory(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public GoogleSignInOptions get() {
    return provideGoogleSignInOptions(appProvider.get());
  }

  public static FirebaseModule_ProvideGoogleSignInOptionsFactory create(
      Provider<Application> appProvider) {
    return new FirebaseModule_ProvideGoogleSignInOptionsFactory(appProvider);
  }

  public static GoogleSignInOptions provideGoogleSignInOptions(Application app) {
    return Preconditions.checkNotNullFromProvides(FirebaseModule.INSTANCE.provideGoogleSignInOptions(app));
  }
}
