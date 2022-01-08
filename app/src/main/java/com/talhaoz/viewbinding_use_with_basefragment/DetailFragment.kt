package com.talhaoz.viewbinding_use_with_basefragment

import com.talhaoz.viewbinding_use_with_basefragment.databinding.FragmentDetailBinding


class DetailFragment : BaseFragment<FragmentDetailBinding>(
    FragmentDetailBinding::inflate
) {
    override fun onCreateFinished() {
        binding.buttonNavigateToHome.setOnClickListener {
            navController?.navigate(R.id.homeFragment)
        }
    }

}