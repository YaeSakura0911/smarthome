package com.example.demo3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.demo3.R
import com.example.demo3.databinding.FragmentDeviceAddBinding

class DeviceAddFragment : Fragment() {

    private var _viewBinding: FragmentDeviceAddBinding? = null
    private val viewBinding get() = _viewBinding!!
    private var _navController: NavController? = null
    private val navController get() = _navController!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _viewBinding = FragmentDeviceAddBinding.inflate(inflater, container, false)
        _navController = findNavController()

        viewBinding.button.setOnClickListener {
            /*-----以下为配网失败后执行-----*/

            /*-----以下为配网成功后执行-----*/
            navController.navigate(R.id.action_to_home)
        }

        return viewBinding.root
    }
}