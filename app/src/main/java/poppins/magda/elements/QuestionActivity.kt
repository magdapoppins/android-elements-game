package poppins.magda.elements

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_question.*
import java.util.Random

const val EXTRA_QUESTION = "poppins.magda.elements.QUESTION"

class QuestionActivity : AppCompatActivity() {

    val element_codes = arrayOf(
            "Br",
            "Al",
            "Cu",
            "Si",
            "S"
    )
    val element_names = arrayOf(
            "bromi",
            "alumiini",
            "kupari",
            "pii",
            "rikki"
    )

    var correct_answer = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        var question_index = rand(0, element_codes.size)
        correct_answer = element_names[question_index]

        question_textbox.append(element_codes[question_index])

    }

    val random = Random()

    fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }

    fun check_answer(view: View){
        val answerText = findViewById<EditText>(R.id.answer_box)
        val answer = answerText.text.toString()

        if (answer == correct_answer.toLowerCase()){
            Toast.makeText(this, "Oikein!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, QuestionActivity::class.java).apply {
                putExtra(EXTRA_QUESTION, answer)
            }
            startActivity(intent)
        } else {
            Toast.makeText(this, "Ei mennyt nappiin :/",Toast.LENGTH_SHORT).show()
        }
    }
}
