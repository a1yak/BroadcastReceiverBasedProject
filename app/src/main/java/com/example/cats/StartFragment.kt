package com.example.cats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.cats.databinding.FragmentStartBinding
import kotlin.system.exitProcess

class StartFragment : Fragment() {
    private lateinit var btnStart : Button
    private lateinit var btnExit: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentStartBinding.inflate(inflater)
        btnStart = binding.btnStart
        btnExit = binding.btnExit
        btnStart.setOnClickListener { startMainFragment() }
        btnExit.setOnClickListener { exitProcess(0) }
        return binding.root}

    private fun startMainFragment() {
        parentFragmentManager.beginTransaction().replace(R.id.container, MainFragment()).commit()}
}