package com.fairy.lib.utils.delegate

import android.content.Context
import android.content.SharedPreferences
import com.fairy.lib.utils.fromJson
import com.fairy.lib.utils.toJson
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


/**
 * SharedPreferences委托类
 * 不支持集合
 * @author: Admin.
 * @date  : 2019-08-03.
 */
class Preference<T>() : ReadWriteProperty<Any?, T?> {

    private lateinit var name: String
    private lateinit var context: Context
    private var default: T? = null
    private var clazz: Class<T>? = null

    /**
     * 只适用于原始数据类型
     */
    constructor(
        name: String,
        context: Context,
        default: T
    ) : this() {
        this.name = name
        this.context = context
        this.default = default
    }

    /**
     * 适用于自定义对象，不适用集合数组
     */
    constructor(
        name: String,
        context: Context,
        clazz: Class<T>
    ) : this() {
        this.name = name
        this.context = context
        this.clazz = clazz
    }


    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        return findPreference(name, default, clazz)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        putPreference(name, value)
    }

    private fun <T> findPreference(name: String, default: T?, clazz: Class<T>? = null): T? =
        if (default != null) {
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
        } else {
            with(prefs) {
                return parseType(getString(name, null), clazz) ?: return@with null
            }
        }


    private fun <T> parseType(value: String?, clazz: Class<T>?): T? {
        if (value.isNullOrBlank() || clazz == null) return null
        return value.fromJson(clazz)
    }


    private fun <T> putPreference(name: String, value: T) = with(prefs.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> {
                putString(name, value.toJson())
            }
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