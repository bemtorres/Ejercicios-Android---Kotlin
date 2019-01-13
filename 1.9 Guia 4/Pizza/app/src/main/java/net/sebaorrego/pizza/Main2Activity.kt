package net.sebaorrego.pizza

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var precio = intent.getStringExtra("precio")
        precioFinal.text = "$$precio"

        btnVolver.setOnClickListener{
            this.onBackPressed()
        }
    }
}
