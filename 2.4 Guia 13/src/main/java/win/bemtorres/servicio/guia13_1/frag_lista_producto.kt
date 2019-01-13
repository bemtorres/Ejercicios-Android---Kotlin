package win.bemtorres.servicio.guia13_1


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import win.bemtorres.servicio.controldeinventario.ConexionSQL


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class frag_lista_producto : Fragment() {

    var miContexto : Context?= null

    var arrayPersona: ArrayList<Persona>? = null
    var lista: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var adaptador:AdapterPersona? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_lista_producto, container, false)
        lista = view.findViewById(R.id.rv_lista)
        layoutManager = LinearLayoutManager(miContexto)

        var conn = ConexionSQL(miContexto!!,null,1)
        arrayPersona = conn.listarPersona()

        adaptador = AdapterPersona(arrayPersona!!)
        lista?.layoutManager = LinearLayoutManager(miContexto, LinearLayout.VERTICAL,false)
        lista?.adapter = adaptador
        return view
    }

    override fun onResume() {
        layoutManager = LinearLayoutManager(miContexto)
        var conn = ConexionSQL(miContexto!!,null,1)
        arrayPersona = conn.listarPersona()

        adaptador = AdapterPersona(arrayPersona!!)
        lista?.layoutManager = LinearLayoutManager(miContexto, LinearLayout.VERTICAL,false)
        lista?.adapter = adaptador
        super.onResume()
    }



}
