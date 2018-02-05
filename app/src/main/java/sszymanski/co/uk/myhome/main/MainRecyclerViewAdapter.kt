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
        presenter.getLightStatus("3")
    }


    inner class MainViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), RoomMvp.View {
        override fun setLightStatus(philipsLightState: PhilipsLightState) {
            itemView.light.text = "Light Status: " +if(philipsLightState.reachable)"Reachable" else{"Not Reachable"}
            itemView.brightness.text = "Brightness: " + philipsLightState.bri
            itemView.hue.text = "Hue" + philipsLightState.ct
        }


    }
}