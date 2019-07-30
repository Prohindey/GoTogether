package com.example.gotogetherv3.Full_card_frag

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.gotogetherv3.Adapter.Date_and_time
import com.example.gotogetherv3.Adapter.Full_card_photo
import com.example.gotogetherv3.Data.Date_time
import com.example.gotogetherv3.Data.Event
import com.example.gotogetherv3.R
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.json.JSONObject


class Full_card_frag : Fragment(), OnMapReadyCallback {



    private var googleMap:GoogleMap?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?  {
        val v = inflater.inflate(R.layout.full_card_fragment, container, false)


        val card_name = v.findViewById<TextView>(R.id.full_card_text_name)
        val card_rec_photo = v.findViewById<RecyclerView>(R.id.full_card_rec_photo)
        val card_dis_text = v.findViewById<TextView>(R.id.full_card_text_dis)
        val card_dis_but = v.findViewById<ImageView>(R.id.full_card_img_dis)
        val card_price = v.findViewById<TextView>(R.id.full_card_text_price)
        val card_age = v.findViewById<TextView>(R.id.full_card_text_age)
        val card_map_name = v.findViewById<TextView>(R.id.full_card_text_map_name)
        val card_rec_date = v.findViewById<RecyclerView>(R.id.full_card_rec_date_time)

        var photos : ArrayList<String> = ArrayList()
        var date_time : ArrayList<Date_time> = ArrayList()

        var name : String
        var dis_b: String
        var price : String
        var age : String
        var map_name : String



        var l = false

        val ID = this.arguments?.getString("ID")
        val url = "http://84.201.167.48:3000/api/v1/events/" + ID

        val que = Volley.newRequestQueue(v.context)
        val req = object: JsonObjectRequest(
            Method.GET, url, null,
            com.android.volley.Response.Listener<JSONObject>{
                    response ->

                 name = response.getString("title")
                Log.d("Name", response.getString("title"))
                 dis_b = response.getString("description") + response.getString("body_text")
                 price = response.getString("price")
                Log.d("PRICE", response.getString("price"))
                 age = response.getString("age_restriction")
                 map_name = "POKA HZ"
                 var photo = response.getJSONArray("images")
                for(i in 0..photo.length()-1){
                    photos.add(photo.getString(i))
                }
                date_time.add(Date_time("12.12.12", "wens", "12:00", "18:00"))
                date_time.add(Date_time("12.12.12", "wens", "12:00", "18:00"))


                card_rec_photo.layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.HORIZONTAL, false)
                var photo_adapter  = Full_card_photo(photos)
                card_rec_photo.adapter = photo_adapter

                card_rec_date.layoutManager = GridLayoutManager(v.context, 2)
                var date_adapter = Date_and_time(date_time)
                card_rec_date.adapter = date_adapter

                var dis_s = ""

                for(k in 0..100){
                    dis_s += dis_b[k]
                }

                card_name.text = name
                card_price.text = price
                card_age.text = age
                card_map_name.text = map_name
                card_dis_text.text = dis_s

                card_dis_but.setOnClickListener {
                    if (l == false){
                        l = true
                        card_dis_text.text = dis_b
                    }else{
                        l = false
                        card_dis_text.text = dis_s
                    }
                }



            },com.android.volley.Response.ErrorListener{
                    error ->
                Log.d("Error_response", error.toString())
            })

        {

        }
        que.add(req)






//        var name = "Lalala"
//        var dis_b = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse porta erat tellus. Praesent vehicula urna non turpis tincidunt, vel consequat erat iaculis. Integer vehicula tincidunt dui, maximus mollis orci egestas id. Ut mollis lectus sed purus porttitor, a volutpat ex gravida. Sed sed augue ut justo aliquam venenatis ac sit amet diam. Duis elementum dictum augue in malesuada. Nunc consectetur purus in dui pretium, maximus rhoncus purus suscipit. Duis sit amet ex non nisi consequat ultrices. Pellentesque risus elit, interdum sit amet velit at, pellentesque pharetra lacus. \n" +
//
//                "Nullam viverra lacus ex. Vivamus tincidunt tellus quis tincidunt sollicitudin. Vestibulum tempus libero vitae elit eleifend, viverra elementum leo dignissim. Fusce a pretium arcu. Donec vel fringilla nulla. Ut facilisis erat at tristique faucibus. Maecenas iaculis blandit facilisis. Integer vehicula metus porta dui mollis auctor in ac nisl. Vivamus nisl nulla, accumsan ac posuere nec, consequat id orci. \n" +
//
//                "Morbi id vulputate ligula. Maecenas non quam quis elit faucibus rhoncus. Donec volutpat efficitur nibh ut mattis. In arcu libero, dapibus luctus mauris eget, volutpat tempor tellus. Ut bibendum nec nisl non faucibus. Proin volutpat sollicitudin libero ut commodo. Donec gravida sem at nunc pellentesque iaculis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam placerat sem eros, sit amet vehicula odio vehicula eget. Phasellus finibus, ligula eget mattis iaculis, purus quam tempus ex, vitae egestas augue dolor vel diam. Praesent et tortor neque. Aliquam auctor magna eget ligula mattis fringilla. Fusce nulla enim, semper eget augue vitae, viverra auctor quam. Donec in fringilla ipsum, eget tincidunt mauris. Praesent posuere sapien feugiat risus accumsan aliquet. "
//        var dis_s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse porta erat tellus. Praesent vehicula urna non turpis tincidunt, vel consequat erat iaculis."
//        var price = "228P"
//        var age = "12+"
//        var map_name = "Spartan st"
//        photos.add("https://pp.userapi.com/c841521/v841521431/bc34/9dT9sbyU1AM.jpg")
//        photos.add("https://pp.userapi.com/c630519/v630519145/7516c/NAAuBEJe7fg.jpg")
//        photos.add("https://pp.userapi.com/c631624/v631624145/2e1e1/UheKrS3V330.jpg")
//        photos.add("https://pp.userapi.com/c631728/v631728145/23d68/zd6EI4JEIu0.jpg")
//        date_time.add(Date_time("12.12.12", "wens", "12:00", "18:00"))
//        date_time.add(Date_time("12.12.12", "wens", "12:00", "18:00"))
//        date_time.add(Date_time("12.12.12", "wens", "12:00", "18:00"))
//        date_time.add(Date_time("12.12.12", "wens", "12:00", "18:00"))
//        date_time.add(Date_time("12.12.12", "wens", "12:00", "18:00"))









        // mapView

        val card_map = fragmentManager?.findFragmentById(R.id.full_card_map) as SupportMapFragment?
        card_map?.getMapAsync(this)


        return v
    }

























    override fun onMapReady(p0: GoogleMap?) {
        googleMap = p0

        val latLng = LatLng(28.6139,77.2090)
        val markerOptions: MarkerOptions =MarkerOptions().position(latLng).title("New Delhi")

        // moving camera and zoom map

        val zoomLevel = 12.0f //This goes up to 21


        googleMap.let {
            it!!.addMarker(markerOptions)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel))
        }


    }

}