package ie.setu.musician_jpc.ui.screens.details;

import androidx.lifecycle.SavedStateHandle;
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
public final class DetailsViewModel_Factory implements Factory<DetailsViewModel> {
  private final Provider<FirestoreService> repositoryProvider;

  private final Provider<AuthService> authServiceProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public DetailsViewModel_Factory(Provider<FirestoreService> repositoryProvider,
      Provider<AuthService> authServiceProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.repositoryProvider = repositoryProvider;
    this.authServiceProvider = authServiceProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public DetailsViewModel get() {
    return newInstance(repositoryProvider.get(), authServiceProvider.get(), savedStateHandleProvider.get());
  }

  public static DetailsViewModel_Factory create(Provider<FirestoreService> repositoryProvider,
      Provider<AuthService> authServiceProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new DetailsViewModel_Factory(repositoryProvider, authServiceProvider, savedStateHandleProvider);
  }

  public static DetailsViewModel newInstance(FirestoreService repository, AuthService authService,
      SavedStateHandle savedStateHandle) {
    return new DetailsViewModel(repository, authService, savedStateHandle);
  }
}
