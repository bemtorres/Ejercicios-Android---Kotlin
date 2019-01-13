package net.sebaorrego.evaluacion2


import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.fragment_proveedores.*


class FragmentProveedores : Fragment() {

    var miContexto : Context? = null
    var adaptador:AdapterProveedor? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_proveedores, container, false)

        val botonAgregar: Button = view.findViewById(R.id.btnAgregarP)
        var list : RecyclerView = view.findViewById(R.id.lv_Proveedor)

        var conn = ConexionSQL(miContexto!!,null,1)
        val arrayProveedor = conn.listarProveedor()
        adaptador = AdapterProveedor(arrayProveedor!!)
        list?.layoutManager = LinearLayoutManager(miContexto,LinearLayout.VERTICAL,false)
        list?.adapter = adaptador


        botonAgregar.setOnClickListener {
            var intento: Intent = Intent(miContexto,AgregarProveedor::class.java)
            startActivity(intento)
        }

        return view
    }

    override fun onResume() {
        var conn = ConexionSQL(miContexto!!,null,1)
        val arrayProveedor = conn.listarProveedor()
        adaptador = AdapterProveedor(arrayProveedor!!)
        lv_Proveedor.layoutManager = LinearLayoutManager(miContexto,LinearLayout.VERTICAL,false)
        lv_Proveedor.adapter = adaptador
        super.onResume()
    }
}