package ie.setu.musician_jpc;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.credentials.CredentialManager;
import androidx.credentials.GetCredentialRequest;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import ie.setu.musician_jpc.firebase.FirebaseModule_GetCredentialRequestFactory;
import ie.setu.musician_jpc.firebase.FirebaseModule_ProvideAuthRepositoryFactory;
import ie.setu.musician_jpc.firebase.FirebaseModule_ProvideCredentialManagerFactory;
import ie.setu.musician_jpc.firebase.FirebaseModule_ProvideFirebaseAuthFactory;
import ie.setu.musician_jpc.firebase.FirebaseModule_ProvideFirebaseFirestoreFactory;
import ie.setu.musician_jpc.firebase.FirebaseModule_ProvideFirestoreRepositoryFactory;
import ie.setu.musician_jpc.firebase.FirebaseModule_ProvideGoogleIdOptionsFactory;
import ie.setu.musician_jpc.firebase.services.AuthService;
import ie.setu.musician_jpc.firebase.services.FirestoreService;
import ie.setu.musician_jpc.ui.screens.clip.ClipViewModel;
import ie.setu.musician_jpc.ui.screens.clip.ClipViewModel_HiltModules;
import ie.setu.musician_jpc.ui.screens.clipList.ClipListViewModel;
import ie.setu.musician_jpc.ui.screens.clipList.ClipListViewModel_HiltModules;
import ie.setu.musician_jpc.ui.screens.details.DetailsViewModel;
import ie.setu.musician_jpc.ui.screens.details.DetailsViewModel_HiltModules;
import ie.setu.musician_jpc.ui.screens.home.HomeViewModel;
import ie.setu.musician_jpc.ui.screens.home.HomeViewModel_HiltModules;
import ie.setu.musician_jpc.ui.screens.login.LoginViewModel;
import ie.setu.musician_jpc.ui.screens.login.LoginViewModel_HiltModules;
import ie.setu.musician_jpc.ui.screens.profile.ProfileViewModel;
import ie.setu.musician_jpc.ui.screens.profile.ProfileViewModel_HiltModules;
import ie.setu.musician_jpc.ui.screens.register.RegisterViewModel;
import ie.setu.musician_jpc.ui.screens.register.RegisterViewModel_HiltModules;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

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
public final class DaggerMusicianMainApp_HiltComponents_SingletonC {
  private DaggerMusicianMainApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public MusicianMainApp_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements MusicianMainApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public MusicianMainApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements MusicianMainApp_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public MusicianMainApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements MusicianMainApp_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public MusicianMainApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements MusicianMainApp_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MusicianMainApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements MusicianMainApp_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MusicianMainApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements MusicianMainApp_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public MusicianMainApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements MusicianMainApp_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public MusicianMainApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends MusicianMainApp_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends MusicianMainApp_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends MusicianMainApp_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends MusicianMainApp_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(ImmutableMap.<String, Boolean>builderWithExpectedSize(7).put(LazyClassKeyProvider.ie_setu_musician_jpc_ui_screens_clipList_ClipListViewModel, ClipListViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.ie_setu_musician_jpc_ui_screens_clip_ClipViewModel, ClipViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.ie_setu_musician_jpc_ui_screens_details_DetailsViewModel, DetailsViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.ie_setu_musician_jpc_ui_screens_home_HomeViewModel, HomeViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.ie_setu_musician_jpc_ui_screens_login_LoginViewModel, LoginViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.ie_setu_musician_jpc_ui_screens_profile_ProfileViewModel, ProfileViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.ie_setu_musician_jpc_ui_screens_register_RegisterViewModel, RegisterViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public void injectMusicianMainActivity(MusicianMainActivity musicianMainActivity) {
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String ie_setu_musician_jpc_ui_screens_profile_ProfileViewModel = "ie.setu.musician_jpc.ui.screens.profile.ProfileViewModel";

      static String ie_setu_musician_jpc_ui_screens_login_LoginViewModel = "ie.setu.musician_jpc.ui.screens.login.LoginViewModel";

      static String ie_setu_musician_jpc_ui_screens_register_RegisterViewModel = "ie.setu.musician_jpc.ui.screens.register.RegisterViewModel";

      static String ie_setu_musician_jpc_ui_screens_details_DetailsViewModel = "ie.setu.musician_jpc.ui.screens.details.DetailsViewModel";

      static String ie_setu_musician_jpc_ui_screens_home_HomeViewModel = "ie.setu.musician_jpc.ui.screens.home.HomeViewModel";

      static String ie_setu_musician_jpc_ui_screens_clip_ClipViewModel = "ie.setu.musician_jpc.ui.screens.clip.ClipViewModel";

      static String ie_setu_musician_jpc_ui_screens_clipList_ClipListViewModel = "ie.setu.musician_jpc.ui.screens.clipList.ClipListViewModel";

      @KeepFieldType
      ProfileViewModel ie_setu_musician_jpc_ui_screens_profile_ProfileViewModel2;

      @KeepFieldType
      LoginViewModel ie_setu_musician_jpc_ui_screens_login_LoginViewModel2;

      @KeepFieldType
      RegisterViewModel ie_setu_musician_jpc_ui_screens_register_RegisterViewModel2;

      @KeepFieldType
      DetailsViewModel ie_setu_musician_jpc_ui_screens_details_DetailsViewModel2;

      @KeepFieldType
      HomeViewModel ie_setu_musician_jpc_ui_screens_home_HomeViewModel2;

      @KeepFieldType
      ClipViewModel ie_setu_musician_jpc_ui_screens_clip_ClipViewModel2;

      @KeepFieldType
      ClipListViewModel ie_setu_musician_jpc_ui_screens_clipList_ClipListViewModel2;
    }
  }

  private static final class ViewModelCImpl extends MusicianMainApp_HiltComponents.ViewModelC {
    private final SavedStateHandle savedStateHandle;

    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<ClipListViewModel> clipListViewModelProvider;

    private Provider<ClipViewModel> clipViewModelProvider;

    private Provider<DetailsViewModel> detailsViewModelProvider;

    private Provider<HomeViewModel> homeViewModelProvider;

    private Provider<LoginViewModel> loginViewModelProvider;

    private Provider<ProfileViewModel> profileViewModelProvider;

    private Provider<RegisterViewModel> registerViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.savedStateHandle = savedStateHandleParam;
      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.clipListViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.clipViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.detailsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.loginViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.profileViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.registerViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(ImmutableMap.<String, javax.inject.Provider<ViewModel>>builderWithExpectedSize(7).put(LazyClassKeyProvider.ie_setu_musician_jpc_ui_screens_clipList_ClipListViewModel, ((Provider) clipListViewModelProvider)).put(LazyClassKeyProvider.ie_setu_musician_jpc_ui_screens_clip_ClipViewModel, ((Provider) clipViewModelProvider)).put(LazyClassKeyProvider.ie_setu_musician_jpc_ui_screens_details_DetailsViewModel, ((Provider) detailsViewModelProvider)).put(LazyClassKeyProvider.ie_setu_musician_jpc_ui_screens_home_HomeViewModel, ((Provider) homeViewModelProvider)).put(LazyClassKeyProvider.ie_setu_musician_jpc_ui_screens_login_LoginViewModel, ((Provider) loginViewModelProvider)).put(LazyClassKeyProvider.ie_setu_musician_jpc_ui_screens_profile_ProfileViewModel, ((Provider) profileViewModelProvider)).put(LazyClassKeyProvider.ie_setu_musician_jpc_ui_screens_register_RegisterViewModel, ((Provider) registerViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return ImmutableMap.<Class<?>, Object>of();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String ie_setu_musician_jpc_ui_screens_profile_ProfileViewModel = "ie.setu.musician_jpc.ui.screens.profile.ProfileViewModel";

      static String ie_setu_musician_jpc_ui_screens_home_HomeViewModel = "ie.setu.musician_jpc.ui.screens.home.HomeViewModel";

      static String ie_setu_musician_jpc_ui_screens_clipList_ClipListViewModel = "ie.setu.musician_jpc.ui.screens.clipList.ClipListViewModel";

      static String ie_setu_musician_jpc_ui_screens_clip_ClipViewModel = "ie.setu.musician_jpc.ui.screens.clip.ClipViewModel";

      static String ie_setu_musician_jpc_ui_screens_register_RegisterViewModel = "ie.setu.musician_jpc.ui.screens.register.RegisterViewModel";

      static String ie_setu_musician_jpc_ui_screens_details_DetailsViewModel = "ie.setu.musician_jpc.ui.screens.details.DetailsViewModel";

      static String ie_setu_musician_jpc_ui_screens_login_LoginViewModel = "ie.setu.musician_jpc.ui.screens.login.LoginViewModel";

      @KeepFieldType
      ProfileViewModel ie_setu_musician_jpc_ui_screens_profile_ProfileViewModel2;

      @KeepFieldType
      HomeViewModel ie_setu_musician_jpc_ui_screens_home_HomeViewModel2;

      @KeepFieldType
      ClipListViewModel ie_setu_musician_jpc_ui_screens_clipList_ClipListViewModel2;

      @KeepFieldType
      ClipViewModel ie_setu_musician_jpc_ui_screens_clip_ClipViewModel2;

      @KeepFieldType
      RegisterViewModel ie_setu_musician_jpc_ui_screens_register_RegisterViewModel2;

      @KeepFieldType
      DetailsViewModel ie_setu_musician_jpc_ui_screens_details_DetailsViewModel2;

      @KeepFieldType
      LoginViewModel ie_setu_musician_jpc_ui_screens_login_LoginViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // ie.setu.musician_jpc.ui.screens.clipList.ClipListViewModel 
          return (T) new ClipListViewModel(singletonCImpl.firestoreService(), singletonCImpl.authService());

          case 1: // ie.setu.musician_jpc.ui.screens.clip.ClipViewModel 
          return (T) new ClipViewModel(singletonCImpl.firestoreService(), singletonCImpl.authService());

          case 2: // ie.setu.musician_jpc.ui.screens.details.DetailsViewModel 
          return (T) new DetailsViewModel(singletonCImpl.firestoreService(), singletonCImpl.authService(), viewModelCImpl.savedStateHandle);

          case 3: // ie.setu.musician_jpc.ui.screens.home.HomeViewModel 
          return (T) new HomeViewModel(singletonCImpl.authService());

          case 4: // ie.setu.musician_jpc.ui.screens.login.LoginViewModel 
          return (T) new LoginViewModel(singletonCImpl.authService(), singletonCImpl.credentialManager(), singletonCImpl.getCredentialRequest());

          case 5: // ie.setu.musician_jpc.ui.screens.profile.ProfileViewModel 
          return (T) new ProfileViewModel(singletonCImpl.authService(), FirebaseModule_ProvideFirebaseAuthFactory.provideFirebaseAuth());

          case 6: // ie.setu.musician_jpc.ui.screens.register.RegisterViewModel 
          return (T) new RegisterViewModel(FirebaseModule_ProvideFirebaseAuthFactory.provideFirebaseAuth(), singletonCImpl.authService());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends MusicianMainApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends MusicianMainApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends MusicianMainApp_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;

    }

    private AuthService authService() {
      return FirebaseModule_ProvideAuthRepositoryFactory.provideAuthRepository(FirebaseModule_ProvideFirebaseAuthFactory.provideFirebaseAuth());
    }

    private FirestoreService firestoreService() {
      return FirebaseModule_ProvideFirestoreRepositoryFactory.provideFirestoreRepository(authService(), FirebaseModule_ProvideFirebaseFirestoreFactory.provideFirebaseFirestore());
    }

    private CredentialManager credentialManager() {
      return FirebaseModule_ProvideCredentialManagerFactory.provideCredentialManager(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
    }

    private GetGoogleIdOption getGoogleIdOption() {
      return FirebaseModule_ProvideGoogleIdOptionsFactory.provideGoogleIdOptions(ApplicationContextModule_ProvideApplicationFactory.provideApplication(applicationContextModule));
    }

    private GetCredentialRequest getCredentialRequest() {
      return FirebaseModule_GetCredentialRequestFactory.getCredentialRequest(getGoogleIdOption());
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    @Override
    public void injectMusicianMainApp(MusicianMainApp musicianMainApp) {
    }
  }
}
