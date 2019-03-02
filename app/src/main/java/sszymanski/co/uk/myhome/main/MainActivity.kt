package sszymanski.co.uk.myhome.main

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import sszymanski.co.uk.myhome.R
import sszymanski.co.uk.myhome.data.pojo.Room


/**
 * Created by rex on 05/02/2018.
 */
class MainActivity : AppCompatActivity(), MainMvp.View {
    override fun playSound(id:Int) {
        val ring = MediaPlayer.create(this@MainActivity,id)
        ring.start()
    }

    lateinit var presenter: MainPresenter
    override fun setListInRecyclerView(rooms: ArrayList<Room>) {
        recyclerViewMain.adapter = MainRecyclerViewAdapter(this, rooms)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewMain.layoutManager = LinearLayoutManager(this)!!
        presenter = MainPresenter(this)
        presenter.loadRooms()
        presenter.loadHallowen()

    }
}