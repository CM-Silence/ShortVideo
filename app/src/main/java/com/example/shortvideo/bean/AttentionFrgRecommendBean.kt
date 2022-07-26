package com.example.shortvideo.bean

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.shortvideo.R
import java.lang.Exception
import javax.sql.DataSource

/**
 * @ClassName AttentionFrgRecommendBean
 * @author Silence~
 * @date 2022/7/18
 * @Description 推荐用户
 */
data class AttentionFrgRecommendBean(
    var data : List<Data>, //被推荐的用户信息
    var msg : String,
    var code : Int
){
    class Data{
        var userID = 0 //用户ID
        var nickname = "" //昵称
        var avatar = "" //用户头像
        var fansNum = "0" //粉丝数
        var jokesNum = "0" //发布的段子数
        var isAttention = false //你是否已经关注

        fun getNum() : String {
            return "发表 $jokesNum   粉丝 $fansNum"
        }

        companion object {
            @JvmStatic
            @BindingAdapter("profileImage")
            fun loadImage(image: ImageView, imgUrl: String) {
                Glide.with(image.context)
                    .load(imgUrl)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(image)

            }

            @SuppressLint("ResourceAsColor")
            @JvmStatic
            @BindingAdapter("buttonStyle")
            fun loadButtonStyle(button: Button, isAttention : Boolean) {
                if(isAttention){
                    button.setBackgroundResource(R.drawable.transparent_round)
                    button.text = "已关注"
                    button.setTextColor(R.color.black)
                }
                else{
                    button.setBackgroundResource(R.drawable.orange_round)
                    button.text = "+关注"
                    button.setTextColor(R.color.white)
                }
            }
        }
    }
}