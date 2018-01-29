package sszymanski.co.uk.myhome.utils

import android.content.SharedPreferences
import android.view.View
import android.widget.Toast

/**
 * Created by rex on 28/01/2018.
 */


/**
 * Extenstion to view for easy showing Toasts. Default lenght is short, can be modified by passing second parameter
 */
fun View.showToast(message:String, length:Int = Toast.LENGTH_SHORT){
    Toast.makeText(context, message, length).show();
}

fun SharedPreferences.save(key:String, value:Any){

}