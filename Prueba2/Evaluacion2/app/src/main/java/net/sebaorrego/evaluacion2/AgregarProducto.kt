package net.sebaorrego.evaluacion2

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_agregar_producto.*
import kotlinx.android.synthetic.main.activity_agregar_proveedor.*


class AgregarProducto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_producto)
        this.requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        listarSpinner()

        val Iva = 0.19
        var valores = Valores()
        var dolar = valores.dolar

        var valorDolar:Double = 0.0
        var valorConIva :Double = 0.0
        var precio: Double =0.0
        var nombreP: String =""
        var cant: Int = 0


        btnCalcular.setOnClickListener {
            precio = 0.0
            dolar = valores.dolar

            if(TextUtils.isEmpty(txtValorP.text.toString())){
                txtValorP.error = "Ingrese Valor"
                return@setOnClickListener
            }else{
                precio = txtValorP.text.toString().toDouble()
            }

            valorDolar = (precio/dolar)
            valorConIva = (precio*Iva + precio)
            lblPrecioConIva.text = "$$valorConIva"
            lblValorDolar.text = "$valorDolar USD"
        }

        btnAgregarProducto.setOnClickListener {
            var proveedor = sp_proveedor.selectedItem as Proveedor
            var categoria = sp_categoria.selectedItem as Categoria

            precio = 0.0
            dolar=valores.dolar

            if(TextUtils.isEmpty(txtValorP.text.toString())){
                txtValorP.error = "Ingrese Valor"
                return@setOnClickListener
            }else{
                precio = txtValorP.text.toString().toDouble()
            }

            valorDolar = (precio/dolar)
            valorConIva = (precio*Iva + precio)

            if(TextUtils.isEmpty(txtNombreProducto.text.toString())){
                txtNombreProducto.error = "Ingrese nombre producto"
                return@setOnClickListener
            }else{
                nombreP = txtNombreProducto.text.toString()
            }
            if(TextUtils.isEmpty(txtCantidad.text.toString())){
                txtCantidad.error = "Ingrese cantidad del producto"
                return@setOnClickListener
            }else{
                cant = txtCantidad.text.toString().toInt()
            }

            var producto = Producto(1,nombreP,cant,precio,valorConIva,valorDolar,proveedor.idProveedor,categoria.idCategoria,1)

            var conn = ConexionSQL(this, null, 1)

            conn.insertarProducto(producto)

            finish()
            // Toast.makeText(this,"${proveedor.nombreProveedor} +  ${categoria.nombreCategoria}", Toast.LENGTH_SHORT).show()
        }


    }

    fun listarSpinner(){
        var proveedores :ArrayList<Proveedor>  = ArrayList()
        var categorias : ArrayList<Categoria> = ArrayList()
        val db = ConexionSQL(this, null, 1)
        categorias = db.listarCategoria()
        proveedores = db.listarProveedor()


        var categoriasActivas : ArrayList<Categoria> = ArrayList()
        var proveedoresActivos :ArrayList<Proveedor>  = ArrayList()


        for (ca in categorias){
            if (ca.estado==1){
                categoriasActivas.add(ca)
            }
        }

        for(pro in proveedores){
            if (pro.estado ==1){
                proveedoresActivos.add(pro)
            }
        }

        if (proveedoresActivos.size>0 && categoriasActivas.size>0){
            sp_proveedor.adapter =  ArrayAdapter<Proveedor>(this, android.R.layout.simple_expandable_list_item_1,proveedoresActivos)
            sp_categoria.adapter = ArrayAdapter<Categoria>(this, android.R.layout.simple_expandable_list_item_1,categoriasActivas)
        }else{
            Toast.makeText(this,"Faltan Datos", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}

