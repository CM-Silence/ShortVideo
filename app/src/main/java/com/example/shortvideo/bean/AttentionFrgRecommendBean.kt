package com.example.shortvideo.bean

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
    }
}