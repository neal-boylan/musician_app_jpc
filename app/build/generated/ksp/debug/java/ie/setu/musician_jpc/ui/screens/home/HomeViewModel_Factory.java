package ie.setu.musician_jpc.ui.screens.home;

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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<AuthService> authServiceProvider;

  public HomeViewModel_Factory(Provider<AuthService> authServiceProvider) {
    this.authServiceProvider = authServiceProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(authServiceProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<AuthService> authServiceProvider) {
    return new HomeViewModel_Factory(authServiceProvider);
  }

  public static HomeViewModel newInstance(AuthService authService) {
    return new HomeViewModel(authService);
  }
}
