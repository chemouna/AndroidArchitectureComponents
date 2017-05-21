package com.mounacheikhna.archicomponents

import android.content.Context
import com.mounacheikhna.archicomponents.annotation.ApplicationContext
import com.mounacheikhna.archicomponents.annotation.ObserveOnScheduler
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Singleton

@Module
class AppModule {
  @Provides
  @Singleton
  @ApplicationContext
  fun provideApplicationContext(app: ArchiApp): Context {
    return app.getApplicationContext()
  }

  @Provides
  @Singleton
  @ObserveOnScheduler
  internal fun provideObserveOnScheduler(): Scheduler {
    return AndroidSchedulers.mainThread()
  }

}