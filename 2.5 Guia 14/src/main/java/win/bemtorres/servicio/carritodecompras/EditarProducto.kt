package win.bemtorres.servicio.carritodecompras

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_editar_producto.*
import win.bemtorres.servicio.controldeinventario.ConexionSQL

class EditarProducto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_producto)

        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        var id = intent.getIntExtra("id",0)


        var conn = ConexionSQL(this,null,1)

        var producto : Producto? = conn.buscarProducto(id.toInt())

        var nombre : TextView = findViewById(R.id.txtNombreEdit)
        var cantidad : TextView = findViewById(R.id.txtCantEdit)
        var precio : TextView = findViewById(R.id.txtPrecioEdit)
        var total : TextView = findViewById(R.id.txtTotalEdit)
        var btnCalcular : Button = findViewById(R.id.btnCalcularEdit)
        var btnActualizar : Button = findViewById(R.id.btnActualizarEdit)


        cantidad.text = producto!!.cant.toString()
        nombre.text = producto!!.nombre
        precio.text = producto!!.precio.toString()
        total.text = producto!!.total.toString()

        btnCalcular.setOnClickListener {
            var nombre1 : String
            var cant1 : Int
            var precio1 : Double
            var total1 : Double

            if(TextUtils.isEmpty(nombre.text.toString())){
                nombre.error = "Ingrese nombre"
                return@setOnClickListener
            }else{
                nombre1 = nombre.text.toString()
            }

            if(TextUtils.isEmpty(cantidad.text.toString())){
                cantidad.error = "Ingrese cantidad"
                return@setOnClickListener
            }else{
                cant1 = cantidad.text.toString().toInt()
            }

            if(TextUtils.isEmpty(precio.text.toString())){
                precio.error = "Ingrese precio"
                return@setOnClickListener
            }else{
                precio1 = precio.text.toString().toDouble()
            }
            total.text = (precio1*cant1).toString()
        }

        btnActualizar.setOnClickListener {
            var nombre1 : String
            var cant1 : Int
            var precio1 : Double
            var total1 : Double

            if(TextUtils.isEmpty(nombre.text.toString())){
                nombre.error = "Ingrese nombre"
                return@setOnClickListener
            }else{
                nombre1 = nombre.text.toString()
            }

            if(TextUtils.isEmpty(cantidad.text.toString())){
                cantidad.error = "Ingrese cantidad"
                return@setOnClickListener
            }else{
                cant1 = cantidad.text.toString().toInt()
            }

            if(TextUtils.isEmpty(precio.text.toString())){
                precio.error = "Ingrese precio"
                return@setOnClickListener
            }else{
                precio1 = precio.text.toString().toDouble()
            }

            total1 = precio1*cant1
            var producto = Producto(1,nombre1,precio1,cant1,total1)
            var conn = ConexionSQL(this,null,1)
            conn.actualizarProducto(producto)


        }

    }
}
