package com.example.dogbreedsapplication.ui.breed_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogbreedsapplication.R
import com.example.dogbreedsapplication.databinding.ActivityMainBinding
import com.example.dogbreedsapplication.databinding.FragmentBreedListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [BreedListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BreedListFragment : Fragment() {

    private var _binding: FragmentBreedListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //reference for the view model
        val breedListViewModel = ViewModelProvider(this).get(BreedListViewModel::class.java)

        _binding = FragmentBreedListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //using .apply so that the object becomes receiver inside a function
        binding.apply {

            //when tvBreedText is clicked, navigate to breedDetailsFragment
            tvBreedText.setOnClickListener {
                findNavController().navigate(R.id.breedDetailFragment)  //navigate to breedDetails fragment
            }

            //pull the value from BredListViewModel
            breedListViewModel.text.observe(viewLifecycleOwner) {
                tvBreedText.text = it
            }


            /*RecyclerView
            - Layout Manager (Linear, Grid, Staggered)
            - Adapter
            */
            rvDogBreeds.apply {
                layoutManager = LinearLayoutManager(context) //layout manager set
                adapter

            }

        }


        // Inflate the layout for this fragment
        return root
    }

}