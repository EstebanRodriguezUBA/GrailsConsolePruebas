import test_1.*
///recordar clase creada aqui que no este en el domninio no se puede guardar en la session de Hibernate.
/*def p =new Puerta (name:"Lambo")
p.save(flush:true,failOnError:true)
p.dump()

//ATENCION: ESToy cometiendo un errro repetidamente newPuerta(NOMBRE!!!:algo).save()!!! mal el nombre del atributo y
//como usa !! save() !! sin failOnError NO muestra nada y NO guarda. PERO al usar este flag, MUESTRA ERROR DE VALIDACION !!! IMPORTANTE !!!
5.times {
    new Puerta(name:"Lambo ${it}").save()
}
*/
class Consultor{

Consultor() {
        def mc = new ExpandoMetaClass(Consultor, false, true)
        mc.initialize()
        this.metaClass = mc        
    }
    //recibe el nombre del metodo fantasma
def methodMissing(String name, args){
        println "Method missing is called"

        def cachedMethod = { Object[] varArgs ->
            println "Hi! ${varArgs}"
         
        }

        this.metaClass."${name}" = cachedMethod
        return cachedMethod(args)
    }
def consultar(String consulta,Object entidad,String atributo){

   // entidad.findBy${consulta}(atributo) //no funciona
//   entidad.findByName(atributo) //funciona OK
       entidad.findByName(atributo) //funciona OK
   
}
def consultar2(String consulta, Object entidad, String atributo){
  /*
   {->
   entidad.findBy${consulta}(atributo)
   } 
   */
  
   
  // esto devuelve un closure ,no funciona
}
/*
def methodMissing(String name, args) {
        // Intercept method that starts with find.

            // Add new method to class with metaClass.
            this.metaClass."findBy$name" = {-> " }
            result
        } else {
            throw new MissingMethodException(name, this.class, args)
        }
    }
   */ 
}
/*
println Puerta.get(1)
println "_____"
println Puerta.get(1).dump()
println "_____"
println Puerta.get(1).toString()
println "_____"
println Puerta.list()
println "_____"
println Puerta.dump()
println "_____"
println Puerta.toString()
*/
def consultor = new Consultor()
def objeto = consultor.consultar("Name",Puerta,"Lambo 2")
println objeto.getClass()
println objeto.toString()
println objeto.dump()
def segundo = consultor.consultar2("Name",Puerta,"Lambo 3")

segundo?.getClass()
//segundo.call()
consultor.groovy("hola","vecino",objeto)
consultor.grande(Puerta,"Name","Lambo 3")
