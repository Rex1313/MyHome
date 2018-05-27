package sszymanski.co.uk.myhome.main

import sszymanski.co.uk.myhome.data.PhilipsHueRepository
import sszymanski.co.uk.myhome.data.pojo.Room
import javax.inject.Inject

/**
 * Created by rex on 05/02/2018.
 */
class MainPresenter(val view: MainMvp.View) : MainMvp.Presenter {

    override fun loadRooms(){
        val room = Room("Luna", "11","11")
        val room2 = Room( "Charles", "9", "11")
        val list = ArrayList<Room>()
        list.add(room)
        list.add(room2)
        view.setListInRecyclerView(list)
    }


}