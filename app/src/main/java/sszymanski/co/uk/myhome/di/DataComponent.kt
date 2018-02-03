package sszymanski.co.uk.myhome.di

import dagger.Component
import sszymanski.co.uk.myhome.login.LoginPresenter
import sszymanski.co.uk.myhome.login.UserRepository
import javax.inject.Singleton

/**
 * Created by rex on 03/02/2018.
 */
@Singleton
@Component(modules = arrayOf(DataModule::class))
interface DataComponent {
    fun inject(loginPresenter: LoginPresenter)
    fun inject(userRepository: UserRepository)

}