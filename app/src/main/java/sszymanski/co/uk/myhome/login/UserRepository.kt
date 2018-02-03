package sszymanski.co.uk.myhome.login

import retrofit2.Retrofit
import sszymanski.co.uk.myhome.data.UserService
import sszymanski.co.uk.myhome.di.DaggerDataComponent
import sszymanski.co.uk.myhome.di.DataModule
import javax.inject.Inject

/**
 * Created by rex on 02/02/2018.
 */
class UserRepository(val userService: UserService): LoginMvp.Model{
    @Inject lateinit var retrofit:Retrofit
    init{
        DaggerDataComponent
                .builder()
                .dataModule(DataModule())
                .build()
                .inject(this)
    }
    override fun validateCredentials(name: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
