package com.example.dogbreedsapplication.ui.breed_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dogbreedsapplication.R
import com.example.dogbreedsapplication.databinding.FragmentBreedDetailsBinding
import com.example.dogbreedsapplication.databinding.FragmentBreedListBinding


/**
 * A simple [Fragment] subclass.
 * Use the [BreedDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BreedDetailsFragment : Fragment() {
    private lateinit var binding: FragmentBreedDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breed_details, container, false)
    }

}