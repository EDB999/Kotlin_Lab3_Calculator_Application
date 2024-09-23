package com.example.kotlin_lab3_calculator_application

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

            val zeroButton = findViewById<TextView>(R.id.btn_0)
                .setOnClickListener {fillTextFields("0")}
            val firstButton = findViewById<TextView>(R.id.btn_1)
                .setOnClickListener {fillTextFields("1")}
            val secondButton  = findViewById<TextView>(R.id.btn_2)
                .setOnClickListener {fillTextFields("2")}
            val thirdButton = findViewById<TextView>(R.id.btn_3)
                .setOnClickListener{fillTextFields("3")}
            val forthButton = findViewById<TextView>(R.id.btn_4)
                .setOnClickListener{fillTextFields("4")}
            val fifthButton = findViewById<TextView>(R.id.btn_5)
                .setOnClickListener{fillTextFields("5")}
            val sixthButton = findViewById<TextView>(R.id.btn_6)
                .setOnClickListener{fillTextFields("6")}
            val seventhButton = findViewById<TextView>(R.id.btn_7)
                .setOnClickListener{fillTextFields("7")}
            val eighthButton = findViewById<TextView>(R.id.btn_8)
                .setOnClickListener{fillTextFields("8")}
            val ninthButton = findViewById<TextView>(R.id.btn_9)
                .setOnClickListener {fillTextFields("9")}

            val minusButton = findViewById<TextView>(R.id.btn_minus)
                .setOnClickListener {fillTextFields("-")}

            val plusButton = findViewById<TextView>(R.id.btn_plus)
                .setOnClickListener {fillTextFields("+")}

            val multiButton = findViewById<TextView>(R.id.btn_multi)
                .setOnClickListener {fillTextFields("*")}

            val divideButton = findViewById<TextView>(R.id.btn_divide)
                .setOnClickListener {fillTextFields("/")}

            val leftBracketButton = findViewById<TextView>(R.id.btn_bracket1)
                .setOnClickListener {fillTextFields("(")}

            val rightBracketButton = findViewById<TextView>(R.id.btn_bracket2)
                .setOnClickListener {fillTextFields(")")}

            val clearButton = findViewById<TextView>(R.id.btn_clear)
                .setOnClickListener {
                    val calculatedText = findViewById<TextView>(R.id.calculate);
                    calculatedText.text = "";

                    val resultText = findViewById<TextView>(R.id.result);
                    resultText.text = "";
                }

            val backButton = findViewById<TextView>(R.id.btn_back)
                .setOnClickListener {
                    val calculateTextView = findViewById<TextView>(R.id.calculate)
                    val resultText = findViewById<TextView>(R.id.result)
                    val str = calculateTextView.text.toString()
                    if (str.isNotEmpty()) {
                        calculateTextView.text = str.substring(0, str.length - 1)

                        resultText.text = ""
                }
            }

            val equalButton = findViewById<TextView>(R.id.btn_equal)
                .setOnClickListener {
                    try{
                        val calculatedText = findViewById<TextView>(R.id.calculate)
                        val resultText = findViewById<TextView>(R.id.result)
                        val ex = ExpressionBuilder(calculatedText.text
                            .toString())
                            .build()

                        val result = ex.evaluate()

                        val longRes = result.toLong()

                        if(result == longRes.toDouble()){
                            resultText.text = longRes.toString()
                        }
                        else
                            resultText.text = result.toString()
                    }
                    catch (e:Exception){
                        Log.d("Ошибка", "Сообщение: ${e.message}")
                    }
                }

            val dotButton = findViewById<TextView>(R.id.btn_float)
                .setOnClickListener(){fillTextFields(".")}

    }

        fun fillTextFields(str: String){
            val calculatedText = findViewById<TextView>(R.id.calculate)
            val resultText = findViewById<TextView>(R.id.result)
            if(resultText.text != ""){
                calculatedText.text = resultText.text
                resultText.text = ""
            }

                calculatedText.append(str);
        }
    }