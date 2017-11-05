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
