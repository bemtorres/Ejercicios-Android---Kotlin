package net.sebaorrego.evaluacion2

import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class AdapterProveedor(val miLista:ArrayList<Proveedor>?) : RecyclerView.Adapter<AdapterProveedor.ViewHolder>() , View.OnClickListener{


    override fun onClick(p0: View?) {
        Toast.makeText(p0!!.context,"clic", Toast.LENGTH_LONG).show()
    }

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterProveedor.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_proveedor, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: AdapterProveedor.ViewHolder, position: Int) {
        holder.bindItems(miLista!![position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return miLista!!.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(prov: Proveedor) {
            var vista = itemView

            var nombreProveedor: TextView = vista.findViewById(R.id.lblNombreP)
            var fecha: TextView = vista.findViewById(R.id.lblFecha)

            val boton: Button = vista.findViewById(R.id.btnDesactivarP)
            val boton2: ImageButton = vista.findViewById(R.id.btnActualizarP)


            nombreProveedor.text = prov.nombreProveedor

            fecha.text =prov.fechaInscripcion



            if(prov.estado==1){
                boton.setText("Activado")
            }else{
                boton.setText("Desactivado")
            }

            boton.setOnClickListener{
                val alerta = AlertDialog.Builder(vista.context)
                alerta.setTitle("Eliminar")
                var estado = "Activar"
                var valor = 0
                if(prov.estado==1){
                    estado="Desactivar"
                    valor = 0
                }else{
                    estado="Activar"
                    valor = 1
                }

                alerta.setMessage("¿Estás seguro que quieres $estado Proveedor?")
                alerta.setPositiveButton("Si", { dialog, which ->
                    val db = ConexionSQL(vista.context, null, 1)
                    prov.estado = valor
                    db.actualizarProveedor(prov)
                    bindItems(prov)
                })
                alerta.setNegativeButton("No", { dialog, which ->
                    dialog.cancel()
                })

                alerta.show()
            }

            boton2.setOnClickListener{
                var id= prov.idProveedor
                var intento: Intent = Intent(vista.context,EditarProveedor::class.java)
                intento.putExtra("idProveedor",id)
                ContextCompat.startActivity(vista.context, intento, null)
            }
        }
    }
}