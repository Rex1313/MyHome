package sszymanski.co.uk.myhome.di

import dagger.Component
import sszymanski.co.uk.myhome.data.PhilipsHueRepository
import sszymanski.co.uk.myhome.data.UserRepository
import sszymanski.co.uk.myhome.main.MainPresenter
import sszymanski.co.uk.myhome.main.RoomPresenter
import javax.inject.Singleton

/**
 * Created by rex on 03/02/2018.
 */
@Singleton
@Component(modules = arrayOf(PhilipsModule::class))
interface PhilipsComponent {
    fun inject(roomPresenter: RoomPresenter)
    fun inject(philipsHueRepository: PhilipsHueRepository)

}