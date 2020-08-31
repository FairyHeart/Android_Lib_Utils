package com.fairy.lib.utils

import java.util.regex.Pattern

/**
 * 正则相关验证
 *
 * @author: Fairy.
 * @date  : 2020/8/31.
 */

/**
 * 验证手机号（简单）
 *
 * @return `true`: 匹配 `false`: 不匹配
 */
fun CharSequence?.isMobile(): Boolean {
    return isMatch("^[1]\\d{10}$", this)
}

/**
 * 验证电话号码
 *
 * @return `true`: 匹配<br></br>`false`: 不匹配
 */
fun CharSequence?.isTel(): Boolean {
    return isMatch("^0\\d{2,3}[- ]?\\d{7,8}", this)
}

/**
 * 验证身份证号码15位
 *
 * @return `true`: 匹配<br></br>`false`: 不匹配
 */
fun CharSequence?.isIDCard15(): Boolean {
    return isMatch(
        "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$",
        this
    )
}

/**
 * 验证身份证号码18位
 *
 * @return `true`: 匹配<br></br>`false`: 不匹配
 */
fun CharSequence?.isIDCard18(): Boolean {
    return isMatch(
        "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9Xx])$",
        this
    )
}

/**
 * 验证邮箱
 *
 * @return `true`: 匹配<br></br>`false`: 不匹配
 */
fun CharSequence?.isEmail(): Boolean {
    return isMatch(
        "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$",
        this
    )
}

/**
 * 验证URL
 *
 * @return `true`: 匹配<br></br>`false`: 不匹配
 */
fun CharSequence?.isURL(): Boolean {
    return isMatch("[a-zA-z]+://[^\\s]*", this)
}

/**
 * 验证汉字
 *
 * @return `true`: 匹配<br></br>`false`: 不匹配
 */
fun CharSequence?.isZh(): Boolean {
    return isMatch("^[\\u4e00-\\u9fa5]+$", this)
}

/**
 * 验证用户名
 *
 * 取值范围为a-z,A-Z,0-9,"_",汉字，不能以"_"结尾,用户名必须是6-20位
 *
 * @return `true`: 匹配<br></br>`false`: 不匹配
 */
fun CharSequence?.isUsername(): Boolean {
    return isMatch(
        "^[\\w\\u4e00-\\u9fa5]{6,20}(?<!_)$",
        this
    )
}

/**
 * 验证IP地址
 *
 * @return `true`: 匹配<br></br>`false`: 不匹配
 */
fun CharSequence?.isIP(): Boolean {
    return isMatch(
        "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)",
        this
    )
}

/**
 * 判断是否匹配正则
 *
 * @param regex 正则表达式
 * @param input 要匹配的字符串
 * @return `true`: 匹配<br></br>`false`: 不匹配
 */
private fun isMatch(regex: String, input: CharSequence?): Boolean {
    return input != null && input.isNotEmpty() && Pattern.matches(regex, input)
}
