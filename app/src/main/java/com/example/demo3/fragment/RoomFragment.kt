package com.example.demo3.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.demo3.R
import com.example.demo3.databinding.FragmentRoomBinding

class RoomFragment : Fragment() {

    private var _viewBinding: FragmentRoomBinding? = null
    private val viewBinding get() = _viewBinding!!
    private var _navController: NavController? = null
    private val navController get() = _navController!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _viewBinding = FragmentRoomBinding.inflate(inflater, container, false)
        _navController = findNavController()

        viewBinding.cardView.setOnClickListener{
            navController.navigate(R.id.action_to_roomDetail)
        }

        return viewBinding.root
    }

    // OptionsMenu创建时
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_room, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    // OptionsItem选中时
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController()
        if (item.itemId == R.id.menu_room_add) {
            navController.navigate(R.id.action_to_roomAdd)
        }
        return super.onOptionsItemSelected(item)
    }
}