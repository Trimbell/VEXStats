package com.trimbell.vexstats.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.trimbell.vexstats.R
import com.trimbell.vexstats.services.teams.model.Team

class TeamRecyclerViewAdapter(private val onClick: (Int) -> Unit) :
    ListAdapter<Team, TeamViewHolder>(TeamDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_team, parent, false)
        return TeamViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.team = getItem(position)
    }

}

class TeamViewHolder(itemView: View, private val onClick: (Int) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    var team: Team? = null
        @SuppressLint("SetTextI18n")
        set(value) {
            field = value
            team?.let {
                itemView.findViewById<TextView>(R.id.textViewVHTeamNumber).text = it.number
                itemView.findViewById<TextView>(R.id.textViewVHTeamName).text = it.teamName
                itemView.findViewById<TextView>(R.id.textViewVHLocation).text =
                    "${it.city}, ${it.region}, ${it.country}"
            }
        }

    init {
        itemView.setOnClickListener { onClick(adapterPosition) }
    }
}

class TeamDiffCallback : DiffUtil.ItemCallback<Team>() {

    override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
        return false
    }
}