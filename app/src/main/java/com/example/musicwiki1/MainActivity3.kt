package com.example.musicwiki1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONObject
import java.util.*

class MainActivity3 : AppCompatActivity() {
    private lateinit var headingtext : TextView
    private lateinit var textsum : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        headingtext=findViewById(R.id.textView11)
        textsum=findViewById(R.id.textView2)
        val albName= intent.getStringExtra("albumName")
        val genrename= intent.getStringExtra("genre")
        headingtext.text=albName

            if(albName=="COLDPLAY") {
                val text1 =
                    "Coldplay are a British rock band formed in London in 1997. They consist of vocalist and pianist Chris Martin, guitarist Jonny Buckland, bassist Guy Berryman, drummer Will Champion and creative director Phil Harvey."
                textsum.text = text1
            }

        if (albName=="MINUTES TO MIDNIGHT")
        {
            val text1="Minutes to Midnight is the third studio album by American rock band Linkin Park, released on May 14, 2007, through Warner Bros. Records. The album was produced by Mike Shinoda and Rick Rubin, and it is Linkin Park's first studio album produced without Don Gilmore, who had produced the band's two previous albums."
            textsum.text=text1
        }

    }
}