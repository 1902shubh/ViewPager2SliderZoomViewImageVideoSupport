package com.papayacoders.horizontalrecylerviewasslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = listOf(
            "https://images.unsplash.com/photo-1575936123452-b67c3203c357?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8aW1hZ2V8ZW58MHx8MHx8&w=1000&q=80",
            "https://static.photocdn.pt/images/articles/2018/12/05/articles/2017_8/beginner_photography_mistakes-1.webp",
            "https://user-images.githubusercontent.com/46995327/119235768-bc402e80-bb51-11eb-8b77-1e2a979df5a4.mp4",
            "https://img.freepik.com/free-photo/woman-taking-photo-during-day-with-blur-background_23-2148027223.jpg"
        )

        val sliderRecyclerView = findViewById<ViewPager2>(R.id.sliderViewPager)
        val sliderAdapter = SliderAdapter(items)
        sliderRecyclerView.adapter = sliderAdapter

//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(sliderRecyclerView)
    }
}