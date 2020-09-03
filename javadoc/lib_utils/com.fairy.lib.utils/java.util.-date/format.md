[lib_utils](../../index.md) / [com.fairy.lib.utils](../index.md) / [java.util.Date](index.md) / [format](./format.md)

# format

`fun Date.format(dateStyle: `[`DateStyle`](../../com.fairy.lib.utils.enum/-date-style/index.md)` = DateStyle.MEDIUM): String`

显示完整日期
    按本地语言自动获取日期格式样式

### Parameters

`dateStyle` -

```
    DateStyle.FULL 2020年8月31日 星期一 上午10时38分10秒 CST
    DateStyle.LONG 2020年8月31日 上午10时38分10秒
    DateStyle.MEDIUM 2020-8-31 10:38:10 默认值
    DateStyle.SHORT 20-8-31 上午10:38
```

**Return**

`fun Date.format(pattern: String): String`

按自定义格式显示时间

### Parameters

`pattern` - 时间格式 yyyy年MM月dd日 HH:mm:ss

**Return**
2020年08月31日 12:48:56

