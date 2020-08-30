package com.fairy.lib.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/**
 * Context拓展函数
 *
 * @author: Fairy.
 * @date  : 2019-08-06.
 */
inline fun Context.inflateLayout(
    @LayoutRes layoutResId: Int,
    parent: ViewGroup? = null,
    attachToRoot: Boolean = false
): View = LayoutInflater.from(this).inflate(layoutResId, parent, attachToRoot)
