package win.bemtorres.servicio.a0911

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import java.lang.Exception
import java.sql.SQLException

class ConexionSQL(val miContexto:Context,
                  val nombre: String,
                  val factory: SQLiteDatabase.CursorFactory?,
                  val version: Int):SQLiteOpenHelper(miContexto,nombre,factory,version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE lista(id INTEGER PRIMARY KEY AUTOINCREMENT, mensaje TEXT)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        val query = "DROP TABLE IF EXISTS lista;"
        db?.execSQL(query)
        onCreate(db)
    }


    fun insertar(mensaje : String){
        try{
            val db = this.writableDatabase
            var cv = ContentValues()
            cv.put("mensaje" , mensaje)
            val result = db.insert("lista", null, cv)
            db.close()
            if (result == -1L){
                Toast.makeText(miContexto, "Mensaje no aceptado", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(miContexto, "Mensaje es aceptado", Toast.LENGTH_SHORT).show()
            }
        }catch (ex: SQLException){
            Toast.makeText(miContexto," ${ex.toString()}", Toast.LENGTH_SHORT).show()
            Log.e("sqlInsertar", ex.message)
        }
    }

    fun listar() : ArrayList<Registro> {
        var lista = ArrayList<Registro>()
        try {
            val db = this.writableDatabase
            var cursor: Cursor? = null

            cursor = db.rawQuery("SELECT * FROM lista", null)
            if (cursor?.moveToFirst() == true) {
                do {
                    val id = cursor.getInt(0)
                    val mensaje = cursor.getString(1)
                    val re =Registro(id,mensaje)
                    lista.add(re)
                } while (cursor.moveToNext())
            }
            return lista
        } catch (ex: SQLException) {
            Toast.makeText(miContexto, "Error ${ex.message}", Toast.LENGTH_SHORT).show()
            Log.e("sqlListar", ex.message)
            return lista
        }
    }

    fun eliminar(id:Int){
        try {
            val db = this.writableDatabase
            val args = arrayOf(id.toString())
            val result = db.delete("lista","id=?",args)
            if (result ==0){
                Toast.makeText(miContexto,"Mensaje no eliminado - $args",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(miContexto,"Mensaje eliminado",Toast.LENGTH_SHORT).show()
            }
        }catch (ex: SQLException){
            Toast.makeText(miContexto,"error ${ex.message}",Toast.LENGTH_SHORT).show()
            Log.e("sqlEliminar", ex.message)
        }
    }

    fun actualizar(registro: Registro){
        try{
            val db = this.writableDatabase
            var cv = ContentValues()
            val args = arrayOf(registro.id.toString())
            cv.put("mensaje",registro.mensaje)
            val result = db.update("lista",cv,"id=?",args)
            db.close()
            if (result==0){
                Toast.makeText(miContexto,"Mensaje no actualizado", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(miContexto,"Mensaje actualizado", Toast.LENGTH_SHORT).show()
            }
        }catch (ex: Exception){
            Toast.makeText(miContexto,"error ${ex.message}",Toast.LENGTH_SHORT).show()
            Log.e("sqlActualizar",ex.message)
        }
    }



}