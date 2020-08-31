package com.fairy.lib.utils.delegate

import android.content.Context
import android.content.SharedPreferences
import com.fairy.lib.utils.fromJson
import com.fairy.lib.utils.toJson
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


/**
 * SharedPreferences委托类
 * 不支持自定义数据类型
 * @author: Admin.
 * @date  : 2019-08-03.
 */
class PreferenceBean<T>(val name: String, val context: Context, private val clazz: Class<T>) :
    ReadWriteProperty<Any?, T?> {

    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences("SharedPreferencesBean", Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        return findPreference(name, clazz)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        putPreference(name, value)
    }

    private fun <T> findPreference(name: String, clazz: Class<T>? = null): T? =
        with(prefs) {
            return parseType(getString(name, null), clazz) ?: return@with null
        }

    private fun <T> parseType(value: String?, clazz: Class<T>?): T? {
        if (value.isNullOrBlank() || clazz == null) return null
        return value.fromJson(clazz)
    }


    private fun <T> putPreference(name: String, value: T) = with(prefs.edit()) {
        putString(name, value.toJson())
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