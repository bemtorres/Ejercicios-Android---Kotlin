import javax.print.attribute.IntegerSyntax
import javax.swing.text.StyledEditorKit

fun main(args: Array<String>){

    var listP: Array<Producto> = arrayOf(
            Producto(1,"Barros Lucos", 2000),
            Producto(2,"Churrascos", 1500),
            Producto(3,"Ave-Palta-Mayo",2500),
            Producto(4,"Pequeña", 450),
            Producto(5,"Mediana", 650),
            Producto(6,"Grande", 800))

    var carrito: String = ""
    var total: Int = 0
    var estado:Boolean = true

    while(estado){
        menu(listP)
        var numero = numeroEntero(" opcion")
        var n = numero-1
        var prod : Producto? = null
        if (numero>0){

            if(numero<7){
                var cant = numeroEntero(" cantidad")
                prod = listP.get(n)
                var nombre = ""
                if (numero>3){
                    nombre = "Bebida "
                }
                carrito+= " " + cant + "X " + nombre + prod.nombre + " $" + (prod.precio*cant) + "\n"
                total+= (prod.precio * cant)
            }
        }
        if (numero==7){
            estado = false
        }
    }
    menuSalida(total,carrito)
}

class Producto(var id:Int, var nombre:String , var precio:Int){}


fun menuSalida(total: Int ,carrito: String){
    println("*******************")
    println("¡Sándwiches boom!")
    println("********************")
    println(carrito)
    println("")
    println("")
    println("Total, a pagar $$total")
    println("Gracias por su compra")
}

fun menu(pro : Array<Producto>){
    println("*****Menu******")

    println("Sándwiches_")
    for (p in pro){
        if (p.id==4){
            println("Bebidas:")
        }
        println("        ${p.id}.-  ${p.nombre}   $${p.precio} ")
    }
    println("7 .- Comprar")
    println("***************")
}

fun numeroEntero(valor : String) : Int {
    var numero: Int? =0
    var estado : Boolean = true
    while (estado){
        try {
            println("Ingrese valores $valor ")
            numero = readLine()!!.toInt()

            if (numero is Int){
                estado = false
            }

        }catch (ex:Exception){
            println("Error Ingrese valores correcto")
            continue;
        }
    }

    return numero!!
}