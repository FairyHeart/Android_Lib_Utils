# Android_Lib_Utils
工具类封装

- SharedPreferences数据保存 <br>
1、Preference委托代理，只适用于对象和原始数据类型，默认保存名字"SharedPreferences"<br>
2、PreferenceBean委托代理，只适用于对象类型，不支持原始数据类型，默认保存名字"SharedPreferencesBean"，需要引入gson架包<br>
3、ShareUtils工具类，支持所有数据类型，保持名字自定义，需要初始化ShareUtils.init(context,shareName)<br>


- KJson拓展函数使用，需要引入gson架包


>implementation "com.google.code.gson:gson:2.8.5
