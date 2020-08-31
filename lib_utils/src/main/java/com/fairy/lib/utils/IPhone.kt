package com.fairy.lib.utils

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.telephony.SmsManager
import android.telephony.TelephonyManager
import com.fairy.lib.utils.vo.PhoneVo

/**
 * 手机相关扩展函数
 *
 * @author: Fairy.
 * @date  : 2020/8/31.
 */

/**
 * 判断设备是否是手机
 *
 * @return `true`: 是<br></br>`false`: 否
 */
fun Context.isPhone(): Boolean {
    val tm = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return tm.phoneType != TelephonyManager.PHONE_TYPE_NONE
}

/**
 * 获取手机号码
 *
 * @return 手机号码，手机号码不一定能获取到
 *
 * 需添加权限 android.permission.READ_PHONE_STATE or android.permission.READ_SMS or android.permission.READ_PHONE_NUMBERS
 */
@SuppressLint("MissingPermission", "HardwareIds")
fun Context.getPhoneNumber(): String {
    return (this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager).line1Number
}

/**
 * 获取IMSI码
 *
 * 需添加权限 `<uses-permission android:name="android.permission.READ_PHONE_STATE"/>`
 *
 * @return IMSI码
 */
@SuppressLint("HardwareIds", "MissingPermission")
fun Context.getIMSI(): String? {
    val tm = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return tm.subscriberId
}

/**
 * 获取移动终端类型
 *
 * @return 手机制式
 *
 *  * [TelephonyManager.PHONE_TYPE_NONE] : 0 手机制式未知
 *  * [TelephonyManager.PHONE_TYPE_GSM] : 1 手机制式为GSM，移动和联通
 *  * [TelephonyManager.PHONE_TYPE_CDMA] : 2 手机制式为CDMA，电信
 *  * [TelephonyManager.PHONE_TYPE_SIP] : 3
 *
 */
fun Context.getPhoneType(): Int {
    val tm = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return tm.phoneType
}

/**
 * 判断sim卡是否准备好
 *
 * @return `true`: 是<br></br>`false`: 否
 */
fun Context.isSimCardReady(): Boolean {
    val tm = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return tm.simState == TelephonyManager.SIM_STATE_READY
}

/**
 * 获取Sim卡运营商名称
 *
 * 中国移动、如中国联通、中国电信
 *
 * @return sim卡运营商名称
 */
fun Context.getSimOperatorName(): String? {
    val tm = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return tm.simOperatorName
}

/**
 * 获取Sim卡运营商名称
 *
 * 中国移动、如中国联通、中国电信
 *
 * @return 移动网络运营商名称
 */
fun Context.getSimOperatorByMnc(): String? {
    val tm = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    val operator = tm.simOperator ?: return null
    return when (operator) {
        "46000", "46002", "46007" -> "中国移动"
        "46001" -> "中国联通"
        "46003" -> "中国电信"
        else -> operator
    }
}

/**
 * 获取手机状态信息
 *
 * 需添加权限 `<uses-permission android:name="android.permission.READ_PHONE_STATE"/>`
 *
 * @return DeviceId(IMEI) = 99000311726612<br></br>
 * DeviceSoftwareVersion = 00<br></br>
 * Line1Number =<br></br>
 * NetworkCountryIso = cn<br></br>
 * NetworkOperator = 46003<br></br>
 * NetworkOperatorName = 中国电信<br></br>
 * NetworkType = 6<br></br>
 * honeType = 2<br></br>
 * SimCountryIso = cn<br></br>
 * SimOperator = 46003<br></br>
 * SimOperatorName = 中国电信<br></br>
 * SimSerialNumber = 89860315045710604022<br></br>
 * SimState = 5<br></br>
 * SubscriberId(IMSI) = 460030419724900<br></br>
 * VoiceMailNumber = *86<br></br>
 */
@SuppressLint("MissingPermission")
fun Context.getPhoneStatus(): PhoneVo {
    val tm = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return PhoneVo(
        deviceId = tm.deviceId,
        deviceSoftwareVersion = tm.deviceSoftwareVersion,
        line1Number = tm.line1Number,
        networkCountryIso = tm.networkCountryIso,
        networkOperator = tm.networkOperator,
        networkOperatorName = tm.networkOperatorName,
        networkType = tm.networkType,
        phoneType = tm.phoneType,
        simCountryIso = tm.simCountryIso,
        simOperator = tm.simOperator,
        simOperatorName = tm.simOperatorName,
        simSerialNumber = tm.simSerialNumber,
        simState = tm.simState,
        subscriberId = tm.subscriberId,
        voiceMailNumber = tm.voiceMailNumber
    )
}

/**
 * 跳至拨号界面
 **/
fun String?.dial(context: Context) {
    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$this"))
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(intent)
}

/**
 * 拨打电话
 *
 * 需添加权限 `<uses-permission android:name="android.permission.CALL_PHONE"/>`
 *
 */
fun String?.call(context: Context) {
    val intent = Intent("android.intent.action.CALL", Uri.parse("tel:$this"))
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(intent)
}

/**
 * 跳至发送短信界面
 *
 * @param content     短信内容
 * @param context
 */
fun String.sendSms(content: String, context: Context) {
    val uri = Uri.parse("smsto:$this")
    val intent = Intent(Intent.ACTION_SENDTO, uri)
    intent.putExtra("sms_body", content)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(intent)
}

/**
 * 发送短信
 *
 * 需添加权限 `<uses-permission android:name="android.permission.SEND_SMS"/>`
 *
 * @param content     短信内容
 * @param context
 */
fun String?.sendSmsSilent(content: String, context: Context) {
    if (content.isNullOrBlank()) return
    val sentIntent = PendingIntent.getBroadcast(context, 0, Intent(), 0)
    val smsManager = SmsManager.getDefault()
    if (content.length >= 70) {
        val ms = smsManager.divideMessage(content)
        for (str in ms) {
            smsManager.sendTextMessage(this, null, str, sentIntent, null)
        }
    } else {
        smsManager.sendTextMessage(this, null, content, sentIntent, null)
    }
}
