package com.example.demo3.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.demo3.R
import com.example.demo3.databinding.FragmentHomeBinding
import com.example.demo3.databinding.FragmentNotificationBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class NotificationFragment : Fragment() {

    private var _viewBinding: FragmentNotificationBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _viewBinding = FragmentNotificationBinding.inflate(inflater, container, false)

        /*-----以下应该放在Adapter里-----*/
        viewBinding.cardView.setOnClickListener {
            val builder: AlertDialog.Builder? = activity?.let { AlertDialog.Builder(it) }
            builder?.apply {
                setTitle("模拟消息标题")
                setMessage("模拟消息内容")
                setPositiveButton("确定") { _, _ ->
                    // 啥也不干
                }
            }?.create()?.show()
        }
        /*----------*/

        return viewBinding.root
    }

    // OptionsMenu创建时
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_notifications, menu)
    }

    // OptionsItem选中时
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val builder: AlertDialog.Builder? = activity?.let { AlertDialog.Builder(it) }

        when(item.itemId) {
            // menu_notification_filter选中时
            R.id.menu_notification_filter -> {
                builder?.apply {
                    setTitle("筛选消息分类")
                    setPositiveButton("确定") { _, _ ->
                        // TODO： 筛选消息
                    }
                    setNegativeButton("取消") { _, _ ->
                        // 啥也不干
                    }
                }?.create()?.show()
            }

            // menu_notification_clear选中时
            R.id.menu_notification_clear -> {
                builder?.apply {
                    setTitle("警告")
                    setMessage("清空所有消息？")
                    setPositiveButton("确定") { _, _ ->
                        // TODO： 清空消息
                        Snackbar.make(viewBinding.root, "清空所有消息成功", Snackbar.LENGTH_SHORT).show()
                    }
                    setNegativeButton("取消") { _, _ ->
                        // 啥也不干
                    }
                }?.create()?.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}