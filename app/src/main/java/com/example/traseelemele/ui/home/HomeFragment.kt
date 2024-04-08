package com.example.traseelemele.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.traseelemele.data.Traseu
import com.example.traseelemele.databinding.FragmentHomeBinding
import java.util.Date

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val listaTrasee = mutableListOf<Traseu>()
        listaTrasee.add(Traseu().apply {
            denumire = "Traseu 1"
            dataStart = Date()
            dataIncheiere = Date()
        })
        listaTrasee.add(Traseu().apply {
            denumire = "Traseu 2"
            dataStart = Date()
            dataIncheiere = Date()
        })
        listaTrasee.add(Traseu().apply {
            denumire = "Traseu 3"
            dataStart = Date()
            dataIncheiere = Date()
        })

        var adaptorTrasee  = AdaptorTrasee(listaTrasee)
        binding.rvTrasee.adapter = adaptorTrasee
        binding.rvTrasee.layoutManager = LinearLayoutManager(context)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}