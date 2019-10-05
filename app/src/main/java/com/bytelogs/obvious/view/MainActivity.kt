package com.bytelogs.obvious.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bytelogs.obvious.App
import com.bytelogs.obvious.R
import com.bytelogs.obvious.databinding.ActivityMainBinding
import com.bytelogs.obvious.model.ApodResponse
import com.bytelogs.obvious.viewmodel.MainViewModel
import com.bytelogs.obvious.viewmodel.ViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var apodList:MutableList<ApodResponse>
    private lateinit var apodAdapter: ApodAdapter
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        (application as App).getApplicationComponent().inject(this)
        apodList = mutableListOf()
        mainViewModel = ViewModelProviders.of(this,viewModelFactory).get(MainViewModel::class.java)
        binding.mainViewModel = mainViewModel
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        apodAdapter = ApodAdapter(apodList)
        binding.mainRecyclerView.adapter = apodAdapter
        GlobalScope.launch (Dispatchers.Main) {fetchApods()}

    }

    private suspend fun fetchApods(){
        val arrayDates = getStartEndDates()
        mainViewModel.onFetchApods(arrayDates[0],arrayDates[1]).observe(this, Observer {
            apodAdapter.updatePostList(it as MutableList<ApodResponse>)

        })
    }
    fun getStartEndDates():Array<String>{
        val ymdFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val currentDate = getDaysAgo(1)
        val agoDate = getDaysAgo(10)
        val ago = ymdFormat.format(agoDate)
        val current = ymdFormat.format(currentDate)
        return arrayOf(ago,current)
    }


    fun getDaysAgo(daysAgo: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -daysAgo)
        return calendar.time
    }

}





