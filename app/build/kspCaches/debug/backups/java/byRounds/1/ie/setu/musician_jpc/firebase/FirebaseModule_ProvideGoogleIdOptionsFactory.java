package ie.setu.musician_jpc.firebase;

import android.app.Application;
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
public final class FirebaseModule_ProvideGoogleIdOptionsFactory implements Factory<GetGoogleIdOption> {
  private final Provider<Application> appProvider;

  public FirebaseModule_ProvideGoogleIdOptionsFactory(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public GetGoogleIdOption get() {
    return provideGoogleIdOptions(appProvider.get());
  }

  public static FirebaseModule_ProvideGoogleIdOptionsFactory create(
      Provider<Application> appProvider) {
    return new FirebaseModule_ProvideGoogleIdOptionsFactory(appProvider);
  }

  public static GetGoogleIdOption provideGoogleIdOptions(Application app) {
    return Preconditions.checkNotNullFromProvides(FirebaseModule.INSTANCE.provideGoogleIdOptions(app));
  }
}
