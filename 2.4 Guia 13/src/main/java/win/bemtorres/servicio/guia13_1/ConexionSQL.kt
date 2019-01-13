package win.bemtorres.servicio.controldeinventario

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.icu.util.Calendar
import android.util.Log
import android.widget.Toast
import win.bemtorres.servicio.guia13_1.Persona
import java.lang.Exception
import java.sql.SQLException

class ConexionSQL(val miContexto:Context,
            val factory: SQLiteDatabase.CursorFactory?,
            val version: Int):SQLiteOpenHelper(miContexto,"miDB",factory,version){


    override fun onCreate(db: SQLiteDatabase?) {
        val query1 = "CREATE TABLE persona(rut INTEGER PRIMARY KEY, dv TEXT, nombre TEXT, fechaIngreso TEXT)"
        db?.execSQL(query1)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        val query1 = "DROP TABLE IF EXISTS persona;"
        db?.execSQL(query1)
        onCreate(db)

    }

    //agregar

    fun insertarCategoria(persona: Persona){
        try {
            val db = this.writableDatabase
            var cv = ContentValues()

            cv.put("rut" , persona.rut)
            cv.put("dv" , persona.dv)
            cv.put("nombre" , persona.nombre)
            cv.put("fechaIngreso" , persona.fechaIngreso)
            val result = db.insert("persona", null, cv)
            db.close()
            if (result == -1L){
                Toast.makeText(miContexto, "Persona no agregada", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(miContexto, "Persona agregada", Toast.LENGTH_SHORT).show()
            }
        }catch (e:Exception){
            Toast.makeText(miContexto,  "Error ${e.message}", Toast.LENGTH_SHORT).show()
        }

    }

    //Listar
    fun listarPersona() : ArrayList<Persona> {
        var lista = ArrayList<Persona>()
        try {
            val db = this.writableDatabase
            var cursor: Cursor? = null

            cursor = db.rawQuery("SELECT * FROM persona", null)
            if (cursor?.moveToFirst() == true) {
                do {

                    val rut = cursor.getInt(0)
                    val dv = cursor.getString(1)
                    val nombre = cursor.getString(2)
                    val fecha = cursor.getString(3)


                    val per = Persona(rut,dv,nombre,fecha)
                    lista.add(per)
                } while (cursor.moveToNext())
            }
            return lista
        } catch (ex: SQLException) {
            Toast.makeText(miContexto, "Error ${ex.message}", Toast.LENGTH_SHORT).show()
            Log.e("sqlListar", ex.message)
            return lista
        }
    }

    //Buscar
    fun buscarPersona(rut: Int) : Persona?{
        var persona : Persona? = null
        try{
            val db = this.writableDatabase
            var cursor: Cursor? = null

            cursor = db.rawQuery("SELECT * FROM persona", null)
            if (cursor?.moveToFirst() == true) {
                do {
                    if(rut == cursor.getInt(0)){
                        val rut = cursor.getInt(0)
                        val dv = cursor.getString(1)
                        val nombre = cursor.getString(2)
                        val fechaIngreso = cursor.getString(3)
                        persona = Persona(rut,dv,nombre,fechaIngreso)
                        break
                    }
                } while (cursor.moveToNext())
            }
            return persona
        }catch (ex: Exception){
            Toast.makeText(miContexto,"error ${ex.message}",Toast.LENGTH_SHORT).show()
            Log.e("sql Buscar persona",ex.message)
            return  null
        }
    }
}
