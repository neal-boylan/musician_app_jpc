package ie.setu.musician_jpc.ui.screens.clipList;

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
public final class ClipListViewModel_Factory implements Factory<ClipListViewModel> {
  private final Provider<FirestoreService> repositoryProvider;

  private final Provider<AuthService> authServiceProvider;

  public ClipListViewModel_Factory(Provider<FirestoreService> repositoryProvider,
      Provider<AuthService> authServiceProvider) {
    this.repositoryProvider = repositoryProvider;
    this.authServiceProvider = authServiceProvider;
  }

  @Override
  public ClipListViewModel get() {
    return newInstance(repositoryProvider.get(), authServiceProvider.get());
  }

  public static ClipListViewModel_Factory create(Provider<FirestoreService> repositoryProvider,
      Provider<AuthService> authServiceProvider) {
    return new ClipListViewModel_Factory(repositoryProvider, authServiceProvider);
  }

  public static ClipListViewModel newInstance(FirestoreService repository,
      AuthService authService) {
    return new ClipListViewModel(repository, authService);
  }
}
