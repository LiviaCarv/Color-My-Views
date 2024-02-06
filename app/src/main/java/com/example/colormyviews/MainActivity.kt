package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(txt_box_one,txt_box_two,txt_box_three,
            txt_box_four,txt_box_five,constraintLayout)
        for (view in clickableViews){
            view.setOnClickListener{ makeItColored(it)}
        }
    }

    private fun makeItColored(view: View) {
        when(view.id) {
            R.id.txt_box_one -> view.setBackgroundColor(Color.RED)
            R.id.txt_box_two -> view.setBackgroundColor(Color.BLUE)
            R.id.txt_box_three -> view.setBackgroundColor(Color.GREEN)
            R.id.txt_box_four -> view.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_green_light))
            R.id.txt_box_five -> view.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}