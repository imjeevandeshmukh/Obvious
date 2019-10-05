package com.bytelogs.obvious.injection

import com.bytelogs.obvious.view.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class,NetworkModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        fun appModule(appModule: AppModule):Builder

        fun networkModule(networkModule: NetworkModule): Builder
    }
}