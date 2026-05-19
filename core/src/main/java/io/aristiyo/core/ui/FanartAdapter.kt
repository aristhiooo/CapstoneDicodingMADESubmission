package io.aristiyo.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import io.aristiyo.core.databinding.ItemFanartBinding

class FanartAdapter : ListAdapter<String, FanartAdapter.FanartViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FanartViewHolder {
        val binding = ItemFanartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
        return FanartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FanartViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onViewRecycled(holder: FanartViewHolder) {
        super.onViewRecycled(holder)
        holder.onRecycled()
    }

    class FanartViewHolder(private val binding: ItemFanartBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(imageUrl: String) {
            Glide.with(binding.imgFanart)
                .load(imageUrl)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(150))
                .into(binding.imgFanart)
        }

        fun onRecycled() {
            Glide.with(binding.imgFanart).clear(binding.imgFanart)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        }
    }
}