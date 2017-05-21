package com.mounacheikhna.archicomponents

import android.app.Activity
import android.app.Application
import android.app.Fragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasDispatchingActivityInjector
import javax.inject.Inject

class ArchiApp : Application(), HasDispatchingActivityInjector {

  private var instance: ArchiApp? = null
  private var component: AppComponent? = null

  @Inject internal var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>? = null
  @Inject internal var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>? = null

  fun getAppComponent(): AppComponent {
    return instance!!.getComponent()
  }

  fun getComponent(): AppComponent {
    return component!!
  }

  override fun onCreate() {
    super.onCreate()
    instance = this
    component = DaggerAppComponent.builder().app(this).build()
    component!!.inject(this)
  }

  override fun activityInjector(): DispatchingAndroidInjector<Activity> {
    return dispatchingActivityInjector!!
  }

}