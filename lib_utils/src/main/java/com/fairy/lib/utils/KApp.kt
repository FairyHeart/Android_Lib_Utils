package com.fairy.lib.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.content.pm.Signature
import android.graphics.drawable.Drawable
import android.os.Build

/**
 * App相关工具类
 *
 * @author: Fairy.
 * @date  : 2020/8/31.
 */

/**
 * 获取App名称
 *
 * @param packageName 包名
 * @return App名称
 */
@JvmOverloads
fun Context.getAppName(packageName: String = this.packageName): String? {
    return try {
        val pm = this.packageManager
        val pi = pm.getPackageInfo(packageName, 0)
        pi?.applicationInfo?.loadLabel(pm)?.toString()
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        null
    }

}

/**
 * 获取App图标
 *
 * @param packageName 包名
 * @return App图标
 */
@JvmOverloads
fun Context.getAppIcon(packageName: String = this.packageName): Drawable? {
    return try {
        val pm = this.packageManager
        val pi = pm.getPackageInfo(packageName, 0)
        pi?.applicationInfo?.loadIcon(pm)
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        null
    }

}

/**
 * 获取App路径
 *
 * @param packageName 包名
 * @return App路径
 */
@JvmOverloads
fun Context.getAppPath(packageName: String = this.packageName): String? {
    return try {
        val pm = this.packageManager
        val pi = pm.getPackageInfo(packageName, 0)
        pi?.applicationInfo?.sourceDir
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        null
    }

}

/**
 * 获取App版本号
 *
 * @param packageName 包名
 * @return App版本号
 */
@JvmOverloads
fun Context.getAppVersionName(packageName: String = this.packageName): String? {
    return try {
        val pm = this.packageManager
        val pi = pm.getPackageInfo(packageName, 0)
        pi?.versionName
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        null
    }

}

/**
 * 获取App版本码
 *
 * @param packageName 包名
 * @return App版本码
 */
@JvmOverloads
fun Context.getAppVersionCode(packageName: String = this.packageName): Int {
    return try {
        val pm = this.packageManager
        val pi = pm.getPackageInfo(packageName, 0)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            pi?.longVersionCode?.toInt() ?: 1
        } else {
            pi?.versionCode ?: 1
        }
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        -1
    }

}

/**
 * 判断App是否是系统应用
 *
 * @param packageName 包名
 * @return `true`: 是<br></br>`false`: 否
 */
@JvmOverloads
fun Context.isSystemApp(packageName: String = this.packageName): Boolean {
    return try {
        val pm = this.packageManager
        val ai = pm.getApplicationInfo(packageName, 0)
        ai.flags and ApplicationInfo.FLAG_SYSTEM != 0
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        false
    }

}

/**
 * 判断App是否是Debug版本
 *
 * @param packageName 包名
 * @return `true`: 是<br></br>`false`: 否
 */
@JvmOverloads
fun Context.isAppDebug(packageName: String = this.packageName): Boolean {
    return try {
        val pm = this.packageManager
        val ai = pm.getApplicationInfo(packageName, 0)
        ai.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        false
    }

}

/**
 * 获取App签名
 *
 * @param packageName 包名
 * @return App签名
 */
@JvmOverloads
@SuppressLint("PackageManagerGetSignatures")
fun Context.getAppSignature(
    packageName: String = this.packageName
): Array<Signature>? {
    return try {
        val pm = this.packageManager
        val pi = pm.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
        pi?.signatures
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        null
    }

}

/**
 * 获取Manifest Meta Data
 *
 * @param metaKey
 * @return
 */
fun Context.getMetaData(metaKey: String): String {
    val name = this.packageName
    val appInfo: ApplicationInfo
    var msg: String? = ""
    try {
        appInfo = this.packageManager.getApplicationInfo(name, PackageManager.GET_META_DATA)
        msg = appInfo.metaData.getString(metaKey)
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
    }
    return if (msg.isNullOrBlank()) {
        ""
    } else msg

}

/**
 * 获得渠道号
 *
 * @param channelKey
 * @return
 */
fun Context.getChannelNo(channelKey: String): String {
    return getMetaData(channelKey)
}

/**
 * 检查手机上是否安装了指定的软件
 *
 * @param packageName：应用包名
 * @return
 */
fun Context.isInstall(packageName: String?): Boolean {
    // 获取PackageManager
    val packageManager = this.packageManager
    // 获取所有已安装程序的包信息
    val packageInfos =
        packageManager.getInstalledPackages(0)
    // 用于存储所有已安装程序的包名
    val packageNames: MutableList<String> = ArrayList()
    // 从pInfo中将包名字逐一取出，压入pName list中
    for (i in packageInfos.indices) {
        val packName = packageInfos[i].packageName
        packageNames.add(packName)
    }
    // 判断packageNames中是否有目标程序的包名，有TRUE，没有FALSE
    return packageNames.contains(packageName)
}