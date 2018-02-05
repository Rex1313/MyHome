package sszymanski.co.uk.myhome.main

import sszymanski.co.uk.myhome.data.PhilipsHueRepository
import sszymanski.co.uk.myhome.data.pojo.Room
import javax.inject.Inject

/**
 * Created by rex on 05/02/2018.
 */
class MainPresenter(val view: MainMvp.View) : MainMvp.Presenter {
    override fun loadRooms(){
        val room = Room()
        val list = ArrayList<Room>()
        list.add(room)
        view.setListInRecyclerView(list)
    }


}