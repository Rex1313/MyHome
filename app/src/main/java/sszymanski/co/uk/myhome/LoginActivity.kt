package sszymanski.co.uk.myhome

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import sszymanski.co.uk.myhome.utils.showToast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        buttonLogIn.setOnClickListener({
            val login = editTextLogin.text.toString()
            val password = editTextPassword.text.toString()
            if (validateCredentials(login, password)) // TODO send credentials to server
            else it.showToast(getString(R.string.log_in_password_or_login_wrong))

        })
    }

    /**
     * Validates if provided fields are not empty and password is at least 6 letters
     */
    fun validateCredentials(login: String, password: String) = !login.isEmpty() && password.length >= 6;

}
