package net.sebaorrego.evaluacion2


class Producto(var idProducto: Int, var nombre: String,
               var cantidadDisponible: Int =1, var precioSinIva : Double=0.0,
               var precioConIva : Double=0.0, var PrecioDolar: Double=0.0,
               var idProveedor: Int, var idCategoria: Int, var estado: Int=1)