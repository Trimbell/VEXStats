package com.trimbell.vexstats.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.trimbell.vexstats.R
import java.lang.NumberFormatException


class TeamsFragment : Fragment() {

    private lateinit var teamsViewModel: TeamsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        teamsViewModel =
            ViewModelProviders.of(this).get(TeamsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_teams, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        teamsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}
