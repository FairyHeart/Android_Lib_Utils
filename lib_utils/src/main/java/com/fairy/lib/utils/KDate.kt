package com.fairy.lib.utils

import com.fairy.lib.utils.enum.DateStyle
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * 日期拓展函数
 *
 * @author: Fairy.
 * @date  : 2020/8/28.
 */
private const val PATTERN1_FULL =
    "^\\s*\\d{4}(\\-)\\d{1,2}\\1\\d{1,2}\\s+\\d{1,2}:\\d{1,2}:\\d{1,2}\\s*$"  //yyyy-MM-dd HH:mm:ss;
private const val PATTERN1_LONG =
    "^\\s*\\d{4}(\\-)\\d{1,2}\\1\\d{1,2}\\s+\\d{1,2}:\\d{1,2}\\s*$"  //yyyy-MM-dd HH:mm;
private const val PATTERN1_SHORT = "^\\s*\\d{4}(\\-)\\d{1,2}\\1\\d{1,2}\\s*$"  //yyyy-MM-dd;
private const val PATTERN2_FULL =
    "^\\s*\\d{1,2}(\\/)\\d{1,2}\\1\\d{4}\\s+\\d{1,2}:\\d{1,2}:\\d{1,2}\\s*$"  //dd/MM/yyyy  HH:mm:ss;
private const val PATTERN2_LONG =
    "^\\s*\\d{1,2}(\\/)\\d{1,2}\\1\\d{4}\\s+\\d{1,2}:\\d{1,2}\\s*$"  //dd/MM/yyyy  HH:mm;
private const val PATTERN2_SHORT = "^\\s*\\d{1,2}(\\/)\\d{1,2}\\1\\d{4}\\s*$"  //dd/MM/yyyy;

/**
 * 显示完整日期
 *         按本地语言自动获取日期格式样式
 * @param dateStyle
 *          DateStyle.FULL 2020年8月31日 星期一 上午10时38分10秒 CST
 *          DateStyle.LONG 2020年8月31日 上午10时38分10秒
 *          DateStyle.MEDIUM 2020-8-31 10:38:10 默认值
 *          DateStyle.SHORT 20-8-31 上午10:38
 * @return
 */
fun Date.format(dateStyle: DateStyle = DateStyle.MEDIUM): String {
    val format =
        DateFormat.getDateTimeInstance(dateStyle.ordinal, dateStyle.ordinal, Locale.getDefault())
    return format.format(this)
}

/**
 * 显示日期
 *         按本地语言自动获取日期格式样式
 * @param dateStyle
 *          DateStyle.FULL 2020年8月31日 星期一
 *          DateStyle.LONG 2020年8月31日
 *          DateStyle.MEDIUM 2020-8-31 默认值
 *          DateStyle.SHORT 20-8-31
 * @return
 */
fun Date.formatDate(dateStyle: DateStyle = DateStyle.MEDIUM): String {
    val format = SimpleDateFormat.getDateInstance(dateStyle.ordinal, Locale.getDefault())
    return format.format(this)
}

/**
 * 显示时间
 *         按本地语言自动获取日期格式样式
 * @param dateStyle
 *          DateStyle.FULL 上午10时38分10秒 CST
 *          DateStyle.LONG 上午10时38分10秒
 *          DateStyle.MEDIUM 10:38:10 默认值
 *          DateStyle.SHORT 上午10:38
 * @return
 */
fun Date.formatTime(dateStyle: DateStyle = DateStyle.MEDIUM): String {
    val format = SimpleDateFormat.getTimeInstance(dateStyle.ordinal, Locale.getDefault())
    return format.format(this)
}

/**
 * 显示小时和分钟
 *      格式为：HH:mm
 * @return 12:48
 */
fun Date.formatToMinute(): String {
    val format = SimpleDateFormat("HH:mm", Locale.getDefault())
    return format.format(this)
}

/**
 * 显示小时和分钟
 *      格式为：HH:mm
 * @return 12:48
 */
fun Int.formatTime(): String {
    return "${String.format(
        Locale.getDefault(),
        "%02d",
        this / 60
    )}:${String.format(Locale.getDefault(), "%02d", this % 60)}"

}

/**
 * 将秒钟数的时间转成日期类型格式字符串
 *      格式为：HH:mm:ss
 * @return 10:00:00
 */
fun Int.formatDate(): String {
    return "${String.format(
        Locale.getDefault(),
        "%02d",
        this / 3600
    )}:${String.format(
        Locale.getDefault(),
        "%02d",
        this % 3600 / 60
    )}:${String.format(Locale.getDefault(), "%02d", this % 3600 % 60)}"
}

/**
 * 按自定义格式显示时间
 * @param pattern 时间格式 yyyy年MM月dd日 HH:mm:ss
 * @return 2020年08月31日 12:48:56
 */
fun Date.format(pattern: String): String {
    val format = SimpleDateFormat(pattern, Locale.getDefault())
    return format.format(this)
}

/**
 * 把日期格式字符串解析成日期.
 *
 * 支持的日期包括：
 * "yyyy-MM-dd HH:mm:ss",
 * "yyyy-MM-dd HH:mm",
 * "yyyy-MM-dd"，
 * "dd/MM/yyyy HH:mm:ss",
 * "dd/MM/yyyy HH:mm",
 * "dd/MM/yyyy"
 * @return Date 日期.
 */
@Throws
fun String.parseDate(): Date? {
    when {
        this.contains("-") -> {
            val pattern = when {
                this.matches(PATTERN1_FULL.toRegex()) -> {
                    "yyyy-MM-dd HH:mm:ss"
                }
                this.matches(PATTERN1_LONG.toRegex()) -> {
                    "yyyy-MM-dd HH:mm"
                }
                this.matches(PATTERN1_SHORT.toRegex()) -> {
                    "yyyy-MM-dd"
                }
                else -> {
                    throw Throwable("not support parse")
                }
            }
            val format = SimpleDateFormat(pattern, Locale.getDefault())
            return format.parse(this)
        }
        this.contains("/") -> {
            val pattern = when {
                this.matches(PATTERN2_FULL.toRegex()) -> {
                    "dd/MM/yyyy HH:mm:ss"
                }
                this.matches(PATTERN2_LONG.toRegex()) -> {
                    "dd/MM/yyyy HH:mm"
                }
                this.matches(PATTERN2_SHORT.toRegex()) -> {
                    "dd/MM/yyyy"
                }
                else -> {
                    throw Throwable("not support parse")
                }
            }
            val format = SimpleDateFormat(pattern, Locale.getDefault())
            return format.parse(this)
        }
        else -> {
            throw Throwable("not support parse")
        }
    }
}

/**
 * 把日期格式字符串解析成日期
 *
 * @param pattern 时间转换格式
 * @return date
 */
fun String.parseDate(pattern: String): Date? {
    val format = SimpleDateFormat(pattern, Locale.getDefault())
    return format.parse(this)
}

/**
 * 将微秒数的时间转成日期类型
 *
 * @return date
 */
fun Long?.getDateByMillis(): Date? {
    if (this == null) {
        return null
    }
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this
    return calendar.time
}

/**
 * 获取某时间段前后小时的时间
 * @param offset 改变的小时个数
 * @return Date 改变后的时间
 */
fun Date?.getDateByHourOffset(offset: Int): Date? {
    if (this == null)
        return null
    val calendar = Calendar.getInstance()
    calendar.time = this
    calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + offset)
    return calendar.time
}

/**
 * 获取某时间段前后分钟数的时间
 * @param offset 改变的分钟数
 * @return Date 改变后的时间
 */
fun Date?.getDateByMinuteOffset(offset: Int): Date? {
    if (this == null)
        return null
    val calendar = Calendar.getInstance()
    calendar.time = this
    calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + offset)
    return calendar.time
}

/**
 * 得到指定时间偏移指定天数的日期
 * @param offset 偏移的天数  正数为未来某天，负数则为过去某天
 * @return Date 改变后的时间
 */
fun Date?.getDateByDayOffset(offset: Int): Date {
    val calendar = Calendar.getInstance()
    calendar.time = this
    calendar.add(Calendar.DATE, offset)
    return calendar.time
}

/**
 * 获取指定日期为该月第几天
 * @return String 当月的第几天，如 1,2,3，。。。
 */
fun Date.getDayNumber(): Int {
    val calendar = Calendar.getInstance()
    calendar.time = this
    return calendar.get(Calendar.DAY_OF_MONTH)
}

/**
 * 根据日期获得星期
 * @return String 根据星期返回 0(星期日),1(星期一),2(星期二),3(星期三),4(星期四),5(星期五),6(星期六)
 */
fun Date.getWeekNumber(): String {
    val weekDaysCode = arrayOf("0", "1", "2", "3", "4", "5", "6")
    val calendar = Calendar.getInstance()
    calendar.time = this
    val intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1
    return weekDaysCode[intWeek]
}