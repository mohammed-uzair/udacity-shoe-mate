package com.uzair.shoemate.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.uzair.shoemate.R
import com.uzair.shoemate.data_source.Shoe
import com.uzair.shoemate.databinding.ShoeDetailsScreenFragmentBinding
import com.uzair.shoemate.view_models.ActivityViewModel

class ShoeDetailsScreen : Fragment() {
    private val viewModel: ActivityViewModel by activityViewModels()
    private lateinit var binding: ShoeDetailsScreenFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.shoe_details_screen_fragment,
                container,
                false
            )
        binding.shoe = Shoe()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cancel.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.saveShoe.setOnClickListener {
            //Save to inventory
            viewModel.addShoeToInventory(binding.shoe!!)
            findNavController().popBackStack()
        }
    }
}