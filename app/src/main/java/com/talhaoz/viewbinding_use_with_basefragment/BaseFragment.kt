package com.talhaoz.viewbinding_use_with_basefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding>(
    private val bindingInflater : (inflater: LayoutInflater) -> VB
) : Fragment() {

    private var _binding : VB? = null

    val binding: VB
        get() = _binding as VB

    protected var navController: NavController? = null

/*    protected open val redrawFragment: Boolean = false*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (_binding == null) {
            _binding = bindingInflater.invoke(inflater)
            return _binding!!.root
        } else _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreateFinished()
    }

    override fun onStart() {
        super.onStart()
        // get navController onStart because Mainactivity wouldn't be created before that
        // and navController would be null
        navController = (requireActivity() as MainActivity).navController
    }

    protected abstract fun onCreateFinished()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}