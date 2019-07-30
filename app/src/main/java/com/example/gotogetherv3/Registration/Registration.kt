
package com.example.gotogetherv3.Registration

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentTransaction
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.gotogetherv3.MainActivity
import com.example.gotogetherv3.R
import com.example.gotogetherv3.Regist_frag.Inform
import com.example.gotogetherv3.Registration.Registr_frag.Inf_more
import com.example.gotogetherv3.Registration.Registr_frag.Information
import com.example.gotogetherv3.Registration.Registr_frag.Interes
import com.example.gotogetherv3.Registration.Registr_frag.Registr
import kotlinx.android.synthetic.main.registration_information.view.*
import me.itangqi.waveloadingview.WaveLoadingView
import org.json.JSONObject
import java.util.regex.Matcher
import java.util.regex.Pattern

class Registration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        var page = 0
        val main_but = findViewById<CardView>(R.id.registr_but)
        val text = findViewById<TextView>(R.id.registr_main_text)

        val fragStart : FragmentTransaction = supportFragmentManager.beginTransaction()
        fragStart.add(R.id.regist_cont, Registr())
        fragStart.commit()





        main_but.setOnClickListener {
            when(page){
                0 -> {
                    var e_b = false
                    var p_b = false
                    val email = findViewById<EditText>(R.id.registration_registr_email)
                    val pas = findViewById<EditText>(R.id.registration_registr_pas)


                    if (email.text == null || isEmail(email.text.toString()) == false){
                        e_b = false
                        Log.d("Error_mail", "hz chto")
                    }else e_b = true
                    if (pas.text === null || pas.text.toString().length < 5) {
                        p_b = false
                        Log.d("Error_pas", "hz chto")
                    }else p_b = true

                    if (e_b == true && p_b ==true ){

                        val url = "http://84.201.167.48:3000/api/v1/signup"

//                        val params = HashMap<String,Any>()
//                        params["email"] =email.text.toString()
//                        params["password"] = pas.text.toString()
//                        params["password_confirmation"] = pas.text.toString()

                        val jsonobj =JSONObject()
                        jsonobj.put("email", email.text.toString())
                        jsonobj.put("password", pas.text.toString())
                        jsonobj.put("password_confirmation", pas.text.toString())

                        val que = Volley.newRequestQueue(this)
                        val req = object: JsonObjectRequest(Method.POST, url, jsonobj,
                            com.android.volley.Response.Listener<JSONObject>{
                                response ->
                                Log.d("Error_response_tr", "hz chto")

                                var sharPerf : SharedPreferences = this.getSharedPreferences("User_data", Context.MODE_PRIVATE)
                                var editor : SharedPreferences.Editor = sharPerf.edit()
                                editor.putString("id", response.getString("id"))
                                editor.putString("token", response.getString("token"))
                                Log.d("IDIDI",response.getString("id") )
                                editor.commit()

                                var sharPer : SharedPreferences = this.getSharedPreferences("User_data", Context.MODE_PRIVATE)
                                var edit : SharedPreferences.Editor = sharPerf.edit()
                                edit.putString("mail", email.text.toString())
                                edit.putString("pass", pas.text.toString())
                                Log.d("MAIl",sharPer.getString("mail",""))
                                edit.commit()

                                text.text = "Информация"
                                val fragStart : FragmentTransaction = supportFragmentManager.beginTransaction()
                                fragStart.setCustomAnimations(R.anim.anim_right_to_left,R.anim.anim_exit,R.anim.anim_right_to_left,R.anim.anim_exit_2)
                                fragStart.replace(R.id.regist_cont, Information())
                                fragStart.commit()
                                page += 1


                        },com.android.volley.Response.ErrorListener{
                                error ->
                                Log.d("Error_response", error.toString())
                            })

                        {

                        }
                        que.add(req)
                    }
                    true
                }
                1->{

                    var sharPerf : SharedPreferences = this.getSharedPreferences("User_data", Context.MODE_PRIVATE)
                    val name = findViewById<EditText>(R.id.registration_information_name)
                    val date = findViewById<TextView>(R.id.registration_information_date_text)
                    val radio_gr =  findViewById<RadioGroup>(R.id.registration_information_radio)

                    var n_b = false
                    var d_b = false
                    var r_m_b = false
                    var r_w_b = false
                    var r_b = false

                    var id =radio_gr.checkedRadioButtonId
                    when (id){
                        R.id.registration_information_radio_woman -> r_w_b = true
                        R.id.registration_information_radio_man -> r_m_b = true
                    }

                    if (name.text == null || name.text.toString().matches("-?\\d+(\\.\\d+)?".toRegex())== true || name.text.length < 2) {
                        n_b = false
                    }else {n_b = true}
                    if (date.text == null){
                        d_b = false
                    }else d_b = true
                    if(r_w_b == false || r_m_b == false){
                        r_b = false
                    }else r_b = true

                    if (n_b == true && d_b == true && r_b == true){

//
//                        val url = "http://84.201.167.48:3000/api/v1/users/" + sharPerf.getString("id", "")
//
//                        val params = HashMap<String,Any>()
//                        params["email"] =email.text.toString()
//                        params["password"] = pas.text.toString()
//                        params["password_confirmation"] = pas.text.toString()
//
//                        val jsonobj =JSONObject(params)
//
//                        val que = Volley.newRequestQueue(this)
//                        val req = object: JsonObjectRequest(Method.POST, url, jsonobj,
//                            com.android.volley.Response.Listener<JSONObject>{
//                                    response ->
//
//
//
//
//
//                            },com.android.volley.Response.ErrorListener{
//                            })
//
//                        {
//
//                        }
                        text.text = "Ещё немного о вас"
                        val fragStart : FragmentTransaction = supportFragmentManager.beginTransaction()
                        fragStart.setCustomAnimations(R.anim.anim_right_to_left,R.anim.anim_exit,R.anim.anim_right_to_left,R.anim.anim_exit_2)
                        fragStart.replace(R.id.regist_cont, Inf_more())
                        fragStart.commit()
                        page += 1
                        true
                    }
                }
                2->{

                    text.text = "Интересы"
                    val fragStart : FragmentTransaction = supportFragmentManager.beginTransaction()
                    fragStart.setCustomAnimations(R.anim.anim_right_to_left,R.anim.anim_exit,R.anim.anim_right_to_left,R.anim.anim_exit_2)
                     fragStart.replace(R.id.regist_cont, Interes())
                    fragStart.commit()
                    page += 1
                    true
                }
                3->{



                    intent = Intent(this, MainActivity :: class.java)
                    startActivity(intent)
                    page += 1
                    true
                }
                else -> page = 0
            }
        }






    }



}

fun isEmail(s : String): Boolean {
    val email = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
    var pattern : Pattern =  Pattern.compile(email, Pattern.CASE_INSENSITIVE)
    var matcher : Matcher = pattern.matcher(s)


    return matcher.matches()
}
