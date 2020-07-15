package com.example.quiz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_questions.*


class QuestionsFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var question: Question
    lateinit var login: String
    var score: Int = 0
    lateinit var scoreString: String
    var position: Int = 1
    lateinit var questionsList: ArrayList<Question>

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

        questionsList = Constants.getConstants()
        updateQuestion()
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.quiz_first_answer_button -> {
                validateAnswer(1)
            }
            R.id.quiz_second_answer_button -> {
                validateAnswer(2)
            }
            R.id.quiz_third_answer_button -> {
                validateAnswer(3)
            }
            R.id.quiz_fourth_answer_button -> {
                validateAnswer(4)
            }
        }
    }

    private fun updateQuestion() {
        if (position > 4) {
            scoreString = score.toString()
            val bundle = bundleOf("login" to login, "score" to scoreString)
            navController.navigate(R.id.action_questionsFragment_to_endingFragment, bundle)
        } else {
            question = questionsList[position-1]

            quiz_progressbar_progress.text = "$position" + "/" + "10"
            quiz_question.text = question.question
            quiz_image.setImageResource(question.image)
            quiz_first_answer_button.text = question.optionOne
            quiz_second_answer_button.text = question.optionTwo
            quiz_third_answer_button.text = question.optionThree
            quiz_fourth_answer_button.text = question.optionFour
        }
    }

    private fun validateAnswer(answer: Int) {
        if (question.correctAnswer == answer) {
            Toast.makeText(activity, "Correct answer", Toast.LENGTH_SHORT).show()
            score+=1
        } else {
            Toast.makeText(activity, "Wrong answer", Toast.LENGTH_SHORT).show()
        }
        position+=1
        updateQuestion()
    }
}