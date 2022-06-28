package com.example.cats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cats.databinding.FragmentCatImageBinding
import com.example.cats.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater)
        parentFragmentManager.beginTransaction().replace(R.id.imageContainer, CatImageFragment()).commit()
        parentFragmentManager.beginTransaction().replace(R.id.controlContainer, ControlFragment()).commit()
        return binding.root
    }

}