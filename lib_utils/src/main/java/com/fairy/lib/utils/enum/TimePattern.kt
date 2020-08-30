package com.fairy.lib.utils.enum

/**
 *
 *
 * @author: Fairy.
 * @date  : 2020/8/29.
 */

enum class TimePattern(var pattern: String) {
    Pattern("yyyy-MM-dd HH:mm:ss"),
    D("dd/MM/yyyy HH:mm:ss"),
    Dd("yyyy年MM月dd日 HH:mm:ss"),
    Ddd("yyyy年MM月dd日 HH时mm分ss秒")
}

enum class DateStyle(var dateStyle: Int) {
    FULL(0),
    LONG(1),
    MEDIUM(2),
    SHORT(3)
}