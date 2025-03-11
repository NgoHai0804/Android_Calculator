package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    fun checkText(re: String): Boolean{
        if (re == "Infinity" || re == "NaN") return false
        return true
    }

    fun checkSizeText(textview1: TextView): Boolean{
        if (textview1.text.length <= 7){
            textview1.textSize = 80f
            return true
        } else if (textview1.text.length <= 10) {
            val result = 680 / (textview1.text.length + 1)
            textview1.textSize = result.toFloat()
            return true
        } else {
            val result = 680 / textview1.text.length
            textview1.textSize = result.toFloat()
            return false
        }
    }

    fun nhapso(a: String, textview1: TextView) {
        if (!checkSizeText(textview1)) return

        if (textview1.text != "0") {
            textview1.text = textview1.text.toString() + a
        } else {
            textview1.text = a
        }
    }

    fun tinh(a1: String, b1: String, dau: String): String {
        var a = a1.toDouble()
        var b = b1.toDouble()
        var re: Double = 0.0
        if (dau == "+") {re = b + a}
        if (dau == "-") {re = b - a}
        if (dau == "*") {re = b * a}
        if (dau == "/") {re = b / a}
        if (re % 1 == 0.0) return re.toInt().toString()
        return re.toString()
    }

    fun tinhtoan(b: String, textview1: TextView, textview2: TextView, daunew: String, dauold: String): String{
        var a = textview1.text.toString()

        // Kiểm tra xem có phải dấu = k?
        if (daunew == "="){
            if (dauold == "") {
                textview2.text = a + "="
                return a
            }
            if (dauold == "=") return textview1.text.toString()
            // Tinh toan

            var re = tinh(a, b, dauold)
            textview2.text = textview2.text.toString() + textview1.text + "="
            textview1.text = re
            checkSizeText(textview1)
            return re
        }

        // Kiểm tra xem trạng thái nhập?
        if (textview2.text.isEmpty() || dauold.isEmpty() || dauold == "="){
            textview2.text = textview1.text.toString() + daunew
            textview1.text = "0"
            checkSizeText(textview1)
            return a
        }

        // Tinh toan
        var re = tinh(a, b, dauold)
        if (checkText(re)) {
            textview1.text = "0"
            textview2.text = re + daunew
            checkSizeText(textview1)
            return re
        } else {
            textview2.text = textview2.text.toString() + textview1.text
            textview1.text = re
            return re
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var re: String = ""
        var dau: String = ""

        val textview1 = findViewById<TextView>(R.id.hientai)
        val textview2 = findViewById<TextView>(R.id.lichsu)
        textview2.text = ""

        findViewById<Button>(R.id.number_0).setOnClickListener {
            if (dau == "=" || !checkText(re)){
                textview1.text = "0"
                textview2.text = ""
                dau = ""
                re = ""
            }
            nhapso("0", textview1)
        }
        findViewById<Button>(R.id.number_1).setOnClickListener {
            if (dau == "=" || !checkText(re)){
                textview1.text = "0"
                textview2.text = ""
                dau = ""
                re = ""
            }
            nhapso("1", textview1)
        }
        findViewById<Button>(R.id.number_2).setOnClickListener {
            if (dau == "=" || !checkText(re)){
                textview1.text = "0"
                textview2.text = ""
                dau = ""
                re = ""
            }
            nhapso("2", textview1)
        }
        findViewById<Button>(R.id.number_3).setOnClickListener {
            if (dau == "=" || !checkText(re) ){
                textview1.text = "0"
                textview2.text = ""
                dau = ""
                re = ""
            }
            nhapso("3", textview1)
        }
        findViewById<Button>(R.id.number_4).setOnClickListener {
            if (dau == "=" || !checkText(re)){
                textview1.text = "0"
                textview2.text = ""
                dau = ""
                re = ""
            }
            nhapso("4", textview1)
        }
        findViewById<Button>(R.id.number_5).setOnClickListener {
            if (dau == "=" || !checkText(re)){
                textview1.text = "0"
                textview2.text = ""
                dau = ""
                re = ""
            }
            nhapso("5", textview1)
        }
        findViewById<Button>(R.id.number_6).setOnClickListener {
            if (dau == "=" || !checkText(re)){
                textview1.text = "0"
                textview2.text = ""
                dau = ""
                re = ""
            }
            nhapso("6", textview1) }
        findViewById<Button>(R.id.number_7).setOnClickListener {
            if (dau == "=" || !checkText(re)){
                textview1.text = "0"
                textview2.text = ""
                dau = ""
                re = ""
            }
            nhapso("7", textview1)
        }
        findViewById<Button>(R.id.number_8).setOnClickListener {
            if (dau == "=" || !checkText(re)){
                textview1.text = "0"
                textview2.text = ""
                dau = ""
                re = ""
            }
            nhapso("8", textview1)
        }
        findViewById<Button>(R.id.number_9).setOnClickListener {
            if (dau == "=" || !checkText(re)){
                textview1.text = "0"
                textview2.text = ""
                dau = ""
                re = ""
            }
            nhapso("9", textview1)
        }


        findViewById<Button>(R.id.amduong).setOnClickListener {
            if (checkText(re)){
                if (!textview1.text.contains("-")){
                    if (textview1.text != "0"){
                        textview1.text = "-" + textview1.text
                    }
                }
                else {
                    textview1.text = textview1.text.toString().substring(1)
                }
            }
        }
        findViewById<Button>(R.id.cham).setOnClickListener {
            if (checkText(re)) {
                if (!textview1.text.contains(".")) {
                    if (textview1.text == "0") nhapso("0.", textview1)
                    else nhapso(".", textview1)
                }
            }
        }


        findViewById<Button>(R.id.BS).setOnClickListener {
            if (checkText(re)) {
                if (textview1.text.length > 1) {
                    textview1.text = textview1.text.dropLast(1)
                    if (textview1.text == "-") textview1.text = "0"
                    checkSizeText(textview1)
                } else {
                    textview1.text = "0"
                }
            }
        }
        findViewById<Button>(R.id.C).setOnClickListener {
            textview1.textSize = 80f
            textview1.text = "0"
            textview2.text = ""
            re = "0"
            dau = ""
        }
        findViewById<Button>(R.id.CE).setOnClickListener {
            textview1.textSize = 80f
            textview1.text = "0"
            if (!checkText(re) || dau == "="){
                textview2.text = ""
            }
        }


        findViewById<Button>(R.id.cong).setOnClickListener {
            if (checkText(re)){
                re = tinhtoan(re, textview1, textview2, "+", dau)
                dau = "+"
                checkSizeText(textview1)
            }
        }
        findViewById<Button>(R.id.tru).setOnClickListener {
            if (checkText(re)){
                re = tinhtoan(re, textview1, textview2, "-", dau)
                dau = "-"
                checkSizeText(textview1)
            }
        }
        findViewById<Button>(R.id.nhan).setOnClickListener {
            if (checkText(re)) {
                re = tinhtoan(re, textview1, textview2, "*", dau)
                dau = "*"
                checkSizeText(textview1)
            }
        }
        findViewById<Button>(R.id.chia).setOnClickListener {
            if (checkText(re)) {
                re = tinhtoan(re, textview1, textview2, "/", dau)
                dau = "/"
                checkSizeText(textview1)
            }
        }


        findViewById<Button>(R.id.bang).setOnClickListener {
            re = tinhtoan(re, textview1, textview2, "=", dau)
            dau = "="
        }
    }
}