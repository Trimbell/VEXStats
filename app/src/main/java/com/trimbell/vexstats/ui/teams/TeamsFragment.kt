package com.trimbell.vexstats.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.trimbell.vexstats.R
import com.trimbell.vexstats.adapters.TeamRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_teams.*


class TeamsFragment : Fragment() {

    val teamsViewModel: TeamsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = TeamRecyclerViewAdapter { position ->
            val bundle = bundleOf(getString(R.string.position_key) to position)
            findNavController().navigate(R.id.action_navigation_teams_to_teamsDetailFragment, bundle)
        }

        val myLayoutManager = LinearLayoutManager(requireContext())
        recyclerViewTeams.apply {
            this.layoutManager = myLayoutManager
            this.adapter = adapter

            this.addItemDecoration(
                DividerItemDecoration(
                    this.context,
                    myLayoutManager.orientation
                )
            )
        }

        teamsViewModel.myTeams.observe(this, Observer {
            it?.let { teamList ->
                adapter.submitList(ArrayList(teamList))
            }
        })

    }
}
