package win.bemtorres.servicio.carritodecompras


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import win.bemtorres.servicio.controldeinventario.ConexionSQL


class Frag_producto : Fragment() {

    var miContexto : Context?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_producto, container, false)

        var nombre : TextView = view.findViewById(R.id.txtNombre)
        var cantidad : TextView = view.findViewById(R.id.txtCant)
        var precio : TextView = view.findViewById(R.id.txtPrecio)
        var total : TextView = view.findViewById(R.id.txtTotal)
        var btnCalcular : Button = view.findViewById(R.id.btnCalcular)
        var btnAgregar : Button = view.findViewById(R.id.btnAgregar)


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
        btnAgregar.setOnClickListener {
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
            var conn = ConexionSQL(miContexto!!,null,1)
            conn.insertarProducto(producto)
        }
        return view
    }

}
