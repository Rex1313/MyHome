package sszymanski.co.uk.myhome.data

import io.reactivex.Observable
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import sszymanski.co.uk.myhome.data.pojo.PhilipsLight
import sszymanski.co.uk.myhome.data.pojo.PhilipsLightState
import sszymanski.co.uk.myhome.data.pojo.PhilipsLightUpdate
import sszymanski.co.uk.myhome.data.pojo.PhilipsTempSensor
import sszymanski.co.uk.myhome.utils.StaticValues

/**
 * Created by rex on 05/02/2018.
 */
interface PhilipsHueService {

    @GET(StaticValues.PHILIPS_HUE_USERNAME + "/lights/{light}")
    fun getLight(@Path("light") light: String): Observable<PhilipsLight>

    @GET(StaticValues.PHILIPS_HUE_USERNAME + "/sensors/{sensor}")
    fun getSensor(@Path("sensor") sensor: String): Observable<PhilipsTempSensor>

    @PUT(StaticValues.PHILIPS_HUE_USERNAME + "/lights/{light}/state")
    fun updateLight(@Path("light") light: String, @Body philipsState: PhilipsLightUpdate):Observable<Any>
}