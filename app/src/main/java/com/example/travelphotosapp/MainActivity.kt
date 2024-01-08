package com.example.travelphotosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentImage = 0;
    lateinit var image : ImageView

    var placesArray = arrayOf("Hawa Mahal", "Taj Mahal", "Chaar Minaar", "India Gate", "Red Fort")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val prev = findViewById<ImageButton>(R.id.btnPrev)
        val next = findViewById<ImageButton>(R.id.btnNext)
        val placeName = findViewById<TextView>(R.id.tVName)

        next.setOnClickListener() {
            // i want to get the next image
            var idCurrentImageString = "pic_$currentImage"

            // get integer address associated with each view
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f // make it invisible


            // move to next image
            currentImage = (5 + currentImage - 1) % 5
            var idImageToShowString = "pic_$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = placesArray[currentImage]
        }

        prev.setOnClickListener() {
            // i want to get the previous image
            var idCurrentImageString = "pic_$currentImage"

            // get integer address associated with each view
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f // make it invisible

            // move to prev image
            currentImage = (5 + currentImage + 1) % 5
            var idImageToShowString = "pic_$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = placesArray[currentImage]

        }
    }
}