package com.example.reflexgame

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var button1: Button
    var button2: Button? = null
    var relativeLayout: RelativeLayout? = null

    // runnable function
    var runnable = Runnable {
        // set the background on the screen
        relativeLayout!!.setBackgroundResource(R.color.green)

        // get the system time in milli second
        // when the screen background is set
        val time = System.currentTimeMillis()

        // function when stop button is clicked
        button2!!.setOnClickListener { // get the system time in milli second
            // when the stop button is clicked
            val time1 = System.currentTimeMillis()

            // display reflex time in toast message
            Toast.makeText(
                applicationContext,
                "Your reflexes takes " + (time1 - time) + " time to work",
                Toast.LENGTH_LONG
            ).show()

            // remove the background again
            relativeLayout!!.setBackgroundResource(0)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        relativeLayout = findViewById(R.id.rlVar1)
        button1 = findViewById(R.id.btVar1)
        button2 = findViewById(R.id.btVar2)

        // function when the start button is clicked
        button1.setOnClickListener(View.OnClickListener { // generate a random number from 1-10
            val random = Random()
            val num = random.nextInt(10)

            // call the runnable function after
            // a post delay of num seconds
            val handler = Handler()
            handler.postDelayed(runnable, (num * 1000).toLong())
        })
    }
}
