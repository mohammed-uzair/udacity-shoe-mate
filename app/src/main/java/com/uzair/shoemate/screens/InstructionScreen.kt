package com.uzair.shoemate.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.uzair.shoemate.R
import com.uzair.shoemate.databinding.InstructionScreenFragmentBinding

class InstructionScreen : Fragment() {
    private lateinit var binding: InstructionScreenFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.instruction_screen_fragment,
                container,
                false
            )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener {
            val action = InstructionScreenDirections.actionInstructionScreenToShoeListingScreen()
            findNavController().navigate(action)
        }
    }
}