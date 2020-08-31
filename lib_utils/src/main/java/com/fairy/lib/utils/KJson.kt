package com.fairy.lib.utils

import com.google.gson.Gson
import java.lang.reflect.Type

/**
 * Json解析
 *
 * @author: Fairy.
 * @date  : 2020/8/31.
 */
private val gson = Gson()

/**
 * object类型转Json
 */
fun Any?.toJson(): String {
    return gson.toJson(this)
}

/**
 * json解析获取对象
 */
fun <T> String?.fromJson(clazz: Class<T>): T? {
    if (this.isNullOrBlank()) return null
    return gson.fromJson(this, clazz)
}

/**
 * json解析获取对象
 * @param type val fooType = object : TypeToken<T>() {}.type
 */
fun <T> String?.fromJson(type: Type): T? {
    if (this.isNullOrBlank()) return null
    return gson.fromJson(this, type)
}