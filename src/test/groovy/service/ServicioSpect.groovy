import cl.demo.dto.Cliente
import cl.demo.dto.Pedido
import cl.demo.dto.Producto
import cl.demo.dto.RequestDtoclientes
import cl.demo.dto.RequestDtopedidos
import cl.demo.dto.ResponseDtoclientes
import cl.demo.dto.ResponseDtopedidos
import cl.demo.service.Serviciocliente
import cl.demo.service.Serviciopedido
import cl.demo.service.Servicioproducto
import spock.lang.Specification

class ServicioSpect extends Specification{

    Serviciocliente serviciocl=Mock()
    Serviciopedido serviciopd=Mock()
    Servicioproducto serviciopr=Mock()

    def setup(){
        serviciocl=new Serviciocliente()
        serviciopd=new Serviciopedido();
        serviciopr=new Servicioproducto();

    }

    def "Ingresar cliente"(){
        given : "una lista de pedidos del cliente"
        RequestDtoclientes request=RequestDtoclientes.builder().build();

        when : "se solicita ingrear el cliente"
        def respuesta=serviciocl.ingresaCliente(request)

        then: "se ingresa el cliente"
        respuesta
    }

    def "ingresa pedido"(){
        given:"Lista de productos para un pedido"
        RequestDtopedidos request=RequestDtopedidos.builder().build()

        when:"quiero ingresar un pedido"
        def respuesta=serviciopd.ingresaPedido(request)

        then:"se ingresa el pedido y se retorna un id de pedido"
        respuesta
    }

    /*
    def "obtener cliente"(){
        given:"un nombre de cliente"
        def nombre="Juan"
        serviciocl.obtenerCliente(_) >> ResponseDtoclientes.builder()
                .clientes(Arrays.asList(Cliente.builder().nombre("juan").build()))
                .build()
        when: "se procesa solicitud"
        def respuesta=serviciocl.obtenerCliente("Juan")

        then: "respuesta"
        respuesta.getClientes().size()==1 && respuesta.getClientes().get(0).getNombre()=="juan"
    }
    */
}