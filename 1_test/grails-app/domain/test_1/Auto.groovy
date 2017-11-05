package test_1
import test_1.Puerta
class Auto {
String name
static hasMany = [puertas:Puerta]
    static constraints = {

    }
    static mapping = {
       puertas cascade: 'all-delete-orphan'
    }
}
