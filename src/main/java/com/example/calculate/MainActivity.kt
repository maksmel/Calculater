package com.example.calculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        but0.setOnClickListener { setEditTextFields("0") }
        but1.setOnClickListener { setEditTextFields("1") }
        but2.setOnClickListener { setEditTextFields("2") }
        but3.setOnClickListener { setEditTextFields("3") }
        but4.setOnClickListener { setEditTextFields("4") }
        but5.setOnClickListener { setEditTextFields("5") }
        but6.setOnClickListener { setEditTextFields("6") }
        but7.setOnClickListener { setEditTextFields("7") }
        but8.setOnClickListener { setEditTextFields("8") }
        but9.setOnClickListener { setEditTextFields("9") }
        butSum.setOnClickListener { setEditTextFields("+") }
        butMinus.setOnClickListener { setEditTextFields("-") }
        butMultiply.setOnClickListener { setEditTextFields("*") }
        butShare.setOnClickListener { setEditTextFields("/") }

        butClear.setOnClickListener {
            field.text = ""
            result.text = ""
        }

        butDelete.setOnClickListener {
            val str = field.text.toString()
            if(str.isNotEmpty())
                field.text = str.substring(0,str.length - 1)

            result.text = ""

        }

        butOperate.setOnClickListener {
            try {
                val ex = ExpressionBuilder(field.text.toString()).build()
                val res = ex.evaluate()

                val longRes = res.toLong()
                if(res == longRes.toDouble())
                    result.text = longRes.toString()
                else
                    result.text = res.toString()

            } catch (e:Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }

    }

    private fun setEditTextFields(str: String) {
        if(result.text != "")
            field.text = result.text
            result.text = ""
        field.append(str)
    }

}