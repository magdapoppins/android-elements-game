package poppins.magda.elements

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_question.*
import java.util.Random

const val EXTRA_QUESTION = "poppins.magda.elements.QUESTION"

class QuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val question_start_index = rand(0, element_codes.size)

        question_textbox.append(element_codes[question_start_index])

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

    fun check_question(view: View){
        val answerText = findViewById<EditText>(R.id.answer_box)
        val answer = answerText.text.toString()
        val intent = Intent(this, QuestionActivity::class.java).apply {
            putExtra(EXTRA_QUESTION, answer)
        }
        startActivity(intent)
    }
}
