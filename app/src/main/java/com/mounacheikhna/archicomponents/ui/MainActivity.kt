package com.mounacheikhna.archicomponents.ui

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mounacheikhna.archicomponents.R
import com.mounacheikhna.archicomponents.annotation.ScopeSingleton
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  @Module(subcomponents = arrayOf(MainActivityComponent::class))
  abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bindMainActivityInjectorFactory(
        builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>

  }

  @ScopeSingleton(MainActivityComponent::class)
  @Subcomponent(modules = arrayOf(MainActivityComponent.MainModule::class))
  interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<MainActivity>()

    @Module class MainModule
  }

}
