package com.codingwithset.gads


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingwithset.gads.databinding.LearningItemBinding
import com.codingwithset.gads.entity.Data

class UserAdapter(private val dataList: Data) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var context: Context? = null
    private var _binding: LearningItemBinding? = null
    private val binding get() = _binding!!


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        context = parent.context
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.learning_item, parent, false)
        _binding = LearningItemBinding.bind(view)


        return UserViewHolder(
            binding
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val data = dataList[position]
        println("Result $data")
        Glide.with(context!!)
            .load(data.badgeUrl)
            .into(holder.image)
        holder.name.text = data.name

        val hour = data.hours
        val country = data.country
        holder.details.text = "$hour learning hour, $country"


    }

    class UserViewHolder(binding: LearningItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val image = binding.topLearnerImage
        val name = binding.name
        val details = binding.details

    }

}
