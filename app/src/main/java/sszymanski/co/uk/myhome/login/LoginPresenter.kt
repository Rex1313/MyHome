package sszymanski.co.uk.myhome.login

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import sszymanski.co.uk.myhome.data.UserService
import sszymanski.co.uk.myhome.di.DaggerDataComponent
import sszymanski.co.uk.myhome.di.DataModule
import sszymanski.co.uk.myhome.utils.Utils
import javax.inject.Inject

/**
 * Created by rex on 02/02/2018.
 */
class LoginPresenter(val view: LoginMvp.View) : LoginMvp.Presenter {
    @Inject
    lateinit var userService: UserService

    init {
        DaggerDataComponent
                .builder()
                .dataModule(DataModule())
                .build()
                .inject(this)
    }

    override fun toMd5(password: String): String = Utils.getMd5Hash(password).joinToString("")


    override fun validateCredentials(name: String, password: String) {
        if (name.isNotEmpty() && password.length >= 6) {
            view.disableLoginButton()
            view.displayProgress()
            userService.authorize(name, toMd5(password))
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError({
                        view.hideProgress()
                        view.enableLoginButton()
                        view.displayErrorMessage("name or password incorrect")
                    })
                    .subscribeOn(Schedulers.newThread()).subscribe(
                    {
                        println(it)
                    }, Throwable::printStackTrace
            )
        } else {
            view.displayErrorMessage("Name can't be empty and password needs to be more than 6 characters")
        }
    }

    override fun onLoginSuccess() {
        view.enableLoginButton()
        view.hideProgress()
    }

    override fun onLoginFailed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}