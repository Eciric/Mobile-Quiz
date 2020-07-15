package com.example.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.NavController
import kotlinx.android.synthetic.main.fragment_ending.*

class EndingFragment : Fragment() {

    lateinit var navController: NavController
    lateinit var login: String
    lateinit var score: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        login = requireArguments().getString("login").toString()
        score = requireArguments().getString("score").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ending, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        text_player.text = "Congratulations $login!"
        text_score.text = "Your score: $score!"
        buttonRestart.setOnClickListener {
            navController.navigate(R.id.action_endingFragment_to_loginFragment)
        }
    }

}