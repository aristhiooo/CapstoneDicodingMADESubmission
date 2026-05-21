package io.aristiyo.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.aristiyo.core.databinding.ItemTeamBinding
import io.aristiyo.core.domain.model.Team

class TeamItemAdapter(
    var onItemClicked: (Team) -> Unit,
) : ListAdapter<Team, TeamItemAdapter.ItemViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int,
    ): ItemViewHolder {
        val binding =
            ItemTeamBinding.inflate(
                LayoutInflater.from(p0.context),
                p0,
                false,
            )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: ItemViewHolder,
        p1: Int,
    ) {
        val data = getItem(p1)
        p0.bind(data)
    }

    inner class ItemViewHolder(
        private var binding: ItemTeamBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Team) {
            Glide.with(itemView.context).load(data.badgeUrl).into(binding.imgBadge)
            binding.tvTeamName.text = data.name
            binding.tvLeague.text = data.league
            binding.tvStadium.text = data.stadium
            binding.tvCountry.text = data.country
            val txtFormedYear = "Est. ${data.formedYear}"
            binding.tvFormedYear.text = txtFormedYear
        }

        init {
            itemView.setOnClickListener {
                onItemClicked.invoke(getItem(bindingAdapterPosition))
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<Team> =
            object : DiffUtil.ItemCallback<Team>() {
                override fun areItemsTheSame(
                    p0: Team,
                    p1: Team,
                ): Boolean = p0.idTeam == p1.idTeam

                override fun areContentsTheSame(
                    p0: Team,
                    p1: Team,
                ): Boolean = p0 == p1
            }
    }
}
