[lib_utils](../../index.md) / [com.fairy.lib.utils](../index.md) / [android.app.Activity](index.md) / [setLandscape](./set-landscape.md)

# setLandscape

`fun Activity.setLandscape(): Unit`

设置屏幕为横屏

还有一种就是在Activity中加属性android:screenOrientation="landscape"

不设置Activity的android:configChanges时，切屏会重新调用各个生命周期，切横屏时会执行一次，切竖屏时会执行两次

设置Activity的android:configChanges="orientation"时，切屏还是会重新调用各个生命周期，切横、竖屏时只会执行一次

设置Activity的android:configChanges="orientation|keyboardHidden|screenSize"（4.0以上必须带最后一个参数）时
切屏不会重新调用各个生命周期，只会执行onConfigurationChanged方法

