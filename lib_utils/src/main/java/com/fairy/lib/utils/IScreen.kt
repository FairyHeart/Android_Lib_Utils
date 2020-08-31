package com.fairy.lib.utils

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * 屏幕相关工具类
 *
 * @author: Fairy.
 * @date  : 2020/8/31.
 */
/**
 * 获取屏幕的宽度（单位：px）
 *
 * @return 屏幕宽px
 */
fun Context.getScreenWidth(): Int {
    val windowManager = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val dm = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(dm)
    return dm.widthPixels
}

/**
 * 获取屏幕的高度（单位：px）
 *
 * @return 屏幕高px
 */
fun Context.getScreenHeight(): Int {
    val windowManager = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val dm = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(dm)
    return dm.heightPixels
}

/**
 * 获取屏幕密度
 */
fun Context.getDensityDpi(): Int {
    val metric = this.resources.displayMetrics
    return metric.densityDpi
}

/**
 * 设置屏幕为横屏
 *
 * 还有一种就是在Activity中加属性android:screenOrientation="landscape"
 *
 * 不设置Activity的android:configChanges时，切屏会重新调用各个生命周期，切横屏时会执行一次，切竖屏时会执行两次
 *
 * 设置Activity的android:configChanges="orientation"时，切屏还是会重新调用各个生命周期，切横、竖屏时只会执行一次
 *
 * 设置Activity的android:configChanges="orientation|keyboardHidden|screenSize"（4.0以上必须带最后一个参数）时
 * 切屏不会重新调用各个生命周期，只会执行onConfigurationChanged方法
 *
 */
fun Activity.setLandscape() {
    this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
}

/**
 * 设置屏幕为竖屏
 *
 */
fun Activity.setPortrait() {
    this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
}

/**
 * 判断是否横屏
 *
 * @return `true`: 是<br></br>`false`: 否
 */
fun Context.isLandscape(): Boolean {
    return this.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
}

/**
 * 判断是否竖屏
 *
 * @return `true`: 是<br></br>`false`: 否
 */
fun Context.isPortrait(): Boolean {
    return this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
}
