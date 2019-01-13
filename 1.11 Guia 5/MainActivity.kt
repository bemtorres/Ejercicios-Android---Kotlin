package com.example.benja.prodcutos

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.text.TextUtils
import android.widget.LinearLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_layout.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayproductos : ArrayList<Producto> = ArrayList()
        arrayproductos.add(Producto("benjamin","hola",2223))
        var adaptador : ProductoAdapter = ProductoAdapter(this,arrayproductos)

        rvLista.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        rvLista.adapter = adaptador

        btnLimpiar.setOnClickListener{
            txtPrecio.setText("")
            txtDescripcion.setText("")
            txtNombre.setText("")
        }

        btnAgregar.setOnClickListener{

            val nombre : String
            val descripcion : String
            val precio : Int

            if(TextUtils.isEmpty(txtNombre.text.toString())){
                txtNombre.error = "Ingrese nombre del producto"
                return@setOnClickListener
            }else{
                nombre = txtNombre.text.toString()
            }
            if(TextUtils.isEmpty(txtDescripcion.text.toString())){
                txtDescripcion.error = "Ingrese descripcion"
                return@setOnClickListener
            }else{
                descripcion = txtDescripcion.text.toString()
            }
            if(TextUtils.isEmpty(txtPrecio.text.toString())){
                txtPrecio.error = "Ingrese precio"
                return@setOnClickListener
            }else{
                precio = txtPrecio.text.toString().toInt()
                if (precio<1000){
                    Toast.makeText(this,"Precio menor que 1000", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Agregado", Toast.LENGTH_SHORT).show()
                    val lista = arrayproductos.size
                    var nuevo : Producto = Producto(nombre,descripcion,precio)
                    arrayproductos.add(nuevo)
                    adaptador.notifyItemInserted(lista)
                }
            }


        }
    }
}

class ProductoAdapter(val miContexto:Context, val miLista:ArrayList<Producto>): RecyclerView.Adapter<ProductoAdapter.CustomerViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val v:View = LayoutInflater.from(miContexto).inflate(R.layout.item_layout,parent,false)
        return CustomerViewHolder(v)
    }

    override fun getItemCount(): Int {
        return miLista.size
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        holder.bindData(miLista[position])
    }

    class CustomerViewHolder(val miView:View):RecyclerView.ViewHolder(miView) {
            fun bindData(prod : Producto){
                miView.il_Nombre.text = prod.nombre
                miView.il_Precio.text = prod.precio.toString()
                miView.il_Descr.text = prod.descripcion
            }
    }
}

