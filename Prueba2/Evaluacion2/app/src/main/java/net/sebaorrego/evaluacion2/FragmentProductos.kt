package net.sebaorrego.evaluacion2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.fragment_productos.*


class FragmentProductos : Fragment() {

    var miContexto : Context?= null
    var adaptador:AdapterProducto? = null
    override fun onCreateView( inflater: LayoutInflater,
                               container: ViewGroup?,
                               savedInstanceState: Bundle? ): View?
    {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_productos, container, false)

        var botonAgregar : Button = view.findViewById(R.id.btnAddProducto)
        var lista : RecyclerView = view.findViewById(R.id.lv_Producto)

        var conn = ConexionSQL(miContexto!!,null,1)
        adaptador = AdapterProducto(conn.listarProducto()!!)
        lista.layoutManager = LinearLayoutManager(miContexto,LinearLayout.VERTICAL,false)
        lista.adapter = adaptador

        botonAgregar.setOnClickListener {
            var intento: Intent = Intent(miContexto,AgregarProducto::class.java)
            startActivity(intento)
        }

        return view
    }

    override fun onResume() {
        var conn = ConexionSQL(miContexto!!,null,1)
        adaptador = AdapterProducto(conn.listarProducto()!!)
        lv_Producto.layoutManager = LinearLayoutManager(miContexto,LinearLayout.VERTICAL,false)
        lv_Producto.adapter = adaptador
        super.onResume()
    }
}
