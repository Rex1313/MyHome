package sszymanski.co.uk.myhome.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import sszymanski.co.uk.myhome.R
import sszymanski.co.uk.myhome.utils.gone
import sszymanski.co.uk.myhome.utils.visible

class LoginActivity : AppCompatActivity(), LoginMvp.View {
    lateinit var loginPresenter: LoginMvp.Presenter

    override fun displayErrorMessage(errorMessage: String) {
        editTextPassword.setError(errorMessage)
    }

    override fun displayProgress() {
        progressBar.visible()
    }

    override fun hideProgress() {
        progressBar.gone()
    }

    override fun disableLoginButton() {
        buttonLogIn.isEnabled = false
    }

    override fun enableLoginButton() {
        buttonLogIn.isEnabled = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginPresenter = LoginPresenter(this);
        buttonLogIn.setOnClickListener({
            val login = editTextLogin.text.toString()
            val password = editTextPassword.text.toString()
//            if (validateCredentials(login, password)){
//                val passwordHash = getMd5Hash(password)
//                println(passwordHash)
//                it.showToast("password hash is"+passwordHash)
//            } // TODO send credentials to server
//            else it.showToast(getString(R.string.log_in_password_or_login_wrong))
            loginPresenter.validateCredentials(login, password)

        })
    }

    /**
     * Validates if provided fields are not empty and password is at least 6 letters
     */


    fun sendData() {}

}
