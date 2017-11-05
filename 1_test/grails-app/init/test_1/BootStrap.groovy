package test_1

class BootStrap {

    def init = { servletContext ->
/*
      def nro = 0
    10.times {
            nro ++
            new Auto(name:"Ouch_${Auto.count() +1 }").save(failOnError:true)
//nota: en una oportunidad modifique la clase persona y puse una composicion de
//otra clase iniciador. cuando haga save(),salta error de que no puede ser null.

            def p = new Persona (nombre:"Pirulo_$nro")
            //notar que direccion se crea directamente como argumento
            //por lo tanto no debiera dar error por objeto transitorio.Creo
            //Creo porque se supone que se genera embebido en la misma tabla
p.localidad = new Localidad (nombre:"Barcelona",localidadActual:"loca_$nro",barrio:"evaristo")
p.localidad.direccion = new Direccion (nombre:"Evaristo__${nro}",calle:"Barcelona_${nro}",altura:nro*100)

            p.save(failOnError:true)
          }
/*
          def p = new Persona (nombre:"Pirulo_$nro")
          //nota illegalArgumentException porque en argumento no puse
          direccion:new Direccion bla bla bla
          p.localidad = new Localidad (nombre:"Barcelona",localidadActual:"loca_6",barrio:"zas",new Direccion (nombre:"Evaristo__${nro}",calle:"Barcelona_${nro}",altura:${nro * 100} ))

          p.save(failOnError:true)

          //def ok = Persona.findByLocalidad("zas")
          ok?.save(failOnError:true)
        /*  new Auto (name:"${Persona.findByLocalidad("evaristo")}")
            .save(failOnError:true)
            */
    }
    def destroy = {
    }
}
