package com.example.quiz

object Constants {
    fun getConstants(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        //Question 1
        val q1 = Question(1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Argentina",
            "Germany",
            "Austria",
            "Belgium",
            2)
        questionsList.add(q1)

        //Question 2
        val q2 = Question(2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_poland,
            "Argentina",
            "Germany",
            "Austria",
            "Poland",
            4)
        questionsList.add(q2)

        //Question 3
        val q3 = Question(3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_iceland,
            "Romania",
            "Iceland",
            "Canada",
            "Japan",
            2)
        questionsList.add(q3)

        //Question 4
        val q4 = Question(4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_canada,
            "Canada",
            "Italy",
            "Sweden",
            "France",
            1)
        questionsList.add(q4)

        return questionsList
    }
}