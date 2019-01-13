package win.bemtorres.servicio.calculadora20

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var num1: Double = 0.0
        var num2: Double = 0.0

        var result: String = ""
        btnSuma.setOnClickListener{
            if (TextUtils.isEmpty(txt1.text.toString())) {
                txt1.error = "Ingrese valor 1"
                return@setOnClickListener
            }else{
                num1 = txt1.text.toString().toDouble()
            }
            if(TextUtils.isEmpty(txt2.text.toString())){
                txt2.error = "Ingrese valor 2"
                return@setOnClickListener
            }else
            {
                num2 = txt2.text.toString().toDouble()
            }

            result = (num1+num2).toString()

            Toast.makeText(this,"$result ",Toast.LENGTH_SHORT).show()
        }


        btnResta.setOnClickListener{
            if (TextUtils.isEmpty(txt1.text.toString())) {
                txt1.error = "Ingrese valor 1"
                return@setOnClickListener
            }else{
                num1 = txt1.text.toString().toDouble()
            }
            if(TextUtils.isEmpty(txt2.text.toString())){
                txt2.error = "Ingrese valor 2"
                return@setOnClickListener
            }else
            {
                num2 = txt2.text.toString().toDouble()
            }
            result = (num1-num2).toString()

            Toast.makeText(this,"$result ",Toast.LENGTH_SHORT).show()
        }

        btnMulti.setOnClickListener{
            if (TextUtils.isEmpty(txt1.text.toString())) {
                txt1.error = "Ingrese valor 1"
                return@setOnClickListener
            }else{
                num1 = txt1.text.toString().toDouble()
            }
            if(TextUtils.isEmpty(txt2.text.toString())){
                txt2.error = "Ingrese valor 2"
                return@setOnClickListener
            }else
            {
                num2 = txt2.text.toString().toDouble()
            }
            result = (num1*num2).toString()

            Toast.makeText(this,"$result ",Toast.LENGTH_SHORT).show()
        }


        btnDivision.setOnClickListener{
            if (TextUtils.isEmpty(txt1.text.toString())) {
                txt1.error = "Ingrese valor 1"
                return@setOnClickListener
            }else{
                num1 = txt1.text.toString().toDouble()
            }
            if(TextUtils.isEmpty(txt2.text.toString())){
                txt2.error = "Ingrese valor 2"
                return@setOnClickListener
            }else
            {
                num2 = txt2.text.toString().toDouble()
            }
            try {
                result = (num1/num2).toString()
            }catch (ex : Exception){
                result = ex.toString()
            }


            Toast.makeText(this,"$result ",Toast.LENGTH_SHORT).show()
        }


    }
}
