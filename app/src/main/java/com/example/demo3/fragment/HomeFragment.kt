package com.example.demo3.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.demo3.R
import com.example.demo3.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _viewBinding: FragmentHomeBinding? = null
    private val viewBinding get() = _viewBinding!!
    private var _navController: NavController? = null
    private val navController get() = _navController!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _viewBinding = FragmentHomeBinding.inflate(inflater, container, false)
        _navController = findNavController()

        /*-----以下应该放在Adapter里-----*/
        viewBinding.cardView.setOnClickListener{
            navController.navigate(R.id.action_to_deviceDetail)
        }
        viewBinding.cardView.setOnLongClickListener{
            val builder: AlertDialog.Builder? = activity?.let { AlertDialog.Builder(it) }
            builder?.apply {
                setTitle("警告")
                setMessage("删除当前设备？")
                setPositiveButton("确定") { _, _ ->
                    // TODO： 删除设备
                    Toast.makeText(context, "删除设备成功", Toast.LENGTH_LONG).show()
                }
                setNegativeButton("取消") { _, _ ->
                    // 啥也不干
                }
            }?.create()?.show()
            true
        }
        /*----------*/

        return viewBinding.root
    }

    // OptionsMenu创建时
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_home, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    // OptionsItem选中时
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            // menu_notifications选中时
            R.id.menu_notifications -> {
                navController.navigate(R.id.action_to_notification)
            }

            // menu_device_add选中时
            R.id.menu_device_add -> {
                navController.navigate(R.id.action_to_product)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}