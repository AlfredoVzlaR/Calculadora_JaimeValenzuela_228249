package mx.edu.itson.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var operacion: Int =0
    var n1:Double=0.0

    lateinit var tv_num1:TextView
    lateinit var tv_num2:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_num1 = findViewById(R.id.txtOperacion)
        tv_num2 = findViewById(R.id.txtOperacion2)

        val botonResult: Button = findViewById(R.id.btnResult)
        val botonReset: Button = findViewById(R.id.btnReset)

        val botonDivision: Button = findViewById(R.id.btnDivision)
        val botonMultiplicacion: Button = findViewById(R.id.btnMultiplicacion)
        val botonSuma: Button = findViewById(R.id.btnSuma)
        val botonResta: Button = findViewById(R.id.btnResta)

        botonResult.setOnClickListener {
            try {
                var n2: Double = tv_num2.text.toString().toDouble()
                var respuesta: Double = 0.0

                when (operacion) {
                    1 -> respuesta = n1 + n2
                    2 -> respuesta = n1 - n2
                    3 -> respuesta = n1 * n2
                    4 -> respuesta = n1 / n2
                }
                tv_num2.setText(respuesta.toString())
                tv_num1.setText("")
            }catch(e: java.lang.Exception){}
        }
        botonReset.setOnClickListener {
            tv_num1.setText("")
            tv_num2.setText("")
            n1 = 0.0
            operacion = 0
        }
    }

    fun presionarDigito(view: View){
        try{
        val tv_num2:TextView = findViewById(R.id.txtOperacion2)
        val num2: String = tv_num2.text.toString()

        when(view.id){
            R.id.btn0 -> tv_num2.setText(num2+"0")
            R.id.btn1 -> tv_num2.setText(num2+"1")
            R.id.btn2 -> tv_num2.setText(num2+"2")
            R.id.btn3 -> tv_num2.setText(num2+"3")
            R.id.btn4 -> tv_num2.setText(num2+"4")
            R.id.btn5 -> tv_num2.setText(num2+"5")
            R.id.btn6 -> tv_num2.setText(num2+"6")
            R.id.btn7 -> tv_num2.setText(num2+"7")
            R.id.btn8 -> tv_num2.setText(num2+"8")
            R.id.btn9 -> tv_num2.setText(num2+"9")
        }}catch(e: java.lang.Exception){

        }
    }

    fun operacion(view: View){
        try{
        n1 = tv_num2.text.toString().toDouble()
        var num2_text: String = tv_num2.text.toString()
        tv_num2.setText("")
        when(view.id){
            R.id.btnSuma ->{
                tv_num1.setText(num2_text+"+")
                operacion = 1
            }
            R.id.btnResta ->{
                tv_num1.setText(num2_text+"-")
                operacion = 2
            }
            R.id.btnMultiplicacion ->{
                tv_num1.setText(num2_text+"*")
                operacion = 3
            }
            R.id.btnDivision ->{
                tv_num1.setText(num2_text+"/")
                operacion = 4
            }
        }}catch(e: java.lang.Exception){}
    }
}