package com.uzair.shoemate.screens

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.uzair.shoemate.R
import com.uzair.shoemate.data_source.Shoe
import com.uzair.shoemate.databinding.ShoeListScreenFragmentBinding
import com.uzair.shoemate.view_models.ActivityViewModel

class ShoeListingScreen : Fragment() {
    private val viewModel: ActivityViewModel by activityViewModels()
    private lateinit var binding: ShoeListScreenFragmentBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.shoe_list_screen_fragment, container, false)

        viewModel.shoes.observe(requireActivity(), { shoes ->
            shoes.forEach {
                addShoeItemToList(it)
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.loginScreen) {
            val action = ShoeListingScreenDirections.actionShoeListingScreenToLoginScreen()
            findNavController().navigate(action)
            return true
        }
        return false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addShoeButton.setOnClickListener {
            val action =
                ShoeListingScreenDirections.actionShoeListingScreenToShoeDetailsScreen()
            findNavController().navigate(action)
        }
    }

    private fun addShoeItemToList(shoe: Shoe) {
        val shoeItem = TextView(requireContext())

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(10, 10, 10, 10)

        shoeItem.layoutParams = params
        shoeItem.text =
            "${shoe.companyName} | ${shoe.shoeName} | ${shoe.size} | ${shoe.description}"

        binding.shoeListLayout.addView(shoeItem)
    }
}