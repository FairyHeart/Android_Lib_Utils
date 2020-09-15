package com.fairy.lib.utils

import com.fairy.lib.utils.enum.NumberStyle
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import kotlin.math.floor

/**
 * 数字处理拓展函数
 *
 * @author: Fairy.
 * @date  : 2020/8/28.
 */

private val NF = DecimalFormat("#,###,###.##")
private val NF1 = DecimalFormat("#,###,###.0#")
private val NF2 = DecimalFormat("#,###,###.00")
private val NF3 = DecimalFormat("#,###,###.000")
private val NF4 = DecimalFormat("#,###,###.0000")
private val NF5 = DecimalFormat("#,###,###.00000")

private val NF_LONG = DecimalFormat("#,###,###.###")
private val NF1_LONG = DecimalFormat("#,###,###.0##")
private val NF2_LONG = DecimalFormat("#,###,###.00#")

private const val FLOOR = 0.5

/**
 * 数字处理，默认保留两位小数
 * @param style 123456789.000001
 *           NumberStyle.DEFAULT 默认值 123,456,789
 *           NumberStyle.ONE 123,456,789.0
 *           NumberStyle.TWO 123,456,789.00
 *           NumberStyle.THREE 123,456,789.000
 *           NumberStyle.FOUR 123,456,789.0000
 *           NumberStyle.FIVES 123,456,789.00000
 * @param defaultValue 默认值 如果值为空显示默认值
 *
 * @return
 */
fun Double?.format(style: NumberStyle = NumberStyle.DEFAULT, defaultValue: String = "--"): String {
    if (this == null) {
        return defaultValue
    }
    return when (style) {
        NumberStyle.DEFAULT -> NF.format(this)
        NumberStyle.ONE -> NF1.format(this)
        NumberStyle.TWO -> NF2.format(this)
        NumberStyle.THREE -> NF3.format(this)
        NumberStyle.FOUR -> NF4.format(this)
        NumberStyle.FIVES -> NF5.format(this)
    }
}

/**
 * 数字处理，默认保留三位小数
 * @param style 123456789.123456
 *           NumberStyle.DEFAULT 默认值 123,456,789.123
 *           NumberStyle.ONE 123,456,789.123
 *           NumberStyle.TWO 123,456,789.123
 *           NumberStyle.THREE 123,456,789.123
 *           NumberStyle.FOUR 123,456,789.1235
 *           NumberStyle.FIVES 123,456,789.12346
 * @param defaultValue 默认值 如果值为空显示默认值
 *
 * @return
 */
fun Double?.formatLong(
    style: NumberStyle = NumberStyle.DEFAULT,
    defaultValue: String = "--"
): String {
    if (this == null) {
        return defaultValue
    }
    return when (style) {
        NumberStyle.DEFAULT -> NF_LONG.format(this)
        NumberStyle.ONE -> NF1_LONG.format(this)
        NumberStyle.TWO -> NF2_LONG.format(this)
        NumberStyle.THREE -> NF3.format(this)
        NumberStyle.FOUR -> NF4.format(this)
        NumberStyle.FIVES -> NF5.format(this)
    }
}

/**
 * 处理数字的四舍五入
 * @param style 1234.567894
 *           NumberStyle.DEFAULT 默认值 1235.0
 *           NumberStyle.ONE 1234.6
 *           NumberStyle.TWO 1234.57
 *           NumberStyle.THREE 1234.568
 *           NumberStyle.FOUR 1234.5679
 *           NumberStyle.FIVES 1234.56789
 * @param defaultValue 默认值 如果值为空显示默认值
 *
 * @return
 */
fun Double?.round(style: NumberStyle = NumberStyle.DEFAULT, defaultValue: Double = 0.0): Double {
    if (this == null) {
        return defaultValue
    }
    return when (style) {
        NumberStyle.DEFAULT -> floor(this + FLOOR)
        NumberStyle.ONE -> floor(this * 10 + FLOOR) / 10
        NumberStyle.TWO -> floor(this * 100 + FLOOR) / 100
        NumberStyle.THREE -> floor(this * 1000 + FLOOR) / 1000
        NumberStyle.FOUR -> floor(this * 10000 + FLOOR) / 10000
        NumberStyle.FIVES -> floor(this * 100000 + FLOOR) / 100000
    }
}

/**
 * 如果是null则转成0
 *
 */
fun Double?.nullToZero(): Double {
    if (this == null) {
        return 0.0
    }
    return this
}

/**
 * 对数字的求和
 */
fun Double?.add(add: Double?): Double {
    val x = this.nullToZero().toBigDecimal()
    val y = add.nullToZero().toBigDecimal()
    return x.add(y).toDouble()
}

/**
 * 减法运算
 */
fun Double?.sub(add: Double?): Double {
    val x = this.nullToZero().toBigDecimal()
    val y = add.nullToZero().toBigDecimal()
    return x.subtract(y).toDouble()
}

/**
 * 将字符串解析为Double
 * @param regex 默认逗号分隔符
 * @return
 */
fun String?.parseNumber(regex: String = ","): Double {
    if (this == null) {
        return 0.0
    }
    val value = this.replace(",", "")
    if (value.isBlank()) {
        return 0.0
    }
    return value.toDouble()
}

/**
 * 分转元
 */
fun Long?.fenToYuan(): Double {
    if (this == null) {
        return 0.0
    }
    val a = BigDecimal(this)
    val b = BigDecimal(100)
    return a.divide(b).toDouble()
}

/**
 * 元转分
 * @return Long
 */
fun Double?.yuanToFenLong(): Long {
    if (this == null) {
        return 0L
    }
    val format = NumberFormat.getInstance()
    // 默认情况下GroupingUsed属性为true,每三位数为一个分组，用英文半角逗号隔开，例如9,333,333
    format.isGroupingUsed = false
    // 设置返回数的小数部分所允许的最大位数
    format.maximumFractionDigits = 0
    return format.format(this.round(NumberStyle.TWO) * 100.0).toLong()
}

/**
 * 元转分
 * @return Int
 */
fun Double?.yuanToFen(): Int {
    if (this == null) {
        return 0
    }
    val format = NumberFormat.getInstance()
    // 默认情况下GroupingUsed属性为true,每三位数为一个分组，用英文半角逗号隔开，例如9,333,333
    format.isGroupingUsed = false
    // 设置返回数的小数部分所允许的最大位数
    format.maximumFractionDigits = 0
    return format.format(this.round(NumberStyle.TWO) * 100.0).toInt()
}

