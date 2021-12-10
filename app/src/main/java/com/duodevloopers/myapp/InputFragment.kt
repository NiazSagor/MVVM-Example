package com.duodevloopers.myapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.duodevloopers.myapp.databinding.FragmentInputBinding

class InputFragment : Fragment() {

    private lateinit var binding: FragmentInputBinding

    private var persons: MutableList<Person> = ArrayList()

    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityViewModel =
            ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = InputAdapter()

        binding.inputList.adapter = adapter

        binding.add.setOnClickListener(View.OnClickListener {

            adapter.onAddClick()

        })

        binding.submit.setOnClickListener(View.OnClickListener {


            for (i in 0..adapter.itemCount) {

                val holder: InputAdapter.InputViewHolder? =
                    binding.inputList.findViewHolderForLayoutPosition(i) as InputAdapter.InputViewHolder?

                if (holder != null) {
                    val name: EditText = holder.itemView.findViewById(R.id.name)
                    val age: EditText = holder.itemView.findViewById(R.id.age)

                    val person = Person(
                        0, name.text.toString(), Integer.parseInt(age.text.toString())
                    )

                    mainActivityViewModel.addPerson(person)
                }
            }

        })

        binding.show.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_inputFragment_to_listFragment)
        })
    }
}