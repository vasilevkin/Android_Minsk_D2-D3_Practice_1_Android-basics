package com.vasilevkin.minskpractice1

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


enum class MathOperation {
    PLUS,
    MINUS,
    DIVIDE,
    MULTIPLY,
    NOT_SET
}

class MainActivity : AppCompatActivity() {

    private lateinit var field1: EditText
    private lateinit var field2: EditText
    private lateinit var floatValues: CheckBox
    private lateinit var signedValues: CheckBox
    private lateinit var resultField: TextView
    private lateinit var calculateButton: Button

    private var mathOperation: MathOperation = MathOperation.NOT_SET


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        field1 = findViewById(R.id.editTextField1)
        field2 = findViewById(R.id.editTextField2)
        floatValues = findViewById(R.id.checkBoxFloatValues)
        signedValues = findViewById(R.id.checkBoxSignedValues)
        resultField = findViewById(R.id.textViewResultField)
        calculateButton = findViewById(R.id.calculateButton)

    }

    fun calculate(view: View) {
        if (mathOperation == MathOperation.NOT_SET) {
            Toast.makeText(this, R.string.operation_not_found, Toast.LENGTH_LONG)
                .show()
            return
        }

        val number1 = field1.text.toString().toDouble()
        val number2 = field2.text.toString().toDouble()

        val resultNumber: Double

        when (mathOperation) {
            MathOperation.PLUS -> {
                resultNumber = number1 + number2
            }
            MathOperation.MINUS -> {
                resultNumber = number1 - number2
            }
            MathOperation.DIVIDE -> {
                resultNumber = number1 / number2
            }
            MathOperation.MULTIPLY -> {
                resultNumber = number1 * number2
            }
            else -> {
                resultNumber = 0.0
            }
        }

        resultField.text = resultNumber.toString()

    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.id) {
                R.id.radioButtonOperation1_plus ->
                    if (checked) {
                        mathOperation = MathOperation.PLUS
                    }
                R.id.radioButtonOperation2_minus ->
                    if (checked) {
                        mathOperation = MathOperation.MINUS
                    }
                R.id.radioButtonOperation3_divide ->
                    if (checked) {
                        mathOperation = MathOperation.DIVIDE
                    }
                R.id.radioButtonOperation4_multiply ->
                    if (checked) {
                        mathOperation = MathOperation.MULTIPLY
                    }
            }
        }
    }
}
