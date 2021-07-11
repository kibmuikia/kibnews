package kib.dev.kibnews.init

import android.app.Application
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner

class App : Application() {

    companion object {
        val logTag = App::class.java.simpleName
        var namePackage: String? = null
    }

    private var app: App = this

    class KibNewsLifeObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun created() {
            Log.e(logTag, ": AppLifeObserver-created-Event.ON_CREATE: called")
        }//: created()

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun toForeground() {
            Log.e(logTag, ": AppLifeObserver-toForeground-Event.ON_START: called")
        }//: toForeground

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun toBackground() {
            Log.e(logTag, ": AppLifeObserver-toBackground-Event.ON_STOP: called")
        }//: toBackground

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun destroyed() {
            Log.e(logTag, ": AppLifeObserver-destroyed-Event.ON_DESTROY: called")
        }//: destroyed()
    }//: KibNewsLifeObserver

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle
            .addObserver(KibNewsLifeObserver())
        namePackage = app.packageName
        Log.e(logTag, ": onCreate: called: namePackage: $namePackage")
    }//: onCreate

    override fun onTerminate() {
        super.onTerminate()
        Log.e(logTag, ": onTerminate: called")
    }//: onTerminate

}