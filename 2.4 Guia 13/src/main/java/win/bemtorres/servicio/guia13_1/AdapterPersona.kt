package win.bemtorres.servicio.guia13_1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import win.bemtorres.servicio.controldeinventario.ConexionSQL

class AdapterPersona(val miLista:ArrayList<Persona>?) : RecyclerView.Adapter<AdapterPersona.ViewHolder>() , View.OnClickListener {


    override fun onClick(p0: View?) {
        Toast.makeText(p0!!.context, "clic", Toast.LENGTH_LONG).show()
    }

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPersona.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_persona, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: AdapterPersona.ViewHolder, position: Int) {
        holder.bindItems(miLista!![position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return miLista!!.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var num: Int=0
        fun bindItems(per: Persona) {
            var vista = itemView

            var id: TextView = vista.findViewById(R.id.lblNumber)
            var rut: TextView = vista.findViewById(R.id.lblRut)
            var nombre: TextView = vista.findViewById(R.id.lblNombre)
            var fecha: TextView = vista.findViewById(R.id.lblFecha)
            num=num+1
            id.text = num.toString()

            rut.text = "${per.rut}-${per.dv}"
            nombre.text = per.nombre
            fecha.text = per.fechaIngreso
        }
    }
}