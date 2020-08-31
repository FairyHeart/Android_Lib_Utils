package com.fairy.lib.utils

import android.content.Context

/**
 * dp px sp转换
 *
 * @author: Fairy.
 * @date  : 2020/8/31.
 */

/**
 * dp转px
 *
 * @param context
 * @return px值
 */
fun Int.dp2px(context: Context): Float {
    val scale = context.resources.displayMetrics.density
    return (this * scale + 0.5f)
}

/**
 * px转dp
 *
 * @return dp值
 */
fun Float.px2dp(context: Context): Int {
    val scale = context.resources.displayMetrics.density
    return (this / scale + 0.5f).toInt()
}

/**
 * sp转px
 *
 * @return px值
 */
fun Float.sp2px(context: Context): Int {
    val fontScale = context.resources.displayMetrics.scaledDensity
    return (this * fontScale + 0.5f).toInt()
}

/**
 * px转sp
 *
 * @return sp值
 */
fun Float.px2sp(context: Context): Int {
    val fontScale = context.resources.displayMetrics.scaledDensity
    return (this / fontScale + 0.5f).toInt()
}