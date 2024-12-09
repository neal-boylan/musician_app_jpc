package ie.setu.musician_jpc.main

import android.app.Application
import timber.log.Timber

class MusicianMainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.i("Starting Musician Application")
    }
}