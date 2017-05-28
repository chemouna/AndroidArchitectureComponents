package com.mounacheikhna.archicomponents

import com.mounacheikhna.archicomponents.ui.MainActivity.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton @Component(
    modules = arrayOf(AndroidInjectionModule::class, AppModule::class, MainActivityModule::class))
open interface AppComponent {

  @Component.Builder interface Builder {
    @BindsInstance
    fun app(app: ArchiApp): Builder

    fun build(): AppComponent
  }

}