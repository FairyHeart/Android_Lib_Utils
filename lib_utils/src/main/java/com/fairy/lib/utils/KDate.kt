package com.fairy.lib.utils

import com.fairy.lib.utils.enum.DateStyle
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 *
 *
 * @author: Fairy.
 * @date  : 2020/8/28.
 */

fun Date.formatAsYearToSecond(): String {
    SimpleDateFormat.getDateInstance()
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    return format.format(this)
}

fun Date.formatAsYearToMinute(): String {
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
    return format.format(this)
}

fun Date.formatAsYearToDay(): String {
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
    return format.format(this)
}

fun Date.formatToMinute(): String {
    val format = SimpleDateFormat("HH:mm", Locale.getDefault())
    return format.format(this)
}

fun Date.format(dateStyle: DateStyle = DateStyle.MEDIUM): String {
    val format =
        DateFormat.getDateTimeInstance(dateStyle.ordinal, dateStyle.ordinal, Locale.getDefault())
    return format.format(this)
}

fun Date.formatDate(dateStyle: DateStyle = DateStyle.MEDIUM): String {
    val format = SimpleDateFormat.getDateInstance(dateStyle.ordinal, Locale.getDefault())
    return format.format(this)
}

fun Date.formatTime(dateStyle: DateStyle = DateStyle.MEDIUM): String {
    val format = SimpleDateFormat.getTimeInstance(dateStyle.ordinal, Locale.getDefault())
    return format.format(this)
}

