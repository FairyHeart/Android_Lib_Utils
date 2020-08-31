package com.fairy.lib.utils

import com.fairy.lib.utils.enum.DateStyle
import com.fairy.lib.utils.enum.NumberStyle
import com.fairy.lib.utils.kfunc.fillZero
import org.junit.Test
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
        val x = 123456789.0000000
        println(x.format())
        println(x.format(NumberStyle.ONE))
        println(x.format(NumberStyle.TWO))
        println(x.format(NumberStyle.THREE))
        println(x.format(NumberStyle.FOUR))
        println(x.format(NumberStyle.FIVES))

        val y = 123456789.1234567
        println(y.formatLong())
        println(y.formatLong(NumberStyle.ONE))
        println(y.formatLong(NumberStyle.TWO))
        println(y.formatLong(NumberStyle.THREE))
        println(y.formatLong(NumberStyle.FOUR))
        println(y.formatLong(NumberStyle.FIVES))

        val z = 1234.567894
        println(z.round())
        println(z.round(NumberStyle.ONE))
        println(z.round(NumberStyle.TWO))
        println(z.round(NumberStyle.THREE))
        println(z.round(NumberStyle.FOUR))
        println(z.round(NumberStyle.FIVES))
    }


    @Test
    fun testKDate() {
        val d = Date()
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

        println(d.formatToMinute())
        println(80.formatTime())
        println(80.formatDate())
        println(d.format("yyyy年MM月dd日 HH:mm:ss"))

        println("")
//        println("2020年8月31日 星期一 下午02时13分59秒 CST".parse())
        println("2020年8月31日 下午02时13分59秒".parseDate("yyyy年MM月dd日 下午HH时mm分ss秒"))
        println("2020-8-31 14:13:59".parseDate())
//        println("20-8-31 下午2:13".parseDate())

        println(d.getDayNumber())
        println(d.getWeekNumber())
    }

    @Test
    fun testIntUtils() {
        println(IntUtils.getRandom(10))

        IntUtils.getRandoms(2, 1000, true).forEach {
            println(it)
        }
    }
}