package com.example.demo3.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.demo3.R
import com.example.demo3.databinding.FragmentRoomDetailBinding
import com.example.demo3.viewModel.RoomViewModel

class RoomDetailFragment : Fragment() {

    private var roomViewModel: RoomViewModel? = null
    private var _viewBinding: FragmentRoomDetailBinding? = null
    private val viewBinding get() = _viewBinding!!
    private var _navController: NavController? = null
    private val navController get() = _navController!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        roomViewModel = ViewModelProvider(this).get(RoomViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _viewBinding = FragmentRoomDetailBinding.inflate(inflater, container, false)
        _navController = findNavController()
        return viewBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_room_detail, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_room_edit -> {
                navController.navigate(R.id.action_to_roomEdit)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}