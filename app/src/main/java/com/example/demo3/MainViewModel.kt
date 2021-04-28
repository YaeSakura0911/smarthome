package com.example.demo3

import android.app.Application
import android.content.Context
import android.content.Context.WIFI_SERVICE
import android.location.LocationManager
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.location.LocationManagerCompat
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val wifiManager: WifiManager = application.applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
    private val locationManager: LocationManager? = getSystemService(getApplication(), LocationManager::class.java)
    private var message: String = ""

    fun onWifiChanged() {
        checkLocation()
        checkWifi()
    }

    private fun checkWifi() {
        val wifiInfo: WifiInfo = wifiManager.connectionInfo
        if (wifiInfo.networkId == -1 && "<unknown ssid>" == wifiInfo.ssid) {
            message = "Please connect Wifi first."
            Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkLocation() {
        if (locationManager == null && locationManager?.let { LocationManagerCompat.isLocationEnabled(it) } == false) {
            message = "Please turn on GPS to get WiFi information."
            Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show()
        }
    }
}