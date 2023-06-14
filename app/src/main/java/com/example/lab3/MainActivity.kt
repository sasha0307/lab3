package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var oldValue: String = ""
    var newValue: String = ""
    var currentOperator: String = ""
    var boolEdit: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addValue(view: View)
    {
        val mainView = findViewById<TextView>(R.id.out_textView)
        val button = findViewById<Button>(view.id)
        if (boolEdit)
        {
            mainView.text = ""
            boolEdit = false
        }
        if (mainView.text.toString().indexOf("Ошибка") != -1)
        {
            resetValue(view)
        }
        if (mainView.text.toString() == "0")
        {
            mainView.text = button.text.toString()
        }
        else
        {
            val newValue = mainView.text.toString() + button.text.toString()
            mainView.text = newValue
        }
    }

    fun resetValue(view: View)
    {
        val mainView = findViewById<TextView>(R.id.out_textView)
        mainView.text = "0"
        oldValue = ""
        newValue = ""
        currentOperator = ""
        boolEdit = false
    }
    fun getOperator(view: View)
    {
        val mainView = findViewById<TextView>(R.id.out_textView)
        val operator = findViewById<Button>(view.id)
        if (mainView.text.toString().indexOf("Ошибка") != -1)
        {
            resetValue(view)
        }
        if(currentOperator != "")
        {
            getResult(view)
        }
        currentOperator = operator.text.toString()
        oldValue = mainView.text.toString()
        boolEdit = true
    }

    fun getResult(view: View)
    {
        val mainView = findViewById<TextView>(R.id.out_textView)
        if (mainView.text.toString().indexOf("Ошибка") != -1)
        {
            resetValue(view)
        }
        if (currentOperator != "")
        {
            newValue = mainView.text.toString()
            val value1 = oldValue.toString().toDouble()
            val value2 = newValue.toString().toDouble()
            when(currentOperator) {
                "+" -> mainView.text = (value1 + value2).toString()
                "-" -> mainView.text = (value1 - value2).toString()
                "X" -> mainView.text = (value1 * value2).toString()
                "/" -> if (value2 == 0.0)
                {
                    mainView.text = "Ошибка"
                }
                else
                {
                    mainView.text = (value1 / value2).toString()
                }
            }
            currentOperator = ""
        }
    }

    fun changeOperator(view: View)
    {
        val mainView = findViewById<TextView>(R.id.out_textView)
        if (mainView.text.toString().indexOf("Ошибка") != -1)
        {
            resetValue(view)
        }
        if (mainView.text.toString() != "0")
        {
            mainView.text = (mainView.text.toString().toDouble() * -1.0).toString()
        }
    }

    fun addPoint(view: View)
    {
        val mainView = findViewById<TextView>(R.id.out_textView)
        if (mainView.text.toString().indexOf("Ошибка") != -1)
        {
            resetValue(view)
        }
        if (mainView.text.toString().indexOf(".") == -1)
        {
            mainView.text = mainView.text.toString() + "."
        }
    }

    fun addPercent(view: View)
    {
        val mainView = findViewById<TextView>(R.id.out_textView)
        if (mainView.text.toString().indexOf("Ошибка") != -1)
        {
            resetValue(view)
        }
        if (mainView.text.toString() != "0")
        {
            mainView.text = (mainView.text.toString().toDouble() * 0.01).toString()
        }
    }
}