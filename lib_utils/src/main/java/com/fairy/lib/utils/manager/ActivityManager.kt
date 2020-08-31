package com.fairy.lib.utils.manager

import android.app.Activity
import android.content.Context
import android.text.TextUtils
import java.util.*

/**
 * 应用程序Activity管理类：用于Activity管理和应用程序退出
 *
 * @author: Fairy.
 * @date  : 2019-08-15.
 */
class ActivityManager {

    private var activityStack: Stack<Activity> = Stack()

    companion object {
        val INSTANCE: ActivityManager by lazy {
            ActivityManager()
        }
    }

    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity) {
        if (activityStack == null) {
            activityStack = Stack()
        }
        activityStack.add(activity)
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    fun currentActivity(): Activity? {
        return if (activityStack == null) {
            null
        } else activityStack.lastElement()
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    fun finishActivity() {
        if (activityStack == null) {
            return
        }
        val activity = activityStack.lastElement()
        finishActivity(activity)
    }

    /**
     * 结束指定的Activity
     */
    fun finishActivity(activity: Activity?) {
        var activity = activity
        if (activityStack == null) {
            return
        }
        if (activity != null) {
            activityStack.remove(activity)
            activity.finish()
            activity = null
        }
    }

    /**
     * 结束指定类名的Activity
     */
    fun finishActivity(cls: Class<*>) {
        if (activityStack == null) {
            return
        }
        val iterator = activityStack.iterator()
        while (iterator.hasNext()) {
            val activity = iterator.next()
            if (activity != null && activity.javaClass == cls) {
                activity.finish()
                iterator.remove()
            }
        }
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        if (activityStack == null) {
            return
        }
        val iterator = activityStack.iterator()
        while (iterator.hasNext()) {
            val activity = iterator.next()
            if (activity != null && !activity.isFinishing) {
                activity.finish()
            }
        }
        activityStack.clear()
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity(vararg cls: Class<*>) {
        if (activityStack == null) {
            return
        }
        val iterator = activityStack.iterator()
        while (iterator.hasNext()) {
            val activity = iterator.next()
            if (activity != null && !activity.isFinishing && cls != null && activity != cls) {
                activity.finish()
            }
        }
        activityStack.clear()
    }

    /**
     * 根据ActivityName获取堆中Activity实例
     *
     * @param activityName
     * @return
     */
    fun getActivity(activityName: String): Activity? {
        val iterator = activityStack.iterator()
        while (iterator.hasNext()) {
            val activity = iterator.next()
            if (activity != null && TextUtils.equals(activity.javaClass.name, activityName)) {
                return activity
            }
        }
        return null
    }

    /**
     * 退出应用程序
     */
    fun appExit(context: Context) {
        try {
            finishAllActivity()
            android.os.Process.killProcess(android.os.Process.myPid())
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}