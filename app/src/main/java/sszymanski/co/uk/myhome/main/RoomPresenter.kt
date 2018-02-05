package sszymanski.co.uk.myhome.main

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import sszymanski.co.uk.myhome.data.PhilipsHueRepository
import sszymanski.co.uk.myhome.di.DaggerPhilipsComponent
import sszymanski.co.uk.myhome.di.PhilipsModule
import java.util.concurrent.TimeUnit

import javax.inject.Inject

/**
 * Created by rex on 05/02/2018.
 */
class RoomPresenter(val view: RoomMvp.View) : RoomMvp.Presenter {
    override fun getLightStatus(light :String) {
        val getLight = philipsHueRepository.getLight(light)
        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .flatMap { getLight }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.setLightStatus(it.state)
                }, Throwable::printStackTrace)    }

    @Inject
    lateinit var philipsHueRepository: PhilipsHueRepository

    init {
        DaggerPhilipsComponent.builder().philipsModule(PhilipsModule()).build().inject(this)
    }

}