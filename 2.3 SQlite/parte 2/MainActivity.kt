package win.bemtorres.servicio.a0911

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
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
            //val adapter=ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista)
            val adapter:CustomerAdapter = CustomerAdapter(this, R.layout.activity_item,lista)
            lvlista.adapter = adapter
        }
    }
}

class CustomerAdapter(var miContexto:Context,var miRecurso:Int,var miLista:ArrayList<Registro>):ArrayAdapter<Registro>(miContexto,miRecurso,miLista){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = LayoutInflater.from(miContexto).inflate(miRecurso,null)
        val mensaje:TextView = item.findViewById(R.id.lblMensaje)
        val boton:Button = item.findViewById(R.id.btnEliminar)
        val registro = miLista[position]
        mensaje.text = registro.mensaje

        boton.setOnClickListener{
            val alerta = AlertDialog.Builder(miContexto)
            alerta.setTitle("Eliminar")
            alerta.setMessage("¿Estás seguro que quieres eliminar el registro?")
            alerta.setPositiveButton("Si", { dialog, which ->
                val db = ConexionSQL(miContexto,"miBD", null, 1)
                db.eliminar(registro.id)
                this.remove(registro)
            })
            alerta.setNegativeButton("No", { dialog, which ->
                dialog.cancel()
            })

            alerta.show()
        }

        return  item

    }
}
