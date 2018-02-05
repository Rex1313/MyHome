package sszymanski.co.uk.myhome.data

import io.reactivex.Observable
import sszymanski.co.uk.myhome.data.pojo.LoginResponse
import sszymanski.co.uk.myhome.di.DaggerDataComponent
import sszymanski.co.uk.myhome.di.DataModule
import sszymanski.co.uk.myhome.login.LoginMvp
import javax.inject.Inject

/**
 * Created by rex on 02/02/2018.
 */
class UserRepository(): LoginMvp.Model {
    @Inject lateinit var userService: UserService
    init{
        DaggerDataComponent
                .builder()
                .dataModule(DataModule())
                .build()
                .inject(this)
    }
    override fun validateCredentials(name: String, password: String): Observable<LoginResponse> {
       return userService.authorize(name, password)
    }


}
