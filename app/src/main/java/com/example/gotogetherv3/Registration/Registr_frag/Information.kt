package com.example.gotogetherv3.Registration.Registr_frag

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.gotogetherv3.R
import java.util.*

class Information: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.registration_information, container, false)

        val date_cont = v.findViewById<RelativeLayout>(R.id.registration_information_date)
        val date_text = v.findViewById<TextView>(R.id.registration_information_date_text)

        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val datte = cal.get(Calendar.DAY_OF_MONTH)

        date_cont.setOnClickListener {
            val dpd  = DatePickerDialog(v.context, DatePickerDialog.OnDateSetListener{ view, mYear, mMonth, mDate ->
                date_text.setText("" + mDate + "/" + mMonth +"/"+ mYear)
            }, year, month, datte)
            dpd.show()
        }

        return v
    }

}