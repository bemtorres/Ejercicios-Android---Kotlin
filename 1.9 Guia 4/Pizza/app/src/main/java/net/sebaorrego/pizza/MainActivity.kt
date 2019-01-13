package net.sebaorrego.pizza

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAceptar.setOnClickListener{
            var precio : Int = CalcularPrecio()
            var intento = Intent(this,Main2Activity::class.java)
            intento.putExtra("precio",precio.toString())
            startActivity(intento)
        }
    }

    private fun CalcularPrecio(): Int {
        var precio = 0

        when{
            rbPeq.isChecked -> precio += 1500
            rbMed.isChecked -> precio += 3000
            rbFam.isChecked-> precio += 5000
        }

        if(cbCarne.isChecked) precio +=400
        if(cbPepperoni.isChecked){precio +=200}
        if(cbTocino.isChecked){precio +=450}
        if(cbChampi.isChecked){precio +=250}
        if(cbTomate.isChecked){precio +=200}
        if(cbChoclo.isChecked){precio +=200}
        if(cbAceituna.isChecked){precio +=250}

        return precio
    }
}
