[lib_utils](../../index.md) / [com.fairy.lib.utils](../index.md) / [kotlin.Double](index.md) / [round](./round.md)

# round

`fun Double?.round(style: `[`NumberStyle`](../../com.fairy.lib.utils.enum/-number-style/index.md)` = NumberStyle.DEFAULT, defaultValue: Double = 0.0): Double`

处理数字的四舍五入

### Parameters

`style` - 1234.567894
    NumberStyle.DEFAULT 默认值 1235.0
    NumberStyle.ONE 1234.6
    NumberStyle.TWO 1234.57
    NumberStyle.THREE 1234.568
    NumberStyle.FOUR 1234.5679
    NumberStyle.FIVES 1234.56789

`defaultValue` - 默认值 如果值为空显示默认值

**Return**

