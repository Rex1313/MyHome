package sszymanski.co.uk.myhome.main

import android.graphics.Bitmap
import sszymanski.co.uk.myhome.data.pojo.PhilipsLightState
import sszymanski.co.uk.myhome.data.pojo.PhilipsTempSensor
import sszymanski.co.uk.myhome.data.pojo.Room

/**
 * Created by rex on 05/02/2018.
 */
interface RoomMvp {
    interface View {
        fun setRoomName(roomName: String);
        fun onLightStatusChange(philipsLightState: PhilipsLightState)
        fun onTemperatureChange(temperature:String)
    }

    interface Presenter {
        fun getLightStatus(light: String)
        fun getTemperature(sensor: String)
        fun initRoom(room: Room)
    }
}