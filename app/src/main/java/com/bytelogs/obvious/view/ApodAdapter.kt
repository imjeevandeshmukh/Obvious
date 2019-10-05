package com.bytelogs.obvious.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bytelogs.obvious.model.ApodResponse
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bytelogs.obvious.databinding.ItemApodBinding
import com.bytelogs.obvious.BR
import com.bytelogs.obvious.R
import java.util.*
import kotlin.collections.ArrayList


class ApodAdapter(apodList: MutableList<ApodResponse>): RecyclerView.Adapter<ApodAdapter.ApodViewHolder>() {
    private  var apodList:MutableList<ApodResponse>
    public lateinit var context: Context
    init {
        this.apodList = apodList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApodAdapter.ApodViewHolder {
        context = parent.context
        val binding: ItemApodBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_apod, parent, false)
        return ApodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ApodAdapter.ApodViewHolder, position: Int) {
        holder.bind(apodList[position],position,context,apodList)
    }

    override fun getItemCount(): Int {
        return  apodList.size
    }

    fun updatePostList(apodList:MutableList<ApodResponse>){
        this.apodList = apodList
        notifyDataSetChanged()
    }

    class ApodViewHolder(private val binding: ItemApodBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(obj: ApodResponse,position: Int,context: Context,apodList: MutableList<ApodResponse>) {
            binding.setVariable(BR.apodResponse, obj)
            binding.executePendingBindings()
            binding.cardViewItem.setOnClickListener(View.OnClickListener {
                val intent = Intent(context, FullScreenActivity::class.java)
                val bundle = Bundle().apply {
                    putSerializable("ApodResponseList", apodList as ArrayList)
                    putInt("Position",position)
                }
                intent.putExtras(bundle)
                context.startActivity(intent)

            })
        }
    }
}