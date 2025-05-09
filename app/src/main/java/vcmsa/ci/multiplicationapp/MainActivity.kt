package vcmsa.ci.multiplicationapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MultiplicationTable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplication_table)

        val header = findViewById<TextView>(R.id.multiplicationHeader)
        val resultView = findViewById<TextView>(R.id.multiplicationResult)

        val numberString = intent.getStringExtra("tablenumber")
        val number = numberString?.toIntOrNull()

        if (number != null) {
            header.text = "Multiplication Table of $number"
            val table = buildMultiplicationTable(number)
            resultView.text = table
        } else {
            header.text = "Invalid number"
            resultView.text = "Please enter a valid number in the previous screen."
        }
    }

    private fun buildMultiplicationTable(number: Int): String {
        val sb = StringBuilder()
        for (i in 1..10) {
            sb.append("$number x $i = ${number * i}\n")
        }
        return sb.toString()
    }
}