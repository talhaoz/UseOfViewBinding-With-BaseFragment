package com.talhaoz.viewbinding_use_with_basefragment

import com.talhaoz.viewbinding_use_with_basefragment.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {

    override fun onCreateFinished() {
        binding.buttonNavigateToDetail.setOnClickListener {
            navController?.navigate(R.id.detailFragment)
        }
    }
}