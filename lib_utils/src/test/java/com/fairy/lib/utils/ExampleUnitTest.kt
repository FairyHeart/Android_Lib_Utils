package com.fairy.lib.utils

import com.fairy.lib.utils.enum.DateStyle
import com.fairy.lib.utils.enum.NumberEnum
import org.junit.Test

import org.junit.Assert.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)

        println(3L.fillZero(4))
    }

    @Test
    fun testKNumber() {
        println(12345.0000.format(NumberEnum.one))

        val f = SimpleDateFormat.getDateTimeInstance()
        val d = Date()
        println(f.format(d))
        println("")
        println(d.format(DateStyle.FULL))
        println(d.format(DateStyle.LONG))
        println(d.format(DateStyle.MEDIUM))
        println(d.format(DateStyle.SHORT))

        println("")
        println(d.formatDate(DateStyle.FULL))
        println(d.formatDate(DateStyle.LONG))
        println(d.formatDate(DateStyle.MEDIUM))
        println(d.formatDate(DateStyle.SHORT))

        println("")
        println(d.formatTime(DateStyle.FULL))
        println(d.formatTime(DateStyle.LONG))
        println(d.formatTime(DateStyle.MEDIUM))
        println(d.formatTime(DateStyle.SHORT))
    }
}