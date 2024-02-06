package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.txt_text)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(txt_box_one,txt_box_two,txt_box_three,
            txt_box_four,txt_box_five,txt_phrase,btn_green,btn_red,btn_yellow)
        for (view in clickableViews){
            if (view is Button) {
                view.setOnClickListener { colorAllViews(it,clickableViews) }
            } else {
                view.setOnClickListener{ makeItColored(it) }
            }
        }

    }

    private fun colorAllViews(view: View, viewsList: List<View> ) {
        when(view.id) {
            R.id.btn_green -> viewsList.forEach{
                it.setBackgroundColor(ContextCompat.getColor(this,R.color.btn_green)) }
            R.id.btn_red -> viewsList.forEach {
                it.setBackgroundColor(ContextCompat.getColor(this,R.color.btn_red)) }
            R.id.btn_yellow -> viewsList.forEach {
                it.setBackgroundColor(ContextCompat.getColor(this,R.color.btn_yellow)) }
        }
        setTextToUser(view)
    }

    private fun setTextToUser(view: View) {
        var phraseId = R.string.give_me_some_collors
        if (view is Button) {
            when(view.id) {
                R.id.btn_green -> phraseId = R.string.love_green
                R.id.btn_red -> phraseId = R.string.love_red
                R.id.btn_yellow -> phraseId = R.string.love_yellow
            }
        } else if (view is TextView) {
            phraseId = R.string.nice_box
        } else  {
            phraseId = R.string.nice_background
        }
        text.setText(phraseId)
    }

    private fun makeItColored(view: View) {
        when(view.id) {
            R.id.txt_box_one -> view.setBackgroundColor(Color.CYAN)
            R.id.txt_box_two -> view.setBackgroundColor(Color.BLUE)
            R.id.txt_box_three -> view.setBackgroundColor(Color.GREEN)
            R.id.txt_box_four -> view.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_green_light))
            R.id.txt_box_five -> view.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
            else -> view.setBackgroundColor(ContextCompat.getColor(this, R.color.background))
        }
        setTextToUser(view)
    }
}