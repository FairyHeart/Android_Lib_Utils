package com.fairy.lib.utils

/**
 * Int拓展函数
 *
 * @author: Fairy.
 * @date  : 2020/8/28.
 */

/**
 * 将给定的数字转换为给定长度的字符串，位数不够用0补
 *
 * @param stringLength 给定长度。如果给定的长度小于等于给定的数字转换为字符串后的长度的话不做任何处理
 * @return 例给定数字是2，给定长度是5，结果是00002
 */
fun Int.fillZero(stringLength: Int) = String.format("%0" + stringLength + "d", this)
