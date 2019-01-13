package win.bemtorres.servicio.a0911

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import java.sql.SQLException

class ConexionSQL(val miContexto:Context,
                  val nombre: String,
                  val factory: SQLiteDatabase.CursorFactory?,
                  val version: Int):SQLiteOpenHelper(miContexto,nombre,factory,version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE lista(id INTEGER PRIMARY KEY AUTOINCREMENT, mensaje TEXT)"
        db?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

    fun listar() : ArrayList<String> {
        var lista = ArrayList<String>()
        try {
            val db = this.writableDatabase
            var cursor: Cursor? = null

            cursor = db.rawQuery("SELECT * FROM lista", null)
            if (cursor?.moveToFirst() == true) {
                do {
                    val mensaje = cursor.getString(1)
                    lista.add(mensaje)
                } while (cursor.moveToNext())
            }
            return lista
        } catch (ex: SQLException) {
            Toast.makeText(miContexto, "Error ${ex.message}", Toast.LENGTH_SHORT).show()
            Log.e("sqlListar", ex.message)
            return lista
        }
    }




}