package sszymanski.co.uk.myhome.main

import sszymanski.co.uk.myhome.data.pojo.Room


/**
 * Created by rex on 05/02/2018.
 */
interface MainMvp {
    interface View{
        fun setListInRecyclerView(rooms:ArrayList<Room>)
        fun playSound(id:Int)
    }
    interface Presenter{
        fun loadRooms()
        fun loadHallowen()
    }
}