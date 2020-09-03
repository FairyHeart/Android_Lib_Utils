[lib_utils](../../index.md) / [com.fairy.lib.utils](../index.md) / [kotlin.Double](index.md) / [format](./format.md)

# format

`fun Double?.format(style: `[`NumberStyle`](../../com.fairy.lib.utils.enum/-number-style/index.md)` = NumberStyle.DEFAULT, defaultValue: String = "--"): String`

数字处理，默认保留两位小数

### Parameters

`style` - 123456789.000001
    NumberStyle.DEFAULT 默认值 123,456,789
    NumberStyle.ONE 123,456,789.0
    NumberStyle.TWO 123,456,789.00
    NumberStyle.THREE 123,456,789.000
    NumberStyle.FOUR 123,456,789.0000
    NumberStyle.FIVES 123,456,789.00000

`defaultValue` - 默认值 如果值为空显示默认值

**Return**

