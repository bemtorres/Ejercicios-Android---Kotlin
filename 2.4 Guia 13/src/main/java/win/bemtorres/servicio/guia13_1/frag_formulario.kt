package win.bemtorres.servicio.guia13_1


import android.app.DatePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import win.bemtorres.servicio.controldeinventario.ConexionSQL


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class frag_formulario : Fragment() {

    var miContexto : Context?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_formulario, container, false)

        var rut : TextView = view.findViewById(R.id.txtRut)
        var dv :  TextView = view.findViewById(R.id.txtDv)
        var nombre : TextView = view.findViewById(R.id.txtNombre)
        var fechaIngreso :  TextView = view.findViewById(R.id.txtFechaIngreso)
        var fecha : String
        var btnFecha:Button = view.findViewById(R.id.btnFecha)
        var btnAgregar:Button = view.findViewById(R.id.btnAgregar)

        val c = Calendar.getInstance()
        val anio = c.get(Calendar.YEAR)
        val mes = c.get(Calendar.MONTH)
        val dia = c.get(Calendar.DAY_OF_MONTH)
        var m= mes+1
        fechaIngreso.text = "$dia/$m/$anio"
        fecha =  "$dia/$m/$anio"

        btnFecha.setOnClickListener{
            val dp = DatePickerDialog(miContexto,
                DatePickerDialog.OnDateSetListener{ view, year, monthOfYear, dayOfMonth ->
                    var m=monthOfYear+1
                    fechaIngreso.text = "$dayOfMonth/$m/$year"
                    fecha = "$dayOfMonth/$m/$year"
                    c.set(anio,mes,dia)
                }, anio,mes,dia)
            dp.show()
        }

        btnAgregar.setOnClickListener {

            var rut1 : Int
            var dv1 : String
            var nombre1:String
            var fecha1:String

            if(TextUtils.isEmpty(rut.text.toString())){
                rut.error = "Ingrese rut"
                return@setOnClickListener
            }else{
                rut1 = rut.text.toString().toInt()
            }

            if(TextUtils.isEmpty(nombre.text.toString())){
                nombre.error = "Ingrese nombre"
                return@setOnClickListener
            }else{
                nombre1 = nombre.text.toString()
            }

            if(TextUtils.isEmpty(dv.text.toString())){
                dv.error = "Ingrese dv"
                return@setOnClickListener
            }else{
                /*
                var estado : Boolean = false
                when(dv.text){
                    "1","2","3","4","5","6","7","8","9","K" -> estado=true
                    else -> estado=false;
                }
                if (estado==false){
                    dv.error = "Dv mal ingresado"
                    return@setOnClickListener
                }else{
                    dv1 = dv.text.toString()
                } */
                dv1 = dv.text.toString()
            }

            fecha1 = fechaIngreso.text.toString()

            var persona = Persona(rut1,dv1,nombre1,fecha1)

            var conn = ConexionSQL(miContexto!!,null,1)

            conn.insertarCategoria(persona)
        }



        return view
    }


}
