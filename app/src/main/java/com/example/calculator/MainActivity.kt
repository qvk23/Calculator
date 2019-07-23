package com.example.calculator

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.calculator.fragment.FragmentAction
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import javax.xml.xpath.XPathExpression
import kotlin.math.exp

class MainActivity : AppCompatActivity(), FragmentAction.OnFragmentInteractionListener {
    override fun onClickBtn(str: String) {
        when(str){
            // numbers
            "0" -> appendString("0")
            "1" -> appendString("1")
            "2" -> appendString("2")
            "3" -> appendString("3")
            "4" -> appendString("4")
            "5" -> appendString("5")
            "6" -> appendString("6")
            "7" -> appendString("7")
            "8" -> appendString("8")
            "9" -> appendString("9")
            "." -> appendString(".")
            // operators
            "+" -> operator("+")
            "-" -> operator("-")
            "*" -> operator("*")
            "/" -> operator("/")

            // event on click
            "clear" -> {
                tvExpression.text = "0"
                tvCalculation.text = ""
            }
            "back" -> {
                val string = tvExpression.text.toString()
                if(string.isNotEmpty()){
                    tvExpression.text = string.substring(0,string.length-1)
                }
            }
            "=" -> {
                try {
                    val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                    val result = expression.evaluate()
                    val longResult = result.toLong()
                    if(result == longResult.toDouble()){
                        tvCalculation.text = longResult.toString()
                    } else {
                        tvCalculation.text = result.toString()
                    }
                } catch (e: Exception){
                    Log.d("Exception","message: " + e.message)
                }
            }

        }
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spFragmentManager = supportFragmentManager
        val fragTransaction = spFragmentManager.beginTransaction()
        val fragAction = FragmentAction()
        fragTransaction.add(R.id.frameLayoutFragmentAction,fragAction,"fragment Action")
        fragTransaction.commit()
    }
    fun appendString(str: String){
        if(tvCalculation.text.isNotEmpty()){
            tvExpression.text = "0"
        }
        if(tvExpression.text.toString() != "0" ){
            tvExpression.append(str)
        }
        else {
            tvExpression.text = str
        }
    }
    fun operator(str: String){
        val string = tvExpression.text.toString()
        val last = string[string.length-1]
        if(last == '+' || last == '/' || last == '*' || last == '-' ){
            tvExpression.text = string.substring(0,string.length-1)
        }
        tvExpression.append(str)
    }
}
