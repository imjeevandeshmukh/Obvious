package com.bytelogs.obvious.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.bytelogs.obvious.R
import com.bytelogs.obvious.databinding.ActivityFullScreenBinding
import com.bytelogs.obvious.model.ApodResponse

class FullScreenActivity : AppCompatActivity() {

    private lateinit var activityFullScreenBinding:ActivityFullScreenBinding
    private lateinit  var apodList:MutableList<ApodResponse>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        activityFullScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_full_screen)
        processIntent(intent)

    }
    @Suppress("UNCHECKED_CAST")
    fun processIntent(intent: Intent){
        val position = intent.getIntExtra("Position",0)
        apodList = intent.getSerializableExtra("ApodResponseList") as ArrayList<ApodResponse>
        activityFullScreenBinding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        activityFullScreenBinding.viewPager2.adapter = ApodPagerAdapter(apodList)
        activityFullScreenBinding.viewPager2.currentItem = position



    }
}
