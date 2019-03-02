package sszymanski.co.uk.myhome.main

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.joda.time.LocalDateTime
import sszymanski.co.uk.myhome.R
import sszymanski.co.uk.myhome.data.PhilipsHueRepository
import sszymanski.co.uk.myhome.data.pojo.PhilipsLightState
import sszymanski.co.uk.myhome.data.pojo.PhilipsLightUpdate
import sszymanski.co.uk.myhome.data.pojo.Room
import sszymanski.co.uk.myhome.di.DaggerPhilipsComponent
import sszymanski.co.uk.myhome.di.PhilipsModule

import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.collections.ArrayList

/**
 * Created by rex on 05/02/2018.
 */
class MainPresenter(val view: MainMvp.View) : MainMvp.Presenter {

    @Inject
    lateinit var philipsHueRepository: PhilipsHueRepository
    var lastMove = LocalDateTime.now()
    var lastSoundPlayed = LocalDateTime.now()
    var sounds = ArrayList<Int>()

    init {
        DaggerPhilipsComponent.builder().philipsModule(PhilipsModule()).build().inject(this)
        sounds.add(R.raw

















                .a)\||||||||||
        sounds.add(R.raw.c)
        sounds.add(R.raw.d)
        sounds.add(R.raw.e)
    }



    override fun loadRooms() {
        val room = Room("Luna", "11", "11")
        val room2 = Room("Charles", "9", "11")
        val list = ArrayList<Room>()
        list.add(room)
        list.add(room2)
        view.setListInRecyclerView(list)
    }

    private fun changeLight(lightNo:String, on:Boolean, bri:Int, hue:Int?, sat:Int?){
        philipsHueRepository.getLight(lightNo)
                .flatMap { stat->
                    val initialState = PhilipsLightUpdate(stat.state.on, stat.state.bri, stat.state.hue, stat.state.sat)
                    philipsHueRepository.updateLight(lightNo, PhilipsLightUpdate(on, bri, hue, sat))
                            .subscribeOn(Schedulers.io())
                            .delay(3, TimeUnit.SECONDS)
                            .doOnNext{response->println("Response is "+response)}
                            .flatMap { philipsHueRepository.updateLight(lightNo, PhilipsLightUpdate(false, bri, hue, sat)) }
                            .delay (1, TimeUnit.SECONDS)
                            .flatMap { philipsHueRepository.updateLight(lightNo, PhilipsLightUpdate(true, bri, hue, sat)) }
                            .delay (1, TimeUnit.SECONDS)
                            .flatMap { philipsHueRepository.updateLight(lightNo, PhilipsLightUpdate(false, bri, hue, sat)) }
                            .delay (1, TimeUnit.SECONDS)
                            .flatMap { philipsHueRepository.updateLight(lightNo, PhilipsLightUpdate(true, bri, hue, sat)) }
                            .flatMap { philipsHueRepository.updateLight(lightNo, PhilipsLightUpdate(false, bri, hue, sat)) }
                            .delay (1, TimeUnit.SECONDS)
                            .flatMap { philipsHueRepository.updateLight(lightNo, PhilipsLightUpdate(true, bri, hue, sat)) }
                            .delay (1, TimeUnit.SECONDS)
                            .flatMap { philipsHueRepository.updateLight(lightNo, PhilipsLightUpdate(false, bri, hue, sat)) }
                            .delay (1, TimeUnit.SECONDS)
                            .flatMap { philipsHueRepository.updateLight(lightNo, PhilipsLightUpdate(true, bri, hue, sat)) }
                            .delay (3, TimeUnit.SECONDS)
                            .flatMap { philipsHueRepository.updateLight(lightNo, initialState) }
                }

                .subscribe{response->println(response)}
    }

    override fun loadHallowen() {
        Observable.interval(1000, 2000, TimeUnit.MILLISECONDS).flatMap {
            philipsHueRepository.philipsHueService.getSensor("35")
        }.subscribe {
            lastMove = LocalDateTime.parse(it.state.lastupdated)
            if (lastMove.isAfter(LocalDateTime.now().minusSeconds(40)) && !lastSoundPlayed.isAfter(LocalDateTime.now().minusSeconds(40 ))) {
                lastSoundPlayed = LocalDateTime.now()
                val selectedSound = sounds[Random().nextInt(4)]
                view.playSound(selectedSound)
                changeLight("13", true,244,65000,244)
                changeLight("2", true,244,65000,244)
                changeLight("9", true,244,65000,244)
                changeLight("18", true,244,65000,244)
                changeLight("19", true,244,65000,244)
                changeLight("20", true,244,65000,244)
                changeLight("21", true,244,65000,244)
                changeLight("22", true,244,65000,244)


            }
        }
    }

}