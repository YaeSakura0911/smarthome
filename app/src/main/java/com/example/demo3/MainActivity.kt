package com.example.demo3

import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.demo3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val permission = android.Manifest.permission.ACCESS_FINE_LOCATION

    private var _navController: NavController? = null
    private val navController get() = _navController!!
    private var _viewBinding: ActivityMainBinding? = null
    private val viewBinding get() = _viewBinding!!

    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 把ActionBar改成ToolBar
        setSupportActionBar(viewBinding.toolbar)

        // 设置Navigation
        _navController = Navigation.findNavController(this, R.id.navHostFragment)
        val configuration = AppBarConfiguration.Builder(R.id.homeFragment, R.id.roomFragment, R.id.userFragment).build()
        NavigationUI.setupWithNavController(viewBinding.toolbar, navController, configuration)
        NavigationUI.setupWithNavController(viewBinding.bottonNavigationView, navController)

        // 监听系统广播
//        MainApplication.getInstance().observeBroadcast(this, Observer {
//
//        })
        MainApplication.broadcastData.observe(this, Observer {
            mainViewModel.onWifiChanged()
        })

        // 检测是否取得权限
        if (ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
            // 已取得权限
            onWifiChange()
        } else {
            // 未取得权限
            requestPermissions(arrayOf(permission), 0)
        }
    }

    private fun onWifiChange() {
        // ssid
        // mac
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // 已取得权限
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            onWifiChange()
        }
        // 未取得权限
        else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
            val builder = AlertDialog.Builder(this).setTitle("⚠️警告")

            // 用户选择拒绝
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                // 弹出对话框，向用户说明请求权限的原因
                builder.apply {
                    setMessage("在 Android M 及以上版本，如果您禁止授权位置权限，APP将无法获取 Wi-Fi 信息。")
                    setPositiveButton("确定") { _, _ ->
                        // 再次请求权限
                        requestPermissions(arrayOf(permission), 0)
                    }
                    setNegativeButton("取消") { _, _ ->
                        // 关闭APP
                        finish()
                    }
                }.create().show()
            }
            // 用户选择不再询问
            else{
                // 弹出对话框
                builder.apply {
                    setMessage("模拟消息内容")
                    setPositiveButton("前往设置") { _, _ ->
                        TODO("引导用户前往设置打开权限")
                    }
                    setNegativeButton("取消") { _, _ ->
                        // 关闭APP
                        finish()
                    }
                }.create().show()
            }
        }
    }
}