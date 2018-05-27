package sszymanski.co.uk.myhome

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import sszymanski.co.uk.myhome.login.LoginActivity
import sszymanski.co.uk.myhome.login.LoginMvp
import sszymanski.co.uk.myhome.login.LoginPresenter

/**
 * Created by rex on 04/02/2018.
 */
class LoginUnitTest {
    lateinit var presenter: LoginMvp.Presenter;
    @Before
    fun initialize() {
        presenter = LoginPresenter(mockedView)
    }

    @Test
    fun test_login_success(){
        presenter.onLoginSuccess()
    }

}