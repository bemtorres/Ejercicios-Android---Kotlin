package net.sebaorrego.evaluacion2

import android.icu.util.Calendar

class Proveedor(var idProveedor: Int, var nombreProveedor:String? = null,
                var nombreContacto:String?=null,
                var rut: String? = null, var telefono: String,
                var email:String, var fechaInscripcion: String,
                var estado:Int=1){
    override fun toString(): String {
        return nombreProveedor!!
    }
}