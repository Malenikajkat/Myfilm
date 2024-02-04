package com.malenikajkat.myfilm.di
import com.malenikajkat.myfilm.di.modules.DatabaseModule
import com.malenikajkat.myfilm.di.modules.DomainModule
import com.malenikajkat.myfilm.di.modules.RemoteModule
import com.malenikajkat.myfilm.di.viewmodel.HomeFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    modules = [
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    //метод для того, чтобы появилась возможность внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
    //метод для того, чтобы появилась возможность внедрять зависимости в SettingsFragmentViewModel
    fun inject(settingsFragmentViewModel: SettingsFragmentViewModel)
}