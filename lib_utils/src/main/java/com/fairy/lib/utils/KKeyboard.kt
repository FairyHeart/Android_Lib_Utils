package com.fairy.lib.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * 键盘相关工具
 *
 * @author: Fairy.
 * @date  : 2020/8/31.
 *
 * 避免输入法面板遮挡
 * <p>在manifest.xml中activity中设置</p>
 * <p>android:windowSoftInputMode="adjustPan"</p>
 */

/**
 * 动态隐藏软键盘
 */
fun Activity.hideSoftInput() {
    var view = this.currentFocus
    if (view == null) view = View(this)
    val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE)
    if (imm is InputMethodManager) {
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

/**
 * 动态隐藏软键盘
 *
 * @param context 上下文
 */
fun View.hideSoftInput(context: Context) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE)
    if (imm is InputMethodManager) imm.hideSoftInputFromWindow(this.windowToken, 0)
}

/**
 * 动态显示软键盘
 *
 * @param view 视图
 * @param context 上下文对象
 */
fun View.showSoftInput(context: Context) {
    this.isFocusable = true
    this.isFocusableInTouchMode = true
    this.requestFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE)
    if (imm is InputMethodManager) imm.showSoftInput(this, 0)
}

/**
 * 切换键盘显示与否状态
 */
fun Context.toggleSoftInput() {
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE)
    if (imm is InputMethodManager) imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}