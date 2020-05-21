package com.app.ui.splash

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import com.app.R
import com.app.ui.homepage.HomepageActivity
import com.google.android.material.snackbar.Snackbar

class SplashActivity : AppCompatActivity() {

    private var mDelayHandler: Handler? = null
    private val delay: Long = 1500

    init {
        lifecycleScope.launchWhenCreated {
            setContentView(R.layout.activity_splash)

            mDelayHandler = Handler()
            mDelayHandler!!.postDelayed(mRunnable, delay)
        }
    }

    override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            val intent = Intent(applicationContext, HomepageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}