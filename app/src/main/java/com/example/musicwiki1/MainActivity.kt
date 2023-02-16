package com.example.musicwiki1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var tagNametv1 : TextView
    private lateinit var tagNametv2 : TextView
    private lateinit var tagNametv3 : TextView
    private lateinit var tagNametv4 : TextView
    private lateinit var tagNametv5 : TextView
    private lateinit var tagNametv6 : TextView
    private lateinit var tagNametv7 : TextView
    private lateinit var tagNametv8 : TextView
    private lateinit var tagNametv9 : TextView
    private lateinit var tagNametv10 : TextView
    private lateinit var clk_button : FloatingActionButton
    private lateinit var clk_button1 : FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tagNametv1 = findViewById(R.id.tagName1)
        tagNametv2 = findViewById(R.id.tagName2)
        tagNametv3 = findViewById(R.id.tagName3)
        tagNametv4 = findViewById(R.id.tagName4)
        tagNametv5 = findViewById(R.id.tagName5)
        tagNametv6 = findViewById(R.id.tagName6)
        tagNametv7 = findViewById(R.id.tagName7)
        tagNametv8 = findViewById(R.id.tagName8)
        tagNametv9 = findViewById(R.id.tagName9)
        tagNametv10 = findViewById(R.id.tagName10)
        clk_button = findViewById(R.id.fab)
        clk_button1 = findViewById(R.id.fab2)


        tagNametv7.visibility= View.GONE
        tagNametv8.visibility= View.GONE
        tagNametv9.visibility= View.GONE
        tagNametv10.visibility= View.GONE

        supportActionBar?.hide()
        loadTag()




        clk_button.setOnClickListener()
        {
            val clk_rotate = AnimationUtils.loadAnimation(
                this,
                R.anim.rotateon1
            )
            clk_button.visibility= View.GONE
            clk_button1.visibility= View.VISIBLE


            tagNametv7.visibility= View.VISIBLE
            tagNametv8.visibility= View.VISIBLE
            tagNametv9.visibility= View.VISIBLE
            tagNametv10.visibility= View.VISIBLE
            // assigning that animation to
            // the image and start animation
            clk_button.startAnimation(clk_rotate)
        }

        clk_button1.setOnClickListener()
        {
            val clk_rotate1 = AnimationUtils.loadAnimation(
                this,
                R.anim.rotateon2
            )
            clk_button1.visibility= View.GONE
            clk_button.visibility= View.VISIBLE
            // assigning that animation to
            // the image and start animation
            clk_button.startAnimation(clk_rotate1)

            tagNametv7.visibility= View.GONE
            tagNametv8.visibility= View.GONE
            tagNametv9.visibility= View.GONE
            tagNametv10.visibility= View.GONE


        }


    }

     fun changeactivity(view: View)
    {
        val b = view as TextView
        val buttonText = b.getText().toString()
        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        intent.putExtra("buttontext",buttonText)
        startActivity(intent)




    }





    private fun loadTag() {

        val url = "https://ws.audioscrobbler.com/2.0/?method=tag.getTopTags&api_key=ba019106b2d688a14edf1d2ff1881822&format=json"
        val queue = Volley.newRequestQueue(this)

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                val toptag= response.getString("toptags")
                val obj = JSONObject(toptag)
                //val tag = obj.getString("tag")

                val jsonArray = obj.getJSONArray("tag")

                val name1 = jsonArray.getJSONObject(0).getString("name")
                tagNametv1.text = name1.uppercase(Locale.ROOT)

                val name2 = jsonArray.getJSONObject(1).getString("name")
                tagNametv2.text = name2.uppercase(Locale.ROOT)

                val name3 = jsonArray.getJSONObject(2).getString("name")
                tagNametv3.text = name3.uppercase(Locale.ROOT)

                val name4 = jsonArray.getJSONObject(3).getString("name")
                tagNametv4.text = name4.uppercase(Locale.ROOT)

                val name5 = jsonArray.getJSONObject(4).getString("name")
                tagNametv5.text = name5.uppercase(Locale.ROOT)

                val name6 = jsonArray.getJSONObject(5).getString("name")
                tagNametv6.text = name6.uppercase(Locale.ROOT)

                val name7 = jsonArray.getJSONObject(6).getString("name")
                tagNametv7.text = name7.uppercase(Locale.ROOT)

                val name8 = jsonArray.getJSONObject(7).getString("name")
                tagNametv8.text = name8.uppercase(Locale.ROOT)

                val name9 = jsonArray.getJSONObject(8).getString("name")
                tagNametv9.text = name9.uppercase(Locale.ROOT)

                val name10 = jsonArray.getJSONObject(9).getString("name")
                tagNametv10.text = name10.uppercase(Locale.ROOT)




            },
            {
                Toast.makeText(this, "Something went wrong ", Toast.LENGTH_SHORT).show()
            })
        queue.add(jsonObjectRequest)

    }



}