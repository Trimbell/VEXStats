package com.trimbell.vexstats.ui.teamsDetail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.trimbell.vexstats.R
import com.trimbell.vexstats.services.teams.model.Team
import com.trimbell.vexstats.ui.teams.TeamsViewModel
import kotlinx.android.synthetic.main.fragment_teams_detail.*

/**
 * A simple [Fragment] subclass.
 */
class TeamsDetailFragment : Fragment() {

    private val viewModel: TeamsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teams_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var team: Team? = null

        viewModel.myTeams.observe(this, Observer {
            it?.let { teamList ->
                val position = arguments?.get(getString(R.string.TEAM_POSITION_KEY)) as Int
                team = teamList[position]
                team?.let { nonNullTeam ->
                    textViewTeamNumber.text = nonNullTeam.number
                    textViewTeamName.text = nonNullTeam.teamName
                    textViewOrganisation.text = nonNullTeam.organisation
                    textViewProgram.text = "${nonNullTeam.program}, ${nonNullTeam.grade}"
                    textViewLocation.text = "${nonNullTeam.city}, ${nonNullTeam.region}, ${nonNullTeam.country}"
                    textViewRobotName.text = nonNullTeam.robotName
                }
            }
        })
    }


}
