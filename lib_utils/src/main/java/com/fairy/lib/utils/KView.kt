package com.fairy.lib.utils

import android.graphics.Paint
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView

/**
 *
 *
 * @author: Fairy.
 * @date  : 2020/8/31.
 */

/**
 * 根据ListView的所有子项的高度设置其高度
 *
 */
fun ListView.setListViewHeightByAllChildrenViewHeight() {
    val listAdapter = this.adapter
    if (listAdapter != null) {
        var totalHeight = 0
        for (i in 0 until listAdapter.count) {
            val listItem = listAdapter.getView(i, null, this)
            listItem.measure(0, 0)
            totalHeight += listItem.measuredHeight
        }
        val params = this.layoutParams
        params.height = totalHeight + this.dividerHeight * (listAdapter.count - 1)
        (params as ViewGroup.MarginLayoutParams).setMargins(10, 10, 10, 10)
        this.layoutParams = params
    }
}

/**
 * 下划线
 */
fun TextView.setFlagsBottom() {
    this.paint.flags = Paint.UNDERLINE_TEXT_FLAG //下划线
    this.paint.isAntiAlias = true //抗锯齿
}

/**
 * 中划线
 */
fun TextView.setFlagsCenter() {
    this.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG//中划线
    this.paint.isAntiAlias = true //抗锯齿
}

/**
 * 取消设置的的划线
 */
fun TextView.cancelFlags() {
    this.paint.flags = 0 // 取消设置的的划线
}