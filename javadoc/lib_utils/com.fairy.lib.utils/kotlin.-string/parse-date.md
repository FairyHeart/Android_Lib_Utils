[lib_utils](../../index.md) / [com.fairy.lib.utils](../index.md) / [kotlin.String](index.md) / [parseDate](./parse-date.md)

# parseDate

`fun String.parseDate(): Date?`

把日期格式字符串解析成日期.

支持的日期包括：
"yyyy-MM-dd HH:mm:ss",
"yyyy-MM-dd HH:mm",
"yyyy-MM-dd"，
"dd/MM/yyyy HH:mm:ss",
"dd/MM/yyyy HH:mm",
"dd/MM/yyyy"

**Return**
Date 日期.

`fun String.parseDate(pattern: String): Date?`

把日期格式字符串解析成日期

### Parameters

`pattern` - 时间转换格式

**Return**
date

