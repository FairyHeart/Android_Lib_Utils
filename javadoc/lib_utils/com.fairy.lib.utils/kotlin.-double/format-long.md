[lib_utils](../../index.md) / [com.fairy.lib.utils](../index.md) / [kotlin.Double](index.md) / [formatLong](./format-long.md)

# formatLong

`fun Double?.formatLong(style: `[`NumberStyle`](../../com.fairy.lib.utils.enum/-number-style/index.md)` = NumberStyle.DEFAULT, defaultValue: String = "--"): String`

数字处理，默认保留三位小数

### Parameters

`style` - 123456789.123456
    NumberStyle.DEFAULT 默认值 123,456,789.123
    NumberStyle.ONE 123,456,789.123
    NumberStyle.TWO 123,456,789.123
    NumberStyle.THREE 123,456,789.123
    NumberStyle.FOUR 123,456,789.1235
    NumberStyle.FIVES 123,456,789.12346

`defaultValue` - 默认值 如果值为空显示默认值

**Return**

