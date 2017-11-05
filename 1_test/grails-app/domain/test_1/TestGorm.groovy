import test_1.Auto
import test_1.Puerta

def a= new Auto(name:"Ouch!")

/******************************/
//no se puede salvar esta clase creada aqui mismo, no permite usar Gorm a menos que la cree en al carpeta de Entidades
class Car{
String name
}
def c= new Car(name:"AUTO ingles")
/*********************************/

5.times {nro ->
 new Puerta (name:"Puerta nro : ${nro}").save()
 }
a.save()
assert a.hasErrors() == false


/***********************************/

println "Filas en tabla AUTO : ${Auto.count()}  en PUERTA: ${Puerta.count()}"
println "Hola"

Auto.findAll().collect() {
    println "Nombre de auto: ${it?.name} ID: ${it.id}"
   //it.delete(flush:true)//al ejecutar esto la siguiente sentencia list muestra '[]' porque se vacio la base de datos. PERO LA DBASe esta en UPDATE porlo que no 
   //reutiliza los ID y al momento de probarlo sigue generando nuevas instancias con ID incremental desde donde quedo, en este caso id:32
}
//a medida que ejecuto LA BASE DE DATOS ESTA EN UPDATE O SEA QUE SE ACUMULA NO SE BORRA IMPORTANTE!!!
 
println Auto.list()
//c.save() ESTO NO SE PUEDE

/*
LIMPIANDO BASE DE DATOS, se COMENTA CADA TANTO PARA PROBAR SAVE u oTRO Metodo GORM
*/
//_______________AQUI_PONER_____________
/*
class Person{
String name
Pierna pierna
Nariz nariz
String toString(){

    "this.class : $name pierna: pierna.$name nariz: $nariz.name" 

}
}
class Pierna{
String name
}
class Nariz {
String name
}

Closure cantTable={
    
    println "Persona: ${Persona.count()} \
    Pierna: ${Pierna.count()} \
    Nariz: ${Nariz.count()}"
}
//cantTable.call()
def nariz = new Nariz(name:"narizota")
//Nariz.count()
println "Hi!!"
println "${nariz.name}"
nariz.class

nariz.save()
*/