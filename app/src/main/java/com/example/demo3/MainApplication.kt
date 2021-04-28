package com.example.demo3

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.location.LocationManager
import android.net.wifi.WifiManager
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class MainApplication: Application() {

    companion object {
        val broadcastData: MutableLiveData<String> by lazy {
            MutableLiveData<String>()
        }
    }

    // 注册广播接收器接收系统广播
    private val receiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val action = intent.action ?: return
            when (action) {
                WifiManager.NETWORK_STATE_CHANGED_ACTION, LocationManager.PROVIDERS_CHANGED_ACTION -> {
                    broadcastData.value = action
                }
            }
        }
    }

    // 广播过滤器
    private val filter = IntentFilter().apply {
        addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION)
        addAction(LocationManager.PROVIDERS_CHANGED_ACTION)
    }

    // Application创建时
    override fun onCreate() {
        super.onCreate()

        //注册广播接收器
        registerReceiver(receiver, filter)
    }

    // Application销毁时
    override fun onTerminate() {
        super.onTerminate()

        //注销广播接收器
        unregisterReceiver(receiver)
    }
}