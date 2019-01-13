package win.bemtorres.servicio.carritodecompras

import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import win.bemtorres.servicio.controldeinventario.ConexionSQL

class AdapterProducto (val miLista:ArrayList<Producto>?) : RecyclerView.Adapter<AdapterProducto.ViewHolder>() , View.OnClickListener{


    override fun onClick(p0: View?) {
        Toast.makeText(p0!!.context,"clic", Toast.LENGTH_LONG).show()
    }

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterProducto.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: AdapterProducto.ViewHolder, position: Int) {
        holder.bindItems(miLista!![position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return miLista!!.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(prod: Producto) {
            var vista = itemView
            var nombre: TextView = vista.findViewById(R.id.lblNombre)
            var cant: TextView = vista.findViewById(R.id.lblCant)
            var total: TextView = vista.findViewById(R.id.lblTotal)

            val btnEditar: Button = vista.findViewById(R.id.btnEditar)
            val btnEliminar: Button = vista.findViewById(R.id.btnEliminar)

            nombre.text = prod.nombre.toString()
            cant.text = prod.cant.toString()
            total.text = "$${prod.total.toString()}"

            btnEliminar.setOnClickListener {
                val alerta = AlertDialog.Builder(vista.context)
                alerta.setTitle("Eliminar")

                alerta.setMessage("¿Estás seguro que quieres Producto ${prod.nombre} ?")
                alerta.setPositiveButton("Si", { dialog, which ->
                    val db = ConexionSQL(vista.context, null, 1)
                    db.eliminarProducto(prod.id)
                    bindItems(prod) //actulizar de forma instantanea
                })
                alerta.setNegativeButton("No", { dialog, which ->
                    dialog.cancel()
                })

                alerta.show()
            }
            btnEditar.setOnClickListener {

                var id= prod.id
                var intento: Intent = Intent(vista.context,EditarProducto::class.java)
                intento.putExtra("id",id)
                ContextCompat.startActivity(vista.context, intento, null)
            }


        }
    }

}