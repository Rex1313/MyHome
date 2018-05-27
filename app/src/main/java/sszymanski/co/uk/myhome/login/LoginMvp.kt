package sszymanski.co.uk.myhome.login

import io.reactivex.Observable
import sszymanski.co.uk.myhome.data.pojo.LoginResponse


/**
 * Created by rex on 02/02/2018.
 */
interface LoginMvp {

    interface View{
        fun displayProgress()
        fun hideProgress()
        fun disableLoginButton()
        fun enableLoginButton()
        fun displayErrorMessage(errorMessage: String)
        fun goToMainActivity()
        fun autoFillUsername(userName:String)
        fun autoFillPassword(password: String)
    }

    interface Model{
        fun validateCredentials(name : String, password: String): Observable<LoginResponse>
    }
    interface Presenter{
        fun initialize()
        fun onLoginSuccess()
        fun onLoginFailed()
        fun loginButtonPressed(name: String, password: String)
        fun toMd5(password: String):String
    }
}