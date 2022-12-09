package com.example.android_kotlin_one.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin_one.databinding.ItemFirstBinding
import com.example.android_kotlin_one.ui.model.Model


class OneAdapter(
    private var mainList: ArrayList<Model>,
    private val onClickListener: (name: Model) -> Unit
) : RecyclerView.Adapter<OneAdapter.FirstViewHolder>() {

    inner class FirstViewHolder(private val binding: ItemFirstBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onClickListener(mainList[bindingAdapterPosition])
            }
        }

        fun onBind(mainModel: Model) {
            binding.tvName.text = mainModel.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        val binding = ItemFirstBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FirstViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.onBind(mainList[position])
    }

    override fun getItemCount(): Int {
        return mainList.size
    }
}