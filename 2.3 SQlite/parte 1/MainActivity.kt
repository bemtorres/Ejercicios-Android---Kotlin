package win.bemtorres.servicio.a0911

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAgregar.setOnClickListener{
            var mensaje = txtNombre.text.toString()
            var conn = ConexionSQL(this, "miBD",null,1)
            conn.insertar(mensaje)
        }

        btnActualizar.setOnClickListener{
            val conn=ConexionSQL(this, "miBD", null, 1)
            val lista=conn.listar()
            val adapter=ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista)
            lvlista.adapter = adapter
        }
    }
}
