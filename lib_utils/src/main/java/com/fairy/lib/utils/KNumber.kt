package com.fairy.lib.utils

import com.fairy.lib.utils.enum.NumberEnum
import java.text.DecimalFormat

/**
 *
 *
 * @author: Fairy.
 * @date  : 2020/8/28.
 */

private val NF = DecimalFormat("#.##")
private val NF1 = DecimalFormat("#.0#")
private val NF2 = DecimalFormat("#0.00")
private const val FLOOR = 0.5

fun Double?.format(enum: NumberEnum, defaultValue: String = "--"): String {
    if (this == null) {
        return defaultValue
    }
    return when (enum) {
        NumberEnum.zero -> NF.format(this)
        NumberEnum.one -> NF1.format(this)
        NumberEnum.two -> NF2.format(this)
        else -> NF.format(this)
    }
}

fun Double?.round(): Double {
    if (this == null) {
        return 0.0
    }
    return Math.floor(this * 100 + FLOOR) / 100
}
