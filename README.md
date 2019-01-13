# Ejercicios

## 1.3 Guía 1 

### Ejercicio n°1.-
Usted a sido seleccionado para participar en el proceso de contratación de una nueva empresa dedicada a la producción de softwares, como parte de su proceso de selección, se le ha pedido que realizar una calculadora, para demostrar sus conocimientos y dominio sobre el lenguaje Kotlin, la calculadora debe cumplir con los siguientes requerimientos:

1.	Crear un menú que tenga las opciones de adición, sustracción, multiplicación, división, obtener mayor, obtener menor y salir.

2.	Para cada opción del menú debe considerar:

 a.	Adición: permite sumar dos números, además de mostrar el resultado, con la ecuación completa ej.: “2 + 2 = 4”.
 b.	Sustracción: permite restar dos números, además de mostrar el resultado, con la ecuación completa ej.: “4 – 2 = 2”.
 c.	Multiplicación: permite multiplicar dos números, además de mostrar el resultado, con la ecuación completa ej.: “4 * 2 = 8”.
 d.	Dividir: permite dividir dos números, además de mostrar el resultado, con la ecuación completa ej.: “8 / 2 = 4”.
 e.	Obtener mayor: permite ingresar dos números y muestra que número es el mayor, ej.: “ 5 es mayor que 2”.
 f.	Obtener menor: permite ingresar dos números y muestra que número es el menor, ej.: “2 es menor que 5”.

3.	Consideré que la calculadora siempre debe funcionar, luego de elegir una opción y ésta muestre el resultado, debe regresar al menú principal, hasta que se seleccione la opción de salir.

4.	No olvide aplicar las reglas y restricciones matemáticas.

### Ejercicio n°2.-

Ha sido contactado por un emergente local de comida rápida llamado “¡Sándwiches boom!” para que les desarrolle un software que permita calcular el valor de la venta de los siguientes productos:
•	Sándwiches
  a.	Barros lucos      $2000.
  b.	Churrasco         $1500.
  c.	Ave-Palta-Mayo $2500.
•	Bebidas
  a.	Pequeña            $450.
  b.	Mediana            $650.
  c.	Grande             $800.

1.	El sistema debe permitir comprar sándwiches y bebidas, el cliente puede comprar más de un sándwich y bebida, así que es necesario que el sistema permita comprar las cantidades que el cliente desee. Una vez que el cliente termine de seleccionar todos los productos, debe imprimir por pantalla el total a pagar, además del detalle, ej.:

******************
¡Sándwiches boom!
*****************
1x Churrasco $2000
2x Ave-Palta-Mayo $5000
1x Bebida Pequeña $450
1x Bebida Mediana $650
1x Bebida Grande $800

Total, a pagar: $8900.
Gracias por su compra.

2.	No olvide validar las cantidades y opciones sean correctas y válidas.



## 1.8 Guía 3 Calculadora
¿Recuerda la primera calculadora que creó? Usted ha avanzado con el proceso de contratación de dicha empresa. Por lo que ahora se le ha pedido crear una nueva calculadora, ahora en Android Studio y con la interfaz adecuada. La empresa le proporciona una vista previa de como debe verse la aplicación.
 
[] img 1

1.	El resultado debe ser mostrado utilizando un Toast.
2.	Es necesario que todo los texto sean a través de los elementos de string y no con “hardcoding”.
3.	No olvide aplicar las reglas y restricciones matemáticas.

## 1.9 Guía 4 Pizza
La pizzería Juanito lo a contactado para crear una pequeña aplicación en Android que les permita a sus clientes calcular los precios de sus pizzas, según su tamaño e ingredientes. Para esto se le ha enviado una pantalla de muestra de como debería verse la aplicación junto con los precios de cada producto.

[] img 2

Cree una aplicación que permita dar solución al requerimiento de la pizzería Juanito.
1.	El resumen de ingredientes junto al precio final debe ser mostrados en un nuevo activity.
2.	Es necesario que todo los texto sean a través de los elementos de string y no con “hardcoding”.
3.	El segundo activity debe contar un un botón que permita volver al activity principal.

## 1.11 Guía 5

Usted a sido contactado por una empresa que se dedica a realizar inventario de productos, para que realice una aplicación en Android la cual permita ingresar productos y listar todos los productos ingresados. La empresa le a proporcionado una vista previa de como desean que se vea y funcione la aplicación.

[] img 3

1.	Al agregar un elemento debe refrescar la lista automáticamente, además de informar que fue agregado exitosamente a través de un Toast.
2.	Es necesario controlar y validar que no se ingresen valores en blanco.
3.	El precio registrado debe ser mayor o igual que $1000
4.	Si se intenta registrar un producto de manera incorrecta debe informar a través de un Toast que no fue posible registrar el producto.

## 1.12 Guía 6 Mejarando lista de productos

La empresa dedicada al manejo de inventario que le había encargado una aplicación con anterioridad, le solicita que actualice el modelo, ya que, al registrar sobre 100 productos, ésta comienza a funcionar incorrectamente, por lo que es necesario actualizarla utilizando un RecyclerView. Además de esto, le piden agregar un botón limpiar que permita limpiar la lista completamente.

1.	Al agregar un elemento debe refrescar la lista automáticamente, además de informar que fue agregado exitosamente a través de un Toast.
2.	Es necesario controlar y validar que no se ingresen valores en blanco.
3.	El precio registrado debe ser mayor o igual que $1000
4.	Si se intenta registrar un producto de manera incorrecta debe informar a través de un Toast que no fue posible registrar el producto.
5.	Al limpiar la lista debe informar en un Toast que fue limpiada exitosamente.


## 1.14 Guía 7 Convertidor de Divisa

Usted a sido contactado por un familiar el cual le a solicitado si, puede crearle un convertidor de divisas con distintas divisas como Dólar, peso chileno, Euro, Yen, etc. El cuál debe ser una aplicación de Android para que él pueda utilizarlo cuando desee, sin la necesidad de tener internet.

[] img 4

1.	Debe permitir solo la conversión de números.
2.	Es necesario controlar y validar que no se ingresen valores en blanco.
3.	El valor por convertir debe ser mayor o igual que $0
4.	Al convertir un valor, este debe mostrarlo de alguna manera, ya sea en un toast, un textview, modificando el valor original.

## 2.3 SQLite

## 2.4 Guía 13
Lo han contactado para crear una app que permita registrar la asistencia de personas a un evento determinado, es necesario registrar el run, nombre y fecha de ingreso de las personas. Esta información debe ser almacenada en la base de datos interna del teléfono.

1.	La información de las personas que ingresan será su run, nombre y fecha de ingreso. El run debe ser único, por lo que no puede haber 2 personas registradas con el mismo run, en caso de duplicado, debe informar esta situación e impedir el registro.
2.	Todos los datos son obligatorios, por lo que no se debe permitir en ingreso de datos vacíos, además el run debe ser totalmente numérico, solicitando el dv de forma separada.
3.	Las personas asistentes deben ser almacenadas en la bd interna del teléfono.
4.	El registro de los asistentes se debe visualizar en un RecyclerView.

## 2.5 Guía 14
Un conocido le ha solicitado si puede crear una app que le ayude al momento de ir de compras al supermercado, la cual permita ingresar el nombre del producto, el precio y la cantidad. Dichos productos deben ser almacenados en la bd interna del teléfono, dándole al usuario la opción de eliminar o modificar los productos, registrados. Lo más importante que le solicitaron es que exista la opción de un botón que permita calcular el total a pagar según todos los productos registrados, además de la opción de limpiar todos los productos.

1.	Se requiere registrar el nombre, precio y cantidad de productos, verificando que no se ingresen valores vacíos, que la cantidad registrada al menos sea 1 y que el precio puede ser 0 o mayor, debido que puede ser gratis o una oferta.
2.	Al momento de eliminar un producto o de limpiar todos, debe solicitar la confirmación del usuario.
3.	La opción de modificar los productos debe aplicar las mismas reglas que al momento de registrarlos por primera vez.
4.	Puede calcular el total a pagar en tiempo real o al momento de presionar un botón o alguna forma que el usuario interactúe con el sistema.

