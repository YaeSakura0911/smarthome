package com.example.demo3.fragment

import android.os.Bundle
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.demo3.R
import com.example.demo3.databinding.FragmentRoomAddBinding

class RoomAddFragment : Fragment() {

    private var _viewBinding: FragmentRoomAddBinding? = null
    private val viewBinding get() = _viewBinding!!
    private var _navController: NavController? = null
    private val navController get() = _navController!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _viewBinding = FragmentRoomAddBinding.inflate(inflater, container, false)
        _navController = findNavController()
        return viewBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear() // 清除原有菜单
        inflater.inflate(R.menu.menu_room_add, menu) // 膨胀新的菜单
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_room_save -> {
                navController.navigateUp()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}