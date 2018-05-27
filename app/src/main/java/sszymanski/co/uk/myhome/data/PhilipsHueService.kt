package sszymanski.co.uk.myhome.data

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import sszymanski.co.uk.myhome.data.pojo.PhilipsLight
import sszymanski.co.uk.myhome.data.pojo.PhilipsTempSensor
import sszymanski.co.uk.myhome.utils.StaticValues

/**
 * Created by rex on 05/02/2018.
 */
interface PhilipsHueService {

    @GET(StaticValues.PHILIPS_HUE_USERNAME+"/lights/{light}")
    fun getLight(@Path("light") light:String): Observable<PhilipsLight>

    @GET(StaticValues.PHILIPS_HUE_USERNAME+"/sensors/{sensor}")
    fun getTemperatureSensor(@Path("sensor") sensor:String): Observable<PhilipsTempSensor>
}