package com.app.di

import com.app.ui.homepage.HomepageFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeHomepageFragment(): HomepageFragment
}