package sszymanski.co.uk.myhome.common

import android.app.Application
import sszymanski.co.uk.myhome.di.DataModule

/**
 * Created by rex on 19/02/2018.
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        application = this

    }

    companion object {
        lateinit var application: Application

        fun app(): Application {
            return application
        }
    }

}