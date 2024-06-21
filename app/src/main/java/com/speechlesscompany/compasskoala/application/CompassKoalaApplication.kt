package com.speechlesscompany.compasskoala.application

import android.app.Application
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.appcheck.appCheck
import com.google.firebase.appcheck.debug.DebugAppCheckProviderFactory
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory
import com.speechlesscompany.compasskoala.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
internal class CompassKoalaApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        initAppCheck()
    }

    private fun initAppCheck() {
        val app = Firebase.appCheck

        if (BuildConfig.DEBUG) {
            app.installAppCheckProviderFactory(DebugAppCheckProviderFactory.getInstance())
        } else {
            app.installAppCheckProviderFactory(PlayIntegrityAppCheckProviderFactory.getInstance())
        }
    }
}
