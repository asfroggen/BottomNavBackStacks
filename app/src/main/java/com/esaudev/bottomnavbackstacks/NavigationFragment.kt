package com.esaudev.bottomnavbackstacks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.esaudev.bottomnavbackstacks.databinding.FragmentFirstBinding
import com.esaudev.bottomnavbackstacks.databinding.FragmentNavigationBinding

class NavigationFragment : Fragment() {

    private var _binding: FragmentNavigationBinding? = null
    private val binding: FragmentNavigationBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNavigationBinding.inflate(inflater, container, false)

        binding.tvTest.setOnClickListener {
            findNavController().navigate(R.id.action_navigationFragment_to_thirdFragment)
        }

        return binding.root
    }
}