package com.uzair.shoemate.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.uzair.shoemate.R
import com.uzair.shoemate.data_source.User
import com.uzair.shoemate.databinding.LoginScreenFragmentBinding
import com.uzair.shoemate.view_models.LoginScreenViewModel

class LoginScreen : Fragment(), View.OnClickListener {
    private val viewModel: LoginScreenViewModel by viewModels()
    private lateinit var binding: LoginScreenFragmentBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.login_screen_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        navController = findNavController()
        binding.screenLoginButton.setOnClickListener(this)
        binding.screenNewLoginButton.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        //Validate User
        if (viewModel.isValidaUser(
                User(
                    binding.screenLoginUserUsernameEditText.text.toString(),
                    binding.screenLoginUserPasswordEditText.text.toString()
                )
            )
        ) {
            //Move to the on boarding screen
            val action = LoginScreenDirections.actionLoginScreenToOnBoardingScreen()
            navController.navigate(action)
        } else {
            Toast.makeText(
                requireContext(),
                "Username or password is not correct",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}