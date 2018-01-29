package sszymanski.co.uk.myhome.data

import android.content.Context
import sszymanski.co.uk.myhome.utils.save

/**
 * Created by rex on 28/01/2018.
 */
class UserPreferences(val context: Context) {
    val USER_SHARED_PREFERNCES = "USER_SHARED_PREFERENCES"
    val USER_LOGIN = "USER_LOGIN"
    val USER_PASSWORD = "USER_PASSWORD"

    fun saveLoginDetails(nameAndPassword: Pair<String, String>) {
        val sharedPreferences = context.getSharedPreferences(USER_SHARED_PREFERNCES, Context.MODE_PRIVATE)
        sharedPreferences.save(USER_LOGIN, nameAndPassword.first)
        sharedPreferences.save(USER_PASSWORD, nameAndPassword.second)
    }
    fun loadLoginDetails(): Pair<String, String>{
        val sharedPreferences = context.getSharedPreferences(USER_SHARED_PREFERNCES, Context.MODE_PRIVATE)
        val nameAndPassword = Pair(sharedPreferences.getString(USER_LOGIN, ""), sharedPreferences.getString(USER_PASSWORD, ""))
        return nameAndPassword
    }

}
