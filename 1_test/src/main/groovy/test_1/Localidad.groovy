package test_1

class Localidad {
  String nombre
  String localidadActual
  String barrio
  Direccion direccion
  static embedded = ['direccion']
    static constraints = {
    }
}
