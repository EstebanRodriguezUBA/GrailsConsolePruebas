import test_1.*
def iniciador = new Iniciador(nombre:"miproyecto@fiuba.org",claveAcceso:"012345678")
def primerCuenta = new Persona (iniciador:iniciador)
//cualquier propiedad aunque tenga valores primitivos como string, por defecto es nullable:false, entonces salta excepcion.
//AL PERSISTIRLO. SINO NI MUU!!!!
/**
*Ejemplo
println primerCuenta.dump()

<test_1.Persona@9dc16f nombre=null iniciador=test_1.Iniciador@f8627c localidad=null id=null version=null followed=null
 org_grails_datastore_mapping_dirty_checking_DirtyCheckable__$changedProperties=null
 org_grails_datastore_gorm_GormValidateable__errors=grails.validation.ValidationErrors: 0 
 errors org_grails_datastore_gorm_GormValidateable__skipValidate=false>
 
 println personaSinParametros.dump()
 TODOS los parametros NULL

<test_1.Persona@12adb99 nombre=null iniciador=null localidad=null id=null version=null followed=null 
org_grails_datastore_mapping_dirty_checking_DirtyCheckable__$changedProperties=null 
org_grails_datastore_gorm_GormValidateable__errors=null org_grails_datastore_gorm_GormValidateable__skipValidate=false>
*
**/

//caso de persona sin parametros
def personaSinParametros = new Persona ()
//ANTES PERSISTIR
//println primerCuenta.dump()//toString()
//println personaSinParametros.dump()//toString()
//primerCuenta?primerCuenta.save(failOnError: true): {println "primerCuenta: ${primerCuenta}"}//lanza excepcion porque Persona.nombre==null 
println "********Persona con parametros no null excepto los nullable:true*********"
println 'EJEMPLO: def persona_1 = new Persona(iniciador:iniciador,nombre:"Eustaquio")'
println "parametros como mapa -ok"
def persona_1 = new Persona(iniciador:iniciador,nombre:"Eustaquio")
//println persona_1.dump()
/**
<test_1.Persona@5b9d94 nombre=Eustaquio iniciador=test_1.Iniciador@1627294 localidad=null id=null version=null followed=null org_grails_datastore_mapping_dirty_checking_DirtyCheckable__$changedProperties=null org_grails_datastore_gorm_GormValidat
*/
println "parametroas al reves, como mapa -ok"
def persona_2 = new Persona(nombre:"Eorlindo",iniciador:iniciador)
//println persona_2.dump()
/**
<test_1.Persona@5f5202 nombre=Eorlindo iniciador=test_1.Iniciador@1627294 localidad=null id=null version=null followed=null org_grails_datastore_mapping_dirty_checking_DirtyCheckable__$changedProperties=null org_grails_datastore_gorm_GormValidateable__errors=grails.validation.ValidationErrors: 0 errors org_grails_datastore_gorm_GormValidateable__skipValidate=false>
*/
println "parametros not Map - LANZA EXCEPCION xq NO pudo matchear"
/*Could not find matching constructor for: test_1.Persona(java.lang.String, test_1.Iniciador)*/
//def persona_3 = new Persona("Eorlindo",iniciador)
//println persona_3.dump()

println "parametros not Map , reverse - LANZA EXCEPCION -NO Pudo matchear"
/*GroovyRuntimeException: Could not find matching constructor for: test_1.Persona(test_1.Iniciador, java.lang.String)*/
//def persona_4 = new Persona(iniciador,"Eorlindo")
//println persona_4.dump()
println "*************************"
println "ATENCION !!! EL operador ELVIS NO IMPRIME, ---Y TAMPOCO RETORNA VALOR---, NO ES LO MISMO QUE IF ELSE THEN cuidado!!!"
def resultado = persona_2.save(failOnError:true)?{println "se guardo OK"}:{println "No se guardo"}
println "VALOR RETORNO ELVIS: ${resultado}"
if(persona_2.save(failOnError:true))
{println "IF se guardo OK"}
println Persona.list()
//println Persona.list().dump()
def valor = true
resultado = valor?{println "entra verdadero"}:{ println "entra falso"}
println "VALOR RETORNO ELVIS: ${resultado}"
println "*******************************************************************"
println "Probando modificacion de valor en Operador Elvis"
valor = 100
def valor_comparable = 50
resultado = (valor_comparable <= 200)?{ valor= 150}:{valor=300}
println "Resultado ELVIS: ${resultado}"
println "Resultado ELvis:modificacion de valor variable : ${valor} ES EXITOSO"
resultado = (valor_comparable <= 200)?{ 150}:{300}
println "Resultado ELvis:retorno de valor(no operacion realizada en closure) : ${resultado} FRACASA"
resultado = (valor_comparable <= 200)?{ 
valor = 150
valor}:{valor = 300}
println "Resultado ELvis:retorno de valor(retornando variable asignada):${resultado} FRACASA"
println "*******************************************************************"
println "*************************"
println "Resolviendo problemas de constraints en persistencia con propiedad compuesta y requisito uniqe y validator"
