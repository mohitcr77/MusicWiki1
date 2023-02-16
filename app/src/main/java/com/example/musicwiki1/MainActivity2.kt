package com.example.musicwiki1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONObject
import java.util.*

private var buttonName : String = ""

class MainActivity2 : AppCompatActivity() {

    private lateinit var tagsummary : TextView
    private lateinit var tagartist1 : TextView
    private lateinit var tagartist2 : TextView
    private lateinit var tagartist3 : TextView
    private lateinit var tagartist4 : TextView
    private lateinit var imgview1 : ImageView
    private lateinit var imgview2 : ImageView
    private lateinit var imgview3 : ImageView
    private lateinit var imgview4 : ImageView
    private lateinit var artistbtn : Button

    private lateinit var tagheading : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        tagheading = findViewById(R.id.tagHeading)
        tagartist1=findViewById(R.id.artisttv1)
        tagartist2=findViewById(R.id.artisttv2)
        tagartist3=findViewById(R.id.artisttv3)
        tagartist4=findViewById(R.id.artisttv4)
        imgview1=findViewById(R.id.imageView1)
        imgview2=findViewById(R.id.imageView2)
        imgview3=findViewById(R.id.imageView3)
        imgview4=findViewById(R.id.imageView4)
        artistbtn=findViewById(R.id.buttonartist)
        supportActionBar?.hide()
        tagsummary = findViewById(R.id.tagsummary)

        buttonName= intent.getStringExtra("buttontext").toString()
        tagheading.text=buttonName
        loadartist()

        artistbtn.setOnClickListener(){
            loadartist()
        }


        // for summary
        val url = "https://ws.audioscrobbler.com/2.0/?method=tag.getinfo&tag=$buttonName&api_key=ba019106b2d688a14edf1d2ff1881822&format=json"
        val queue = Volley.newRequestQueue(this)

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                val tag= response.getString("tag")
                val obj = JSONObject(tag)
                val wiki = obj.getString("wiki")
                val obj1= JSONObject(wiki)
                val summary = obj1.getString("summary")
                tagsummary.text=summary
                tagsummary.movementMethod=ScrollingMovementMethod()
            },
            {
                Toast.makeText(this, "Something went wrong ", Toast.LENGTH_SHORT).show()
            })
        queue.add(jsonObjectRequest)



        }

    fun onclickalbum(view: View)
    {
        val b = view as TextView
        val buttonText1 = b.getText().toString()
        val intent = Intent(this@MainActivity2, MainActivity3::class.java)
        intent.putExtra("albumName",buttonText1)
        intent.putExtra("genre", buttonName)
        startActivity(intent)
    }

    fun loadtracks(view: View) {
        val url1 =
            "https://ws.audioscrobbler.com/2.0/?method=tag.gettoptracks&tag=$buttonName&api_key=dc604a133bcdd0381d22346c51f619c1&format=json"
        val queue1 = Volley.newRequestQueue(this)

        val jsonObjectRequest1 = JsonObjectRequest(
            Request.Method.GET, url1, null,
            { response ->
                val album = response.getString("tracks")
                val obj = JSONObject(album)
                val jsonArray = obj.getJSONArray("track")
                val imgarray = jsonArray.getJSONObject(0).getJSONArray("image")
                val imgarray1 = jsonArray.getJSONObject(0).getJSONArray("image")
                val imgarray2 = jsonArray.getJSONObject(0).getJSONArray("image")
                val imgarray3 = jsonArray.getJSONObject(0).getJSONArray("image")


                //setting the values to layout
                val name1 = jsonArray.getJSONObject(0).getString("name")
                tagartist1.text = name1.uppercase(Locale.ROOT)
                val img1 = imgarray.getJSONObject(1).getString("#text")
                Glide.with(this).load(img1).into(imgview1)


                val name2 = jsonArray.getJSONObject(1).getString("name")
                tagartist2.text = name2.uppercase(Locale.ROOT)
                val img2 = imgarray1.getJSONObject(1).getString("#text")
                Glide.with(this).load(img2).into(imgview2)

                val name3 = jsonArray.getJSONObject(2).getString("name")
                tagartist3.text = name3.uppercase(Locale.ROOT)
                val img3 = imgarray2.getJSONObject(1).getString("#text")
                Glide.with(this).load(img3).into(imgview3)

                val name4 = jsonArray.getJSONObject(3).getString("name")
                tagartist4.text = name4.uppercase(Locale.ROOT)
                val img4 = imgarray3.getJSONObject(1).getString("#text")
                Glide.with(this).load(img4).into(imgview4)
            },
            {
                Toast.makeText(this, "Something went wrong in artist ", Toast.LENGTH_SHORT)
                    .show()
            })
        queue1.add(jsonObjectRequest1)
    }


    fun loadalbum(view: View){

        val url1 =
            "https://ws.audioscrobbler.com/2.0/?method=tag.gettopalbums&tag=$buttonName&api_key=dc604a133bcdd0381d22346c51f619c1&format=json"
        val queue1 = Volley.newRequestQueue(this)

        val jsonObjectRequest1 = JsonObjectRequest(
            Request.Method.GET, url1, null,
            { response ->
                val album = response.getString("albums")
                val obj = JSONObject(album)
                val jsonArray = obj.getJSONArray("album")
                val imgarray = jsonArray.getJSONObject(0).getJSONArray("image")
                val imgarray1 = jsonArray.getJSONObject(0).getJSONArray("image")
                val imgarray2 = jsonArray.getJSONObject(0).getJSONArray("image")
                val imgarray3 = jsonArray.getJSONObject(0).getJSONArray("image")


                //setting the values to layout
                val name1 = jsonArray.getJSONObject(0).getString("name")
                tagartist1.text = name1.uppercase(Locale.ROOT)
                val img1 = imgarray.getJSONObject(1).getString("#text")
                Glide.with(this).load(img1).into(imgview1)


                val name2 = jsonArray.getJSONObject(1).getString("name")
                tagartist2.text = name2.uppercase(Locale.ROOT)
                val img2 = imgarray1.getJSONObject(1).getString("#text")
                Glide.with(this).load(img2).into(imgview2)

                val name3 = jsonArray.getJSONObject(2).getString("name")
                tagartist3.text = name3.uppercase(Locale.ROOT)
                val img3 = imgarray2.getJSONObject(1).getString("#text")
                Glide.with(this).load(img3).into(imgview3)

                val name4 = jsonArray.getJSONObject(3).getString("name")
                tagartist4.text = name4.uppercase(Locale.ROOT)
                val img4 = imgarray3.getJSONObject(1).getString("#text")
                Glide.with(this).load(img4).into(imgview4)
            },
            {
                Toast.makeText(this, "Something went wrong in artist ", Toast.LENGTH_SHORT)
                    .show()
            })
        queue1.add(jsonObjectRequest1)

    }







     fun loadartist() {
         //for artist
         val url1 =
             "https://ws.audioscrobbler.com/2.0/?method=tag.gettopartists&tag=$buttonName&api_key=dc604a133bcdd0381d22346c51f619c1&format=json"
         val queue1 = Volley.newRequestQueue(this)

         val jsonObjectRequest1 = JsonObjectRequest(
             Request.Method.GET, url1, null,
             { response ->
                 val topartist = response.getString("topartists")
                 val obj = JSONObject(topartist)
                 val jsonArray = obj.getJSONArray("artist")
                 val imgarray = jsonArray.getJSONObject(0).getJSONArray("image")
                 val imgarray1 = jsonArray.getJSONObject(0).getJSONArray("image")
                 val imgarray2 = jsonArray.getJSONObject(0).getJSONArray("image")
                 val imgarray3 = jsonArray.getJSONObject(0).getJSONArray("image")


                 //setting the values to layout
                 val name1 = jsonArray.getJSONObject(0).getString("name")
                 tagartist1.text = name1.uppercase(Locale.ROOT)
                 val img1 = imgarray.getJSONObject(1).getString("#text")
                 Glide.with(this).load(img1).into(imgview1)


                 val name2 = jsonArray.getJSONObject(1).getString("name")
                 tagartist2.text = name2.uppercase(Locale.ROOT)
                 val img2 = imgarray1.getJSONObject(1).getString("#text")
                 Glide.with(this).load(img2).into(imgview2)

                 val name3 = jsonArray.getJSONObject(2).getString("name")
                 tagartist3.text = name3.uppercase(Locale.ROOT)
                 val img3 = imgarray2.getJSONObject(1).getString("#text")
                 Glide.with(this).load(img3).into(imgview3)

                 val name4 = jsonArray.getJSONObject(3).getString("name")
                 tagartist4.text = name4.uppercase(Locale.ROOT)
                 val img4 = imgarray3.getJSONObject(1).getString("#text")
                 Glide.with(this).load(img4).into(imgview4)
             },
             {
                 Toast.makeText(this, "Something went wrong in artist ", Toast.LENGTH_SHORT)
                     .show()
             })
         queue1.add(jsonObjectRequest1)

     }


}
