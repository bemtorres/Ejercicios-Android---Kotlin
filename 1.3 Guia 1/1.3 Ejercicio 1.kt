import javax.print.attribute.IntegerSyntax
import javax.swing.text.StyledEditorKit

fun main(args: Array<String>){

    var estado:Boolean = true
    while(estado){
        menu()
        var numero = numeroEntero(" opcion")

        when(numero){
            1 -> adicion()
            2 -> resta()
            3 -> multiplicacion()
            4 -> division()
            5 -> mayor()
            6 -> menor()
            7 -> estado = false
            else -> print("Error...!!")
        }
    }
}

fun menor(){
    println("Ingrese valores")
    var numero1 = numeroEntero(" 1")
    println("")
    var numero2 = numeroEntero(" 2")
    var estado=""
    if(numero1>numero2){
        estado="El $numero2 es Menor que $numero1"
    }
    if(numero1==numero2){
        estado="El $numero1 es igual a el $numero2"
    }
    if(numero1<numero2){
        estado="El $numero2 es Mayor a el $numero1"
    }
    print(estado)
    println("")
    println("")
}


fun mayor(){
    println("Ingrese valores")
    var numero1 = numeroEntero(" 1")
    println("")
    var numero2 = numeroEntero(" 2")
    var estado=""
    if(numero1>numero2){
        estado="El $numero1 es Mayor que $numero2"
    }
    if(numero1==numero2){
        estado="El $numero1 es igual a el $numero2"
    }
    if(numero1<numero2){
        estado="El $numero2 es igual a el $numero1"
    }
    print(estado)
    println("")
    println("")
}


fun division(){
    println("Ingrese valores")
    var numero1 = numeroEntero(" 1")
    println("")
    var numero2 = numeroEntero(" 2")
    var estado=""
    var total = (numero1/numero2)
    print("Multiplicacion de $numero1 / $numero2 = $total")
    println("")
    println("")
}

fun multiplicacion(){
    println("Ingrese valores")
    var numero1 = numeroEntero(" 1")
    println("")
    var numero2 = numeroEntero(" 2")
    var estado=""
    var total = (numero1*numero2)
    print("Multiplicacion de $numero1 X $numero2 = $total")
    println("")
    println("")
}

fun adicion(){
    println("Ingrese valores")
    var numero1 = numeroEntero(" 1")
    println("")
    var numero2 = numeroEntero(" 2")
    var estado=""
    var total = (numero1+numero2)
    print("Suma de $numero1 + $numero2 = $total")
    println("")
    println("")
}
fun resta(){
    println("Ingrese valores")
    var numero1 = numeroEntero(" 1")
    println("")
    var numero2 = numeroEntero(" 2")
    var estado=""
    var total = (numero1-numero2)
    print("Resta   $numero1 - $numero2 = $total")
    println("")
    println("")
}


fun menu(){
    println("*****Menu******")
    println("1.-    Adición")
    println("2.-    Sustracción")
    println("3.-    Multiplicación")
    println("4.-    División")
    println("5.-    Mayor")
    println("6.-    Menor")
    println("7.-    Salir")
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