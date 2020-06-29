package com.example.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var login: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        buttonStart.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.buttonStart -> {
                login = et_name.text.toString()
                if (login.isNotEmpty()) {
                    val bundle = bundleOf("login" to login)
                    navController.navigate(R.id.action_loginFragment_to_questionsFragment, bundle)
                } else {
                    Toast.makeText(activity, "Enter the login", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}