package win.bemtorres.servicio.listap

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_layout.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lista:ArrayList<Producto> = ArrayList()

        lista.add(Producto("Prestigio","Barra de coco cubierta de chocolate",1000))
        lista.add(Producto("Bepis","Bebida sabor cola", 2000))

        var adaptador : ProductoAdapter = ProductoAdapter(this,lista)

        rvLista.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)

        rvLista.adapter = adaptador

        btnLimpiar.setOnClickListener {
            /*lista.clear()
            lvLista.adapter.notifyDataSetChanged()*/

            var vacio = Editable.Factory().newEditable("")
            editText.text = vacio
            editText2.text = vacio
            editText3.text = vacio
        }

        btnAgregar.setOnClickListener{

            // Validaciones
            if(TextUtils.isEmpty(editText.text)){
                editText.error = "ingrese nombre de producto"
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(editText2.text)){
                editText2.error = "ingrese descripcion"
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(editText3.text)){
                editText3.error = "ingrese precio"
                return@setOnClickListener
            } else {
                if(editText3.text.toString().toInt() < 1000){
                    editText3.error = "precio debe ser mayor a 1000"
                    return@setOnClickListener
                }
            }

            val nuevaPos = lista.size
            var nuevoProducto : Producto = Producto(editText.text.toString(), editText2.text.toString(),editText3.text.toString().toInt())
            lista.add(nuevoProducto)
            adaptador.notifyItemInserted(nuevaPos)

        }
    }
}



class ProductoAdapter(val miContexto: Context, val miLista:ArrayList<Producto>) : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>()
{
    override fun getItemCount(): Int {
        return miLista.size
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        holder.bindData(miLista[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val v: View = LayoutInflater.from(miContexto).inflate(R.layout.item_layout, parent,false)
        return ProductoViewHolder(v)
    }

    class ProductoViewHolder(val miView: View) : RecyclerView.ViewHolder(miView) {

        fun bindData(producto : Producto)
        {
            miView.txtNombre.text = producto.nombre
            miView.txtDescripcion.text = producto.descripcion
            miView.txtPrecio.text = producto.precio.toString()
        }

    }
}
