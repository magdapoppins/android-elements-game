package poppins.magda.elements

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_end.*

class EndActivity : AppCompatActivity() {

    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        score = intent.getIntExtra(SCORE_COUNT, 0)

        end_text.append(score.toString())
    }

    fun startAgain(view: View){
        var intent = Intent(this, MainActivity::class.java).apply{}
        startActivity(intent)
    }
}
