package com.example.shortvideo.base
import android.app.Activity

/**
 * @ClassName AppManager
 * @author Silence~
 * @date 2022/7/16
 * @Description 用于管理Activity和Fragment的类
 */
object AppManager {
    private val activities = ArrayList<Activity>()
    //private val fragments = ArrayList<Fragment>()

    /**
     * @Description 将一个Activity添加进列表中
     * @Param activity
     * @author Silence~
     * @date 2022/7/16 14:12
     */
    fun addActivity(activity: Activity){
        activities.add(activity)
    }

    /**
     * @Description 将一个Activity从列表中移除
     * @Param activity
     * @author Silence~
     * @date 2022/7/16 14:15
     */
    fun removeActivity(activity: Activity){
        activities.remove(activity)
    }

    /**
     * @Description 关闭所有的Activity并将列表清空
     * @author Silence~
     * @date 2022/7/16 14:16
     */
    fun finishAll(){
        for (activity in activities){
            if(!activity.isFinishing){
                activity.finish()
            }
        }
        activities.clear()
    }

}