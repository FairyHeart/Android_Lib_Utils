[lib_utils](../../index.md) / [com.fairy.lib.utils](../index.md) / [ShareUtils](./index.md)

# ShareUtils

`class ShareUtils`

SharedPreferences工具类

**Author**
: Fairy.

**Date**
: 2019-08-03.

### Constructors

| [&lt;init&gt;](-init-.md) | SharedPreferences工具类`ShareUtils()` |

### Functions

| [clear](clear.md) | SP中清除所有数据`fun clear(): Unit` |
| [contains](contains.md) | SP中是否存在该key`operator fun contains(key: String): Boolean` |
| [getAll](get-all.md) | SP中获取所有键值对`fun getAll(): Map<String, *>` |
| [getBoolean](get-boolean.md) | SP中读取boolean`fun getBoolean(key: String): Boolean`<br>`fun getBoolean(key: String, defaultValue: Boolean): Boolean` |
| [getFloat](get-float.md) | SP中读取float`fun getFloat(key: String): Float`<br>`fun getFloat(key: String, defaultValue: Float): Float` |
| [getInt](get-int.md) | SP中读取int`fun getInt(key: String): Int`<br>`fun getInt(key: String, defaultValue: Int): Int` |
| [getLong](get-long.md) | SP中读取long`fun getLong(key: String): Long`<br>`fun getLong(key: String, defaultValue: Long): Long` |
| [getObject](get-object.md) | SP中读取对象`fun <T> getObject(key: String, clazz: Class<T>): T?`<br>`fun <T> getObject(key: String, typeOfT: Type): T?` |
| [getString](get-string.md) | SP中读取String`fun getString(key: String): String?`<br>`fun getString(key: String, defaultValue: String?): String?` |
| [getStringSet](get-string-set.md) | SP中读取Set`fun getStringSet(key: String, defaultValue: Set<String>): Set<String>?` |
| [init](init.md) | SPUtils构造函数 在Application中初始化`fun init(context: Context, shareName: String): Unit` |
| [put](put.md) | SP中写入String类型value`fun put(key: String, value: String): `[`ShareUtils`](./index.md)<br>SP中写入int类型value`fun put(key: String, value: Int): `[`ShareUtils`](./index.md)<br>SP中写入long类型value`fun put(key: String, value: Long): `[`ShareUtils`](./index.md)<br>SP中写入float类型value`fun put(key: String, value: Float): `[`ShareUtils`](./index.md)<br>SP中写入boolean类型value`fun put(key: String, value: Boolean): `[`ShareUtils`](./index.md) |
| [putObject](put-object.md) | SP中写入对象值obj`fun putObject(key: String, obj: Any): `[`ShareUtils`](./index.md) |
| [putStringSet](put-string-set.md) | SP中写入Set`fun putStringSet(key: String, value: Set<String>): `[`ShareUtils`](./index.md) |
| [remove](remove.md) | SP中移除该key`fun remove(vararg keys: String): Unit` |

### Companion Object Properties

| [instance](instance.md) | `val instance: `[`ShareUtils`](./index.md) |

