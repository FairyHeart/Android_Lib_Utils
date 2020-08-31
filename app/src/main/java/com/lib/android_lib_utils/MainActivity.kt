package com.lib.android_lib_utils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fairy.lib.utils.delegate.Preference
import com.fairy.lib.utils.delegate.PreferenceBean
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var text: String by Preference("name", this, "")

    private var a: AA? by PreferenceBean(
        name = "aa", context = this, clazz = AA::class.java
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = "hello"
        tv.text = text

//        a = AA("dd", 100)
        println(a?.a)
        clear_btn.setOnClickListener {
            val d = Preference("named", this, "")
        }
    }
}