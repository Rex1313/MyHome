package sszymanski.co.uk.myhome.login

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
    }

    interface Model{
        fun validateCredentials(name : String, password: String)
    }
    interface Presenter{
        fun onLoginSuccess()
        fun onLoginFailed()
        fun validateCredentials(name: String, password: String)
        fun toMd5(password: String):String
    }
}