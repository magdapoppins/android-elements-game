package poppins.magda.elements

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.Random

class QuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val question_index = rand(0, element_codes.size)
        val question = element_codes[question_index]
        val answer = element_names[question_index]

    }

    val element_codes = arrayOf(
            "Br",
            "Al",
            "Cu",
            "Si",
            "S"
    )
    val element_names = arrayOf(
            "Bromi",
            "Alumiini",
            "Kupari",
            "Pii",
            "Rikki"
    )

    val random = Random()

    fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }
}
