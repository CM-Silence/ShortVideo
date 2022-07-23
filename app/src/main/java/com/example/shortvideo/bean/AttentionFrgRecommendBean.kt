package com.example.shortvideo.bean

import com.example.shortvideo.R

/**
 * @ClassName AttentionFrgRecommendBean
 * @author Silence~
 * @date 2022/7/18
 * @Description 推荐用户
 */
data class AttentionFrgRecommendBean(
    var dataList : List<Data>, //被推荐的用户信息
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

        fun getAttentionBackground() : Int{
            return if(isAttention){
                R.drawable.transparent_round
            } else{
                R.drawable.transparent_round
            }
        }

        fun getAttentionText() : String{
            return if(isAttention){
                "已关注"
            } else{
                "+关注"
            }
        }

        fun getAttentionColor() : Int{
            return if(isAttention){
                R.color.black
            } else{
                R.color.white
            }
        }
    }
}