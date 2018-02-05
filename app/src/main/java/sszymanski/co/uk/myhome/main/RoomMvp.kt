package sszymanski.co.uk.myhome.main

import sszymanski.co.uk.myhome.data.pojo.PhilipsLightState

/**
 * Created by rex on 05/02/2018.
 */
interface RoomMvp {
    interface View{fun setLightStatus(philipsLightState: PhilipsLightState)
    }
    interface Presenter{
       fun getLightStatus(light: String)
    }
}