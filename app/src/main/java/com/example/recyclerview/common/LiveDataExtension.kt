package com.example.recyclerview.common

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observe(
    lifecycleOwner: LifecycleOwner,
    onReceive: (T) -> Unit
) = observe(lifecycleOwner, Observer { value -> onReceive(value) })