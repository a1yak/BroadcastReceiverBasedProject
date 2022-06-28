package com.example.cats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cats.databinding.FragmentCatImageBinding
import com.example.cats.databinding.FragmentControlBinding

class ControlFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentControlBinding.inflate(inflater)
        return binding.root
    }
}