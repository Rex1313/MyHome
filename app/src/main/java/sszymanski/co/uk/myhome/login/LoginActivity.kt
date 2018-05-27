package sszymanski.co.uk.myhome.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import sszymanski.co.uk.myhome.R
import sszymanski.co.uk.myhome.data.UserPreferences
import sszymanski.co.uk.myhome.main.MainActivity
import sszymanski.co.uk.myhome.utils.gone
import sszymanski.co.uk.myhome.utils.visible

class LoginActivity : AppCompatActivity(), LoginMvp.View {

    lateinit var loginPresenter: LoginMvp.Presenter
    override fun autoFillUsername(userName: String) {
        editTextLogin.setText(userName)
    }

    override fun autoFillPassword(password: String) {
        editTextPassword.setText(password)
    }

    override fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

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
        val userPreferences = UserPreferences(this)
        loginPresenter = LoginPresenter(this, userPreferences)
        loginPresenter.initialize()
        buttonLogIn.setOnClickListener({
            val login = editTextLogin.text.toString()
            val password = editTextPassword.text.toString()
            loginPresenter.loginButtonPressed(login, password)

        })
    }

}
