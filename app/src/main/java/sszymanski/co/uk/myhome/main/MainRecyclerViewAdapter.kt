package sszymanski.co.uk.myhome.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_main_adapter.view.*
import sszymanski.co.uk.myhome.R
import sszymanski.co.uk.myhome.data.pojo.PhilipsLightState
import sszymanski.co.uk.myhome.data.pojo.Room
import sszymanski.co.uk.myhome.utils.IconUtils

/**
 * Created by rex on 05/02/2018.
 */
class MainRecyclerViewAdapter(val context: Context, val rooms: ArrayList<Room>) : RecyclerView.Adapter<MainRecyclerViewAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_main_adapter, parent, false)
        val holder = MainViewHolder(view)
        val presenter = RoomPresenter(holder)
        view.setTag(presenter)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rooms.size
    }

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        val presenter = holder?.itemView?.getTag() as RoomPresenter
        presenter.initRoom(rooms[position]);
        presenter.getLightStatus(rooms[position].lightNo)
        presenter.getTemperature(rooms[position].tempNo)

    }


    inner class MainViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), RoomMvp.View {
        override fun setRoomName(roomName: String) {
            itemView.room_name.text = roomName
        }

        override fun onTemperatureChange(temperature: String) {
            itemView.temperature.text = temperature
        }


        override fun onLightStatusChange(philipsLightState: PhilipsLightState) {
            itemView.light.text = "Light Status: " + if (philipsLightState.on) "On" else {
                "Off"
            }
            itemView.brightness.text = "Brightness: " + philipsLightState.bri
            itemView.hue.text = "Hue" + philipsLightState.ct
            itemView.bright_seekbar.setValue(philipsLightState.bri.toFloat())
            itemView.bright_seekbar.setOnTouchListener({ v, event -> true }) // disable interaction
            itemView.bulb_icon.setImageBitmap(IconUtils.generateColourBulb(context, philipsLightState.ct))
        }


    }
}