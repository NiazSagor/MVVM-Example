package com.duodevloopers.myapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.duodevloopers.myapp.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var mainActivityViewModel: MainActivityViewModel

    private lateinit var binding: FragmentListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityViewModel =
            ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivityViewModel.getAllPersons().observe(viewLifecycleOwner, Observer {
            val personAdapter = PersonAdapter(it)
            binding.personList.adapter = personAdapter
        })

        binding.submit.setOnClickListener(View.OnClickListener {
            mainActivityViewModel.postAllPersons()
        })

        mainActivityViewModel.getPushResponse()
            .observe(viewLifecycleOwner, Observer {
                if (it.isSuccessful) {
                    Toast.makeText(requireContext(), "Post request successful", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT)
                        .show()
                }
            })
    }
}