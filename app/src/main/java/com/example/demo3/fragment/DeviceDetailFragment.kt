package com.example.demo3.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.demo3.R
import com.example.demo3.databinding.FragmentDeviceAddBinding
import com.example.demo3.databinding.FragmentDeviceDetailBinding
import com.example.demo3.databinding.FragmentNotificationBinding

class DeviceDetailFragment : Fragment() {

    private var _viewBinding: FragmentDeviceDetailBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _viewBinding = FragmentDeviceDetailBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }
}