package com.example.kotlinccrash

import android.widget.RemoteViews
import androidx.core.widget.RemoteViewsCompat.setTextViewHint

class ExampleUnitTest {
    fun setTextViewError_string() {
        RemoteViews("", 0).setTextViewHint(0, "Hello world")
    }
}
