package ie.setu.musician_jpc.ui.screens.clip;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class ClipViewModel_Factory implements Factory<ClipViewModel> {
  private final Provider<FirestoreService> repositoryProvider;

  private final Provider<AuthService> authServiceProvider;

  public ClipViewModel_Factory(Provider<FirestoreService> repositoryProvider,
      Provider<AuthService> authServiceProvider) {
    this.repositoryProvider = repositoryProvider;
    this.authServiceProvider = authServiceProvider;
  }

  @Override
  public ClipViewModel get() {
    return newInstance(repositoryProvider.get(), authServiceProvider.get());
  }

  public static ClipViewModel_Factory create(Provider<FirestoreService> repositoryProvider,
      Provider<AuthService> authServiceProvider) {
    return new ClipViewModel_Factory(repositoryProvider, authServiceProvider);
  }

  public static ClipViewModel newInstance(FirestoreService repository, AuthService authService) {
    return new ClipViewModel(repository, authService);
  }
}
