package com.superkookai.masterjetpackcompose

import android.content.Context
import androidx.lifecycle.LifecycleOwner

interface NetworkStateListener {
    fun observeNetworkState(context: Context, lifeCycleOwner: LifecycleOwner)
}