[lib_utils](../../index.md) / [com.fairy.lib.utils](../index.md) / [java.util.Date](./index.md)

### Extensions for java.util.Date

| [format](format.md) | 显示完整日期     按本地语言自动获取日期格式样式`fun Date.format(dateStyle: `[`DateStyle`](../../com.fairy.lib.utils.enum/-date-style/index.md)` = DateStyle.MEDIUM): String`<br>按自定义格式显示时间`fun Date.format(pattern: String): String` |
| [formatDate](format-date.md) | 显示日期     按本地语言自动获取日期格式样式`fun Date.formatDate(dateStyle: `[`DateStyle`](../../com.fairy.lib.utils.enum/-date-style/index.md)` = DateStyle.MEDIUM): String` |
| [formatTime](format-time.md) | 显示时间     按本地语言自动获取日期格式样式`fun Date.formatTime(dateStyle: `[`DateStyle`](../../com.fairy.lib.utils.enum/-date-style/index.md)` = DateStyle.MEDIUM): String` |
| [formatToMinute](format-to-minute.md) | 显示小时和分钟     格式为：HH:mm`fun Date.formatToMinute(): String` |
| [getDateByDayOffset](get-date-by-day-offset.md) | 得到指定时间偏移指定天数的日期`fun Date?.getDateByDayOffset(offset: Int): Date` |
| [getDateByHourOffset](get-date-by-hour-offset.md) | 获取某时间段前后小时的时间`fun Date?.getDateByHourOffset(offset: Int): Date?` |
| [getDateByMinuteOffset](get-date-by-minute-offset.md) | 获取某时间段前后分钟数的时间`fun Date?.getDateByMinuteOffset(offset: Int): Date?` |
| [getDayNumber](get-day-number.md) | 获取指定日期为该月第几天`fun Date.getDayNumber(): Int` |
| [getWeekNumber](get-week-number.md) | 根据日期获得星期`fun Date.getWeekNumber(): String` |

