import cl.demo.service.Serviciocliente
import spock.lang.Specification

class ServicioSpect extends Specification{

    Serviciocliente serviciocl=Mock()

    def setup(){
        serviciocl=new Serviciocliente();

    }

    def "Ingresar cliente"(){
        given : "una lista de pedidos del cliente"

        when : "se solicita ingrear el cliente"
        def respuesta=serviciocl.ingresaCliente(juan)

        then: "se ingresa el cliente"
        respuesta
    }

}