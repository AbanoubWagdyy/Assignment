package com.app.di

import com.app.ui.homepage.HomepageActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class HomepageActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeEventsActivity(): HomepageActivity
}
