package sszymanski.co.uk.myhome.data

import io.reactivex.Observable
import org.json.JSONArray
import org.json.JSONObject
import sszymanski.co.uk.myhome.data.pojo.PhilipsLight
import sszymanski.co.uk.myhome.data.pojo.PhilipsLightState
import sszymanski.co.uk.myhome.data.pojo.PhilipsLightUpdate
import sszymanski.co.uk.myhome.data.pojo.PhilipsTempSensor
import sszymanski.co.uk.myhome.di.DaggerPhilipsComponent
import sszymanski.co.uk.myhome.di.PhilipsModule
import javax.inject.Inject

/**
 * Created by rex on 05/02/2018.
 */
class PhilipsHueRepository {
    @Inject
    lateinit var philipsHueService: PhilipsHueService

    init {
        DaggerPhilipsComponent.builder().philipsModule(PhilipsModule()).build().inject(this)
    }

    fun getLight(light: String): Observable<PhilipsLight> {
        return philipsHueService.getLight(light)
    }

    fun getTempSensor(sensor: String): Observable<PhilipsTempSensor> {
        return philipsHueService.getSensor(sensor)
    }

    fun updateLight(light: String, philisState: PhilipsLightUpdate):Observable<Any> {
        return philipsHueService.updateLight(light, philisState)
    }
}