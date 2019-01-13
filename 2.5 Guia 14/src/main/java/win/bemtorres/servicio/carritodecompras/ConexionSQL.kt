package win.bemtorres.servicio.controldeinventario

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import win.bemtorres.servicio.carritodecompras.Producto
import java.lang.Exception
import java.sql.SQLException

class ConexionSQL(val miContexto:Context,
            val factory: SQLiteDatabase.CursorFactory?,
            val version: Int):SQLiteOpenHelper(miContexto,"miDB1",factory,version){


    override fun onCreate(db: SQLiteDatabase?) {

        val query1 = "CREATE TABLE producto(id INTEGER PRIMARY KEY AUTOINCREMENT,  nombre TEXT, precio REAL, cantidad INTEGER, total REAL )"

        db?.execSQL(query1)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        val query1 = "DROP TABLE IF EXISTS producto;"
        db?.execSQL(query1)
        onCreate(db)

    }

    //agregar

    fun insertarProducto(prod: Producto){
        try {
            val db = this.writableDatabase
            var cv = ContentValues()

            cv.put("nombre" , prod.nombre)
            cv.put("precio" , prod.precio)
            cv.put("cantidad" , prod.cant)
            cv.put("total", prod.total )
            val result = db.insert("producto", null, cv)
            db.close()
            if (result == -1L){
                Toast.makeText(miContexto, "producto no agregado", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(miContexto, "producto agregada", Toast.LENGTH_SHORT).show()
            }
        }catch (e:Exception){
            Toast.makeText(miContexto,  "Error ${e.message}", Toast.LENGTH_SHORT).show()
        }

    }

    //Listar
    fun listarProducto() : ArrayList<Producto> {
        var lista = ArrayList<Producto>()
        try {
            val db = this.writableDatabase
            var cursor: Cursor? = null

            cursor = db.rawQuery("SELECT * FROM producto", null)
            if (cursor?.moveToFirst() == true) {
                do {

                    val id = cursor.getInt(0)
                    val nombre = cursor.getString(1)
                    val precio = cursor.getDouble(2)
                    val cant = cursor.getInt(3)
                    val total = cursor.getDouble(4)

                    val producto = Producto(id,nombre,precio,cant,total)
                    lista.add(producto)
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
    fun buscarProducto(id: Int) : Producto?{
        var producto : Producto? = null
        try{
            val db = this.writableDatabase
            var cursor: Cursor? = null

            cursor = db.rawQuery("SELECT * FROM producto", null)
            if (cursor?.moveToFirst() == true) {
                do {
                    if(id == cursor.getInt(0)){
                        val id = cursor.getInt(0)
                        val nombre = cursor.getString(1)
                        val precio = cursor.getDouble(2)
                        val cant = cursor.getInt(3)
                        val total = cursor.getDouble(4)

                        producto = Producto(id,nombre,precio,cant,total)
                        break
                    }
                } while (cursor.moveToNext())
            }
            return producto
        }catch (ex: Exception){
            Toast.makeText(miContexto,"error ${ex.message}",Toast.LENGTH_SHORT).show()
            Log.e("sql Buscar producto ",ex.message)
            return  null
        }
    }

    fun eliminarProducto(id:Int){
        try {
            val db = this.writableDatabase
            val args = arrayOf(id.toString())
            val result = db.delete("producto","id=?",args)
            if (result ==0){
                Toast.makeText(miContexto,"Producto no eliminado- $args",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(miContexto,"Producto eliminado",Toast.LENGTH_SHORT).show()
            }
        }catch (ex: SQLException){
            Toast.makeText(miContexto,"error ${ex.message}",Toast.LENGTH_SHORT).show()
            Log.e("sqlEliminar", ex.message)
        }
    }

    fun actualizarProducto(prod: Producto){
        try{
            val db = this.writableDatabase
            var cv = ContentValues()

            val args = arrayOf(prod.id.toString())

            cv.put("nombre" , prod.nombre)
            cv.put("precio" , prod.precio)
            cv.put("cantidad" , prod.cant)
            cv.put("total", prod.total )

            val result = db.update("producto",cv,"id=?",args)
            db.close()
            if (result==0){
                Toast.makeText(miContexto,"Producto no actualizado", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(miContexto,"Producto actualizada", Toast.LENGTH_SHORT).show()
            }
        }catch (ex: Exception){
            Toast.makeText(miContexto,"error ${ex.message}",Toast.LENGTH_SHORT).show()
            Log.e("sqlActualizar",ex.message)
        }
    }

}
