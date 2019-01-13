package win.bemtorres.servicio.carritodecompras


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import win.bemtorres.servicio.controldeinventario.ConexionSQL


class Frag_listar : Fragment() {
    var miContexto : Context?= null


    var lista: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var adaptador:AdapterProducto? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_frag_listar, container, false)
        var total : TextView = view.findViewById(R.id.lblTotalListar)
        var conn = ConexionSQL(miContexto!!,null,1)
        var totalProducto : Double = 0.0
        var productos : ArrayList<Producto> = conn.listarProducto()
        if (productos.size>0){
            for (pro in productos){
                totalProducto += pro.total
            }
        }else{
            totalProducto = 0.0
        }

        total.text = "Total $$totalProducto"

        lista = view.findViewById(R.id.rv_listar)
        layoutManager = LinearLayoutManager(miContexto)
        adaptador = AdapterProducto(productos!!)
        lista?.layoutManager = LinearLayoutManager(miContexto, LinearLayout.VERTICAL,false)
        lista?.adapter = adaptador
        return  view
    }

    override fun onResume() {
        layoutManager = LinearLayoutManager(miContexto)
        var conn = ConexionSQL(miContexto!!,null,1)
        var productos = conn.listarProducto()

        adaptador = AdapterProducto(productos!!)
        lista?.layoutManager = LinearLayoutManager(miContexto, LinearLayout.VERTICAL,false)
        lista?.adapter = adaptador
        super.onResume()
    }


}
