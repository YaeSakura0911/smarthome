package com.example.demo3.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.demo3.R
import com.example.demo3.databinding.FragmentProductBinding

class ProductFragment : Fragment() {

    private var _viewBinding: FragmentProductBinding? = null
    private val viewBinding get() = _viewBinding!!
    private var _navController: NavController? = null
    private val navController get() = _navController!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _viewBinding = FragmentProductBinding.inflate(inflater, container, false)
        _navController = findNavController()

        /*-----以下应该放在Adapter里-----*/
        viewBinding.cardView.setOnClickListener{
            navController.navigate(R.id.action_to_deviceAdd)
        }
        /*----------*/

        return viewBinding.root
    }

    // OptionsMenu创建时
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }
}