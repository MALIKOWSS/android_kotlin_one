package com.example.android_kotlin_one.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_kotlin_one.databinding.ItemSecondBinding
import com.example.android_kotlin_one.ui.model.Model

class TwoAdapter(
    private var mainList: ArrayList<Model>,
    private val onClickListener: (name: Model) -> Unit
) : RecyclerView.Adapter<TwoAdapter.SecondViewHolder>() {

    inner class SecondViewHolder(private val binding: ItemSecondBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onClickListener(mainList[bindingAdapterPosition])
            }

        }
        fun onBind(mainModel: Model) {
            Glide.with(binding.ivIcon.context)
                .load(mainModel.image)
                .into(binding.ivIcon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        val binding = ItemSecondBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SecondViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        holder.onBind(mainList[position])
    }

    override fun getItemCount(): Int {
        return mainList.size
    }
}