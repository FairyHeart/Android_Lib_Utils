package com.fairy.lib.utils.delegate

import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


/**
 * SharedPreferences委托类
 *
 * 不支持集合和自定义对象
 * @author: Admin.
 * @date  : 2019-08-03.
 */
class Preference<T>(val name: String, val context: Context, private val default: T) :
    ReadWriteProperty<Any?, T> {

    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(name, default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name, value)
    }

    private fun <T> findPreference(name: String, default: T?): T =
        with(prefs) {
            val res: Any = when (default) {
                is Long -> getLong(name, default)
                is String -> getString(name, default)
                is Int -> getInt(name, default)
                is Boolean -> getBoolean(name, default)
                is Float -> getFloat(name, default)
                else -> throw IllegalArgumentException("this type can not be read")
            } ?: return default
            return res as T
        }

    private fun <T> putPreference(name: String, value: T) = with(prefs.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> throw IllegalArgumentException("this type can not be put")
        }.apply()
    }


    /**
     * 删除全部数据
     */
    fun clearPreference() {
        prefs.edit().clear().apply()
    }

    /**
     * 根据key删除存储数据
     */
    fun clearPreference(vararg key: String) {
        key.forEach {
            prefs.edit().remove(it).apply()
        }
    }

}