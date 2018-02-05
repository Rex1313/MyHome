package sszymanski.co.uk.myhome.data

import io.reactivex.Observable
import sszymanski.co.uk.myhome.data.pojo.PhilipsLight
import sszymanski.co.uk.myhome.di.DaggerPhilipsComponent
import sszymanski.co.uk.myhome.di.PhilipsModule
import javax.inject.Inject

/**
 * Created by rex on 05/02/2018.
 */
class PhilipsHueRepository{
    @Inject lateinit var philipsHueService: PhilipsHueService
    init{
        DaggerPhilipsComponent.builder().philipsModule(PhilipsModule()).build().inject(this)
    }
    fun getLight(light:String): Observable<PhilipsLight> {
        return philipsHueService.getLight(light)
    }
}