package com.example.mobilprogodev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isFragmentOneLoaded=true
    val manager=supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


val button2=(btn_hakkimda)
        btn_hakkimda.setOnClickListener {


            val intnt=Intent(this,AboutActivity::class.java)
            startActivity(intnt)

        }


        val Change=findViewById<Button>(R.id.btn_change)
        ShowFragmentOne()
        Change.setOnClickListener({if(isFragmentOneLoaded)
        ShowFragmentTwo()
        else

        ShowFragmentOne()
         })
    }
    fun ShowFragmentOne(){

val transaction = manager.beginTransaction()
        val fragment=FragmentOne()
        transaction.replace(R.id.fragment_holder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded=true




    }
    fun ShowFragmentTwo(){

        val transaction = manager.beginTransaction()
        val fragment=FragmentTwo()
        transaction.replace(R.id.fragment_holder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded=false




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

}