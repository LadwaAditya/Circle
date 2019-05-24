package com.adityaladwa.circle

import android.animation.AnimatorInflater
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loadAnimator = AnimatorInflater.loadAnimator(this, R.animator.translate_y)
        loadAnimator.setTarget(circle)
        loadAnimator.start()
    }
}
