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

    /**
     * Saves Login details in shared preferences name and md5 hashed password
     * @nameAndPassword: Pair of name and md5 hash of password, where first element is name, and second element is password
     */
    fun saveLoginDetails(nameAndPassword: Pair<String, String>) {
        val sharedPreferences = context.getSharedPreferences(USER_SHARED_PREFERNCES, Context.MODE_PRIVATE)
        sharedPreferences.save(USER_LOGIN, nameAndPassword.first)
        sharedPreferences.save(USER_PASSWORD, nameAndPassword.second)
    }

    /**
     * Loads Login details from shared preferences
     * @return name and md5 hash of password in Pair, where first element it name and second element is password
     */
    fun loadLoginDetails(): Pair<String, String>{
        val sharedPreferences = context.getSharedPreferences(USER_SHARED_PREFERNCES, Context.MODE_PRIVATE)
        val nameAndPassword = Pair(sharedPreferences.getString(USER_LOGIN, ""), sharedPreferences.getString(USER_PASSWORD, ""))
        return nameAndPassword
    }

}
