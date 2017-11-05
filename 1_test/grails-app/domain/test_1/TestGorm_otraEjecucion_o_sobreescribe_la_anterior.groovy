import test_1.Auto
import test_1.Puerta

def a= new Auto(name:"Ouch!")

/******************************/
//no se puede salvar esta clase creada aqui mismo, no permite usar Gorm a menos que la cree en al carpeta de Entidades
/*
class Car{
String name
}
def c= new Car(name:"AUTO ingles")
*/
/*********************************/
def puerta = null
1.times {nro ->
// puerta = new Puerta (name:"Puerta nro : ${nro}").save()
 }
//a.save()
//assert a.hasErrors() == false

//a.addToPuertas(puerta)//OJO es PUERTAS no PUERTA, va en PLURAL
/***********************************/

println "Filas en tabla AUTO : ${Auto.count()}  en PUERTA: ${Puerta.count()}"
/*
def puertaA= Puerta.get (29)
def puertaB= Puerta.get (32)
*/
def autito = Auto.get(12)

/*
autito
    .addToPuertas(puertaA)
    .addToPuertas(puertaB)
*/
/*Borrando Auto y se tienen que borrar sus puertas porque esta seteado en cascada*/
autito.delete(flush:true)//Esto no funciono porque al momento tenia ningun belong en clase children pero esta seteado delete all orphan. VERIFICAR!!
//DA ERROR SI ID es INCORRECTO
/*************************/
Auto.findAll().collect() {
    println "Nombre de auto: ${it?.name} ID: ${it.id} "
    println "Sus Puertas son"
    println "${it.get(it.id).puertas.asList()}"
 //  it.delete(flush:true)//al ejecutar esto la siguiente sentencia list muestra '[]' porque se vacio la base de datos. PERO LA DBASe esta en UPDATE porlo que no
   //reutiliza los ID y al momento de probarlo sigue generando nuevas instancias con ID incremental desde donde quedo, en este caso id:32
}
Puerta.findAll().collect(){
 //   it.delete(flush:true)
}


//a medida que ejecuto LA BASE DE DATOS ESTA EN UPDATE O SEA QUE SE ACUMULA NO SE BORRA IMPORTANTE!!!
println "CONTENIDO DE LA TABLA -list()-AUTO"
println Auto.list()
println Puerta.list()

//c.save() ESTO NO SE PUEDE
