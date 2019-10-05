package com.bytelogs.obvious.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import it.sephiroth.android.library.imagezoom.ImageViewTouch
import it.sephiroth.android.library.imagezoom.ImageViewTouchBase
import java.io.Serializable

data class ApodResponse (

	@SerializedName("copyright") val copyright : String,
	@SerializedName("date") val date : String,
	@SerializedName("explanation") val explanation : String,
	@SerializedName("hdurl") val hdurl : String,
	@SerializedName("media_type") val media_type : String,
	@SerializedName("service_version") val service_version : String,
	@SerializedName("title") val title : String,
	@SerializedName("url") val url : String


):Serializable{

	companion object{
		@SuppressWarnings
        @BindingAdapter("android:imageUrl")
        @JvmStatic
        fun setImageUrl(imageView: ImageView, url: String?) {
            Glide.with(imageView.context).load(url).into(imageView)
        }
		@SuppressWarnings
		@BindingAdapter("android:loadUrl")
		@JvmStatic
		fun setUrl(touchImageView: ImageViewTouch, url: String?) {

			Glide.with(touchImageView.context).load(url).into(touchImageView)
			touchImageView.setDisplayType(ImageViewTouchBase.DisplayType.FIT_TO_SCREEN)

		}
    }

}