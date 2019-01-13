package net.sebaorrego.evaluacion2

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.*
import kotlinx.android.synthetic.main.fragment_categorias.*


class FragmentCategorias : Fragment() {

    var miContexto : Context?= null
    var adaptador:AdapterCategoria? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_categorias, container, false)

        val boton: Button = view.findViewById(R.id.btnAgregar)
        var list : RecyclerView  = view.findViewById(R.id.lvlCategoria)
        var txtNombre : EditText = view.findViewById(R.id.txtCategoria)


        var conn = ConexionSQL(miContexto!!,null,1)
        var arrayCategoria = conn.listarCategoria()
        adaptador = AdapterCategoria(arrayCategoria)
        list.layoutManager = LinearLayoutManager(miContexto,LinearLayout.VERTICAL,false)
        list.adapter = adaptador

        boton.setOnClickListener{
            var nombre : String

            if(TextUtils.isEmpty(txtNombre.text.toString())){
                txtNombre.error = "Ingrese nombre Categoría"
                return@setOnClickListener
            }else{
                nombre = txtNombre.text.toString()
            }


            var conn = ConexionSQL(miContexto!!,null,1)
            var encontrado = 0
            //Buscar si existe con el mismo nombre

            var listaC : ArrayList<Categoria> = conn.listarCategoria()

            for (ca in listaC){
                if (ca.nombreCategoria.toUpperCase().equals(nombre.toUpperCase())){
                    encontrado = 1
                }
            }

            if (encontrado==0){
                var categoria = Categoria(1,nombre,1);
                conn.insertarCategoria(categoria)
            }else{
                Toast.makeText(miContexto!!, "Ya Existe", Toast.LENGTH_SHORT).show()
            }

            arrayCategoria = conn.listarCategoria()
            adaptador = AdapterCategoria(arrayCategoria)
            list.layoutManager = LinearLayoutManager(miContexto,LinearLayout.VERTICAL,false)
            list.adapter = adaptador
        }



        return  view
    }

    override fun onResume() {
        var conn = ConexionSQL(miContexto!!,null,1)
        var arrayCategoria = conn.listarCategoria()
        adaptador = AdapterCategoria(arrayCategoria)
        lvlCategoria.layoutManager = LinearLayoutManager(miContexto,LinearLayout.VERTICAL,false)
        lvlCategoria.adapter = adaptador
        super.onResume()
    }
}