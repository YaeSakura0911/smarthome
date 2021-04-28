package com.example.demo3.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.demo3.R
import com.example.demo3.databinding.FragmentRoomBinding
import com.example.demo3.databinding.FragmentRoomEditBinding

class RoomEditFragment : Fragment() {

    private var _viewBinding: FragmentRoomEditBinding? = null
    private val viewBinding get() = _viewBinding!!
    private var _navController: NavController? = null
    private val navController get() = _navController!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _viewBinding = FragmentRoomEditBinding.inflate(inflater, container, false)
        _navController = findNavController()
        return viewBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_room_edit, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_room_save -> {
//                navController.navigate(R.id.action_roomEditFragment_to_roomDetailFragment)
                navController.navigateUp()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}