package com.maurozegarra.example.mvvmwithdatabinding

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

@BindingAdapter("visibleProgress")
fun ProgressBar.setVisibleProgress(visible: Boolean?) {
    visible?.let {
        visibility = if (visible) View.VISIBLE else View.GONE
    }
    //visibility = if (visible == true) View.VISIBLE else View.GONE
}
