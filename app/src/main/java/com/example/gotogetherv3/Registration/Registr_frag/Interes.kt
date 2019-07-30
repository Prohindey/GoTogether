package com.example.gotogetherv3.Registration.Registr_frag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.gotogetherv3.R
import me.itangqi.waveloadingview.WaveLoadingView
import java.util.*

class Interes : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.registration_interes, container, false)

//        val timer : Timer
//
//        var vl = 1
//        val wave_cont = v.findViewById<LinearLayout>(R.id.wave_cont)
//        val wave = v.findViewById<WaveLoadingView>(R.id.wave)
//        wave_cont.setOnClickListener {
//            vl += 1
//            wave.progressValue = vl
//            wave.centerTitle = vl.toString()
//        }
////        wave_cont.setOnTouchListener(object : View.OnTouchListener {
////            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
////                when(event?.actionMasked) {
////                    MotionEvent.ACTION_DOWN -> {
////                        timer.sch
////
////                        true
////                    }
////                    MotionEvent.ACTION_UP -> {
////
////                    }
////                }
////                return true
////            }
////        })










        return v
    }

}