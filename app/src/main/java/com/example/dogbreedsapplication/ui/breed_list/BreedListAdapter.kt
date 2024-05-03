package com.example.dogbreedsapplication.ui.breed_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.dogbreedsapplication.R
import com.example.dogbreedsapplication.data.model.DogBreedModel
import com.example.dogbreedsapplication.data.model.MessageModel
import com.example.dogbreedsapplication.databinding.DogBreedBinding

class BreedListAdapter(val breedList:List<DogBreedModel>):Adapter<BreedListAdapter.MyViewHolder>() {


    //inner class view holder
    inner class MyViewHolder(itemView: View):ViewHolder(itemView){
        val binding = DogBreedBinding.bind(itemView)

        fun updateUI(dogBreedModel: DogBreedModel) {
            //handle UI changes based on current state

            binding.apply {
//                tvDogBreed.text = dogBreedModel.
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.dog_breed,parent,false))
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    holder.updateUI(breedList[position])
    }
}