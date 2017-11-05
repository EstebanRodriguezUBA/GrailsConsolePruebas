package test_1

class Persona {
  String nombre
  Iniciador iniciador
//followed
 static hasMany = [followed:Persona]
//composicion con clase compuesta en src/---/test_1

  Localidad localidad
  static embedded = ['localidad','iniciador']
    static constraints = {
      localidad nullable:true
    }
}
