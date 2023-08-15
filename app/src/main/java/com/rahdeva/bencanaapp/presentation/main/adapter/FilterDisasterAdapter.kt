package com.rahdeva.bencanaapp.presentation.main.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rahdeva.bencanaapp.domain.model.DisasterEnum
import com.rahdeva.bencanaapp.databinding.ItemFilterDisasterBinding

class FilterDisasterAdapter(private val context: Context): RecyclerView.Adapter<FilterDisasterAdapter.ListViewHolder>() {

    private var items = mutableListOf<DisasterEnum>()
    private lateinit var overdueCallback: (values: DisasterEnum) -> Unit

    inner class ListViewHolder(private val binding: ItemFilterDisasterBinding): RecyclerView.ViewHolder(binding.root){

        init {
            binding.btnFilterDisaster.setOnClickListener {
                if(overdueCallback != null){
                    val item = items[adapterPosition]
                    overdueCallback.invoke(item)
                }
            }
        }

        fun bind(item: DisasterEnum){
            binding.apply {
                tvDisasterType.text = item.filterText
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemFilterDisasterBinding.inflate(LayoutInflater.from(context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        return holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(item: List<DisasterEnum>){
        items.addAll(item)
        notifyDataSetChanged()
    }

    fun overdueCallback(callbacks: (values: DisasterEnum) -> Unit){
        overdueCallback = callbacks
    }
}