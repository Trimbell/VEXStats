package com.trimbell.vexstats.ui.teams

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.trimbell.vexstats.R
import com.trimbell.vexstats.adapters.TeamRecyclerViewAdapter
import com.trimbell.vexstats.services.network.Endpoints
import com.trimbell.vexstats.services.network.RetroFitInstance
import com.trimbell.vexstats.services.teams.model.BaseTeam
import kotlinx.android.synthetic.main.fragment_teams.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
            val bundle = bundleOf(getString(R.string.TEAM_POSITION_KEY) to position)
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

        teamsViewModel.myTeams.observe(this, androidx.lifecycle.Observer {
            it?.let { teamList ->
                adapter.submitList(ArrayList(teamList))
            }
        })

        if(!teamsViewModel.hasViewModelBeenCalled) fetchDataFromServer(adapter)

    }

    private fun fetchDataFromServer(adapter: TeamRecyclerViewAdapter) {

        val apiCalls = RetroFitInstance.retrofit

        val request = apiCalls.create(Endpoints::class.java).getTeamList()

        progressBar.isVisible = true

        request.enqueue(object : Callback<BaseTeam> {
            // Tell the app what to do if the network call fails for any reason.
            override fun onFailure(call: Call<BaseTeam>, t: Throwable) {
                // Logcat Warn
                Log.w(javaClass.name, "getTeamList() failed. Error: ${t.message}")
//                 Show pop up if Fragment is still in view
                constraintLayout?.let {
                    Snackbar.make(it, "Network request failed.", Snackbar.LENGTH_LONG).show()
                }
            }
            // Tell the app what to do if the network call responds.  This does not mean that it
            // got your data yet.  A 404 from the API is a response.
            override fun onResponse(call: Call<BaseTeam>, response: Response<BaseTeam>) {
                // Get response code
                progressBar.isVisible = false

                when (response.code()) {
                    // 200 equals a successful GET request that will contain the data requested
                    200 -> {
                        response.body()?.let {

//                            adapter.submitList(it.result)
                            teamsViewModel.updateViewModelList(it.result!!.toMutableList())

                            teamsViewModel.hasViewModelBeenCalled = true
                        }
                    }
                    else -> {
                        constraintLayout?.let {
                            Snackbar.make(it, "Something went wrong. CODE: ${response.code()}", Snackbar.LENGTH_LONG).show()
                        }
                    }
                }
            }
        })
    }
}
