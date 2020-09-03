[lib_utils](../../index.md) / [com.fairy.lib.utils.manager](../index.md) / [ActivityManager](./index.md)

# ActivityManager

`class ActivityManager`

应用程序Activity管理类：用于Activity管理和应用程序退出

**Author**
: Fairy.

**Date**
: 2019-08-15.

### Constructors

| [&lt;init&gt;](-init-.md) | 应用程序Activity管理类：用于Activity管理和应用程序退出`ActivityManager()` |

### Functions

| [addActivity](add-activity.md) | 添加Activity到堆栈`fun addActivity(activity: Activity): Unit` |
| [appExit](app-exit.md) | 退出应用程序`fun appExit(context: Context): Unit` |
| [currentActivity](current-activity.md) | 获取当前Activity（堆栈中最后一个压入的）`fun currentActivity(): Activity?` |
| [finishActivity](finish-activity.md) | 结束当前Activity（堆栈中最后一个压入的）`fun finishActivity(): Unit`<br>结束指定的Activity`fun finishActivity(activity: Activity?): Unit`<br>结束指定类名的Activity`fun finishActivity(cls: Class<*>): Unit` |
| [finishAllActivity](finish-all-activity.md) | 结束所有Activity`fun finishAllActivity(): Unit`<br>`fun finishAllActivity(vararg cls: Class<*>): Unit` |
| [getActivity](get-activity.md) | 根据ActivityName获取堆中Activity实例`fun getActivity(activityName: String): Activity?` |

### Companion Object Properties

| [INSTANCE](-i-n-s-t-a-n-c-e.md) | `val INSTANCE: `[`ActivityManager`](./index.md) |

