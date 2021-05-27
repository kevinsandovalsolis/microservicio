import cl.demo.dto.Cliente
import cl.demo.dto.Pedido
import cl.demo.dto.Producto
import cl.demo.dto.RequestDtoclientes
import cl.demo.dto.RequestDtopedidos
import cl.demo.dto.RequestDtoproductos
import cl.demo.dto.ResponseDtoclientes
import cl.demo.dto.ResponseDtopedidos
import cl.demo.pedido.bdPedido
import cl.demo.producto.bdProducto
import cl.demo.service.Serviciocliente
import cl.demo.service.Serviciopedido
import cl.demo.service.Servicioproducto
import spock.lang.Specification
import spock.lang.Unroll

class ServicioSpect extends Specification{

    Serviciocliente serviciocl
    Serviciopedido serviciopd
    Servicioproducto serviciopr

    def setup(){
        serviciocl=new Serviciocliente()
        serviciopd=new Serviciopedido()
        serviciopr=new Servicioproducto()
        serviciopd.pedidoBD= new bdPedido()
        serviciopr.productoBD= new bdProducto()

    }

    def "Ingresar cliente"(){
        given : "una lista de pedidos del cliente"
        RequestDtoclientes request=RequestDtoclientes.builder().build();

        when : "se solicita ingrear el cliente"
        def respuesta=serviciocl.ingresaCliente(request)

        then: "se ingresa el cliente"
        respuesta
    }
   @Unroll
    def "ingresa pedido"(){
        given:"Lista de productos para un pedido"
        RequestDtopedidos request=valorrequest

        when:"quiero ingresar un pedido"
        def respuesta=serviciopd.ingresaPedido(request)

        then:"se ingresa el pedido y se retorna un id de pedido"
        respuesta
        where:
        valorrequest|a
        RequestDtopedidos.builder()
                .pedidos(new ArrayList<Pedido>())
                .build()|22
        RequestDtopedidos.builder()
                .pedidos(Arrays.asList(Pedido.builder().build()))
                .build()|22

    }

    def "filtrar productos"(){
    given:"Lista de prodcutos"


    when:"quiero buscar un prodcuto"
    def respuesta=serviciopr.obtenerProducto(tipojuego,minimo,maximo)

    then:"se retorna el producto filtrado"
    respuesta.getProductos().size()==registros

    where:
    tipojuego|minimo|maximo|registros
    "juego"|11111|22222|2
    "juego"|16000|22222|1

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