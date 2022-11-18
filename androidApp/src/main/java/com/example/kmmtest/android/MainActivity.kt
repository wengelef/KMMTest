package com.example.kmmtest.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.kmmtest.Greeting
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.Preferences
import com.example.kmmtest.CommonViewModel

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { CommonViewModel(Preferences(this, "test")) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()

        val button: Button = findViewById(R.id.incrementButton)
        button.setOnClickListener { viewModel.increaseValue() }

        lifecycleScope.launchWhenStarted {
            viewModel.values.collect {
                tv.text = it.toString()
            }
        }
    }
}
