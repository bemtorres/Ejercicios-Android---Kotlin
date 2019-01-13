package net.sebaorrego.evaluacion2


import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.support.v7.app.AlertDialog
import android.widget.ImageButton
import android.widget.Toast

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
            var nombreProducto: TextView = vista.findViewById(R.id.lblNombreProducto)
            var persona: TextView = vista.findViewById(R.id.lblCliente)

            val boton: Button = vista.findViewById(R.id.btnDesactivarProducto)
            val boton2: ImageButton = vista.findViewById(R.id.btnActualizarProducto)

            nombreProducto.text = prod.nombre

            val db = ConexionSQL(vista.context, null, 1)

            var nombrePro =  db.buscarProveedor(prod.idProveedor)!!.nombreProveedor.toString()
            persona.text =nombrePro


            if(prod.estado==1){
                boton.setText("Activado")
            }else{
                boton.setText("Desactivado")
            }


            boton.setOnClickListener {
                val alerta = AlertDialog.Builder(vista.context)
                alerta.setTitle("Eliminar")
                var estado = "Activar"
                var valor = 0
                if(prod.estado==1){
                    estado="Desactivar"
                    valor = 0
                }else{
                    estado="Activar"
                    valor = 1
                }

                alerta.setMessage("¿Estás seguro que quieres $estado Producto?")
                alerta.setPositiveButton("Si", { dialog, which ->
                    val db = ConexionSQL(vista.context, null, 1)
                    prod.estado = valor
                    db.actualizarProducto(prod)
                    bindItems(prod)
                })
                alerta.setNegativeButton("No", { dialog, which ->
                    dialog.cancel()
                })

                alerta.show()
            }
            boton2.setOnClickListener {
                val db = ConexionSQL(vista.context, null, 1)
                var prove = db.buscarProveedor(prod.idProveedor)
                var cate = db.buscarCategoria(prod.idCategoria)

                if(prove!!.estado==1 && cate!!.estado==1){
                    var id = prod.idProducto
                    var intento: Intent = Intent(vista.context,EditarProducto::class.java)
                    intento.putExtra("idProducto",id)
                    startActivity(vista.context, intento,null)
                }else{
                    Toast.makeText(vista.context,"producto no disponible" , Toast.LENGTH_SHORT).show()
                }


            }
        }
    }
}