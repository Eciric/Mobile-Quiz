package com.example.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_questions.*


class QuestionsFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var login: String
    lateinit var score: String
    val position: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        login = requireArguments().getString("login").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        quiz_first_answer_button.setOnClickListener(this)
        quiz_second_answer_button.setOnClickListener(this)
        quiz_third_answer_button.setOnClickListener(this)
        quiz_fourth_answer_button.setOnClickListener(this)
        val questionsList = Constants.getConstants()
        val question: Question = questionsList[position-1]
        quiz_progressbar_progress.text = "$position" + "/" + "10"

        quiz_question.text = question.question
        quiz_image.setImageResource(question.image)
        quiz_first_answer_button.text = question.optionOne
        quiz_second_answer_button.text = question.optionTwo
        quiz_third_answer_button.text = question.optionThree
        quiz_fourth_answer_button.text = question.optionFour
    }

    override fun onClick(v: View?) {
        when(v!!.id) {

            R.id.quiz_first_answer_button -> {
                Toast.makeText(activity, "1 Pressed", Toast.LENGTH_SHORT).show()

            }
            R.id.quiz_second_answer_button -> {
                Toast.makeText(activity, "2 Pressed", Toast.LENGTH_SHORT).show()

            }
            R.id.quiz_third_answer_button -> {
                Toast.makeText(activity, "3 Pressed", Toast.LENGTH_SHORT).show()

            }
            R.id.quiz_fourth_answer_button -> {
                Toast.makeText(activity, "4 Pressed", Toast.LENGTH_SHORT).show()

            }
        }
    }
}