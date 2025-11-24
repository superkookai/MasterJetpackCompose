package com.superkookai.masterjetpackcompose

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner

class NetworkStateHandler: NetworkStateListener {
    override fun observeNetworkState(
        context: Context,
        lifeCycleOwner: LifecycleOwner
    ) {
        Log.v("TAGY","We are observing network state")
    }
}