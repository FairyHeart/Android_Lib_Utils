[lib_utils](../../index.md) / [com.fairy.lib.utils.delegate](../index.md) / [Preference](./index.md)

# Preference

`class Preference<T> : ReadWriteProperty<Any?, T>`

SharedPreferences委托类

不支持集合和自定义对象

**Author**
: Admin.

**Date**
: 2019-08-03.

### Constructors

| [&lt;init&gt;](-init-.md) | SharedPreferences委托类`Preference(name: String, context: Context, default: T)` |

### Properties

| [context](context.md) | `val context: Context` |
| [name](name.md) | `val name: String` |

### Functions

| [clearPreference](clear-preference.md) | 删除全部数据`fun clearPreference(): Unit`<br>根据key删除存储数据`fun clearPreference(vararg key: String): Unit` |
| [getValue](get-value.md) | `fun getValue(thisRef: Any?, property: KProperty<*>): T` |
| [setValue](set-value.md) | `fun setValue(thisRef: Any?, property: KProperty<*>, value: T): Unit` |

