package com.app.ui.homepage

import javax.inject.Inject
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.app.R
import com.app.di.Injectable
import com.app.ui.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector

class HomepageActivity : BaseActivity(), Injectable, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun layoutRes() = R.layout.activity_homepage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().add(R.id.frame, HomepageFragment.newInstance())
            .commitAllowingStateLoss()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }
}