package com.bytelogs.obvious.view

import android.content.Context
import com.bytelogs.obvious.model.ApodResponse
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bytelogs.obvious.BR
import com.bytelogs.obvious.R
import com.bytelogs.obvious.databinding.ItemFullBinding



class ApodPagerAdapter(apodList: List<ApodResponse>): RecyclerView.Adapter<ApodPagerAdapter.ApodPagerViewHolder>() {
    private  var apodList:List<ApodResponse>
    public lateinit var context: Context
    init {
        this.apodList = apodList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApodPagerViewHolder {
        context = parent.context
        val binding: ItemFullBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_full, parent, false)
        return ApodPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ApodPagerViewHolder, position: Int) {
        holder.bind(apodList[position])
    }

    override fun getItemCount(): Int {
        return apodList.size
    }

    fun updatePostList(apodList:List<ApodResponse>){
        this.apodList = apodList
        notifyDataSetChanged()
    }

    class ApodPagerViewHolder(private val binding: ItemFullBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(obj: ApodResponse) {
            binding.setVariable(BR.apodResponse, obj)
            binding.executePendingBindings()
        }
    }
}