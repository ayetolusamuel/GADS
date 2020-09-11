package com.codingwithset.gads


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingwithset.gads.databinding.SkillItemBinding
import com.codingwithset.gads.entity.SkillIq

class SkillAdapter(private val dataList: SkillIq) :
    RecyclerView.Adapter<SkillAdapter.UserViewHolder>() {

    private var context: Context? = null
    private var _binding: SkillItemBinding? = null
    private val binding get() = _binding!!


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        context = parent.context
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.skill_item, parent, false)
        _binding = SkillItemBinding.bind(view)


        return UserViewHolder(
            binding
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val data = dataList[position]
        println("Size ${dataList.size}")
        Glide.with(context!!)
            .load(data.badgeUrl)
            .into(holder.image)
        holder.name.text = data.name

        val hour = data.score
        val country = data.country
        holder.details.text = "$hour skill IQ score, $country"


    }

    class UserViewHolder(binding: SkillItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val image = binding.image
        val name = binding.name
        val details = binding.details

    }

}
