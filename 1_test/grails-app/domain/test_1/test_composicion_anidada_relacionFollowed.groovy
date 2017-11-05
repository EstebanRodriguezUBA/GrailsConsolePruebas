import test_1.*
/*
println Persona.count()
//tabla no creada println Localidad.count()
println "***************"
println Persona.get(1).dump()
println "***************"
println Persona.get(1).localidad.dump()
println "***************"
println Persona.get(1).localidad.direccion.dump()
println "***************"
println Persona.get(1).localidad.direccion.getClass()
// falla println Persona.get(1).localidad.direccion.findByCalle("Barcelona_5").dump()
//println Persona.get(1).inspect()
println "***************"
//println Persona.get(1).toString()
println "***************"
*/
println Persona.findByNombre("Pirulo_2")?.localidad.dump()
def local = Persona.findByNombre("Pirulo_2")?.localidad
def direc = Persona.findByNombre("Pirulo_2")?.localidad.direccion
println local.dump()
println direc.dump()
println "***************"
//la busqueda es por objetos completos en composicion
println Persona.findByLocalidad(local)?.dump()
println "--------------------------------------------------------"
println Persona.findByDireccion(direc).dump()
println "***************"
/*el primer argumento es un object, una instancia de Localizacion*/
println Persona.findByDireccionAndCalle(direc,"Barcelona_3")?.dump() //no sirve direc= null
println "***************"
println Persona.findByCalle("Barcelona_3")?.dump() //no sirve direc= null
println Persona.findByAltura(700)?.dump()
//importante las propiedades anidadas no se puede repetir el nombre porque no encuentra
println Persona.findByNombre(null,"Evaristo_2")?.dump()
println Localidad.getClass()
println "***************"
println Persona.findByBarrio("barrio")?.localidad?.direccion?.dump()
println Persona.findByBarrio("barrio")?.localidad?.direccion?.dump()
println Persona.findByBarrio("barrio")?.localidad?.direccion?.dump()
println Persona.findByBarrioAndCalle("evaristo", "Barcelona_3").dump()
println Persona.findByBarrioAndCalle("evaristo", "Barcelona_3").dump()

/**************RESPUESTA AL FIIIINNN: como consultar a objetos anidados, embebidos,composicion cuando tienen el nombre de una
propiedad que se llama igual*******************/
println Persona.findByDireccionAndNombre(new Direccion(), "Evaristo__3")?.localidad?.direccion?.dump()
/*******--------------------------------------------------*******************/
println "***************"
println "***************"
println "***************"
