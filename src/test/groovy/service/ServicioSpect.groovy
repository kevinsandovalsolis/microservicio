import cl.demo.cliente.bdCliente
import cl.demo.dto.Pedido

import cl.demo.dto.RequestDtoclientes
import cl.demo.dto.RequestDtopedidos
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
        serviciocl.clienteBD= new bdCliente()

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

    def "filtrar clientes"(){
        given:"Lista de clientes"


        when:"quiero buscar un prodcuto"
        def respuesta=serviciocl.obtenerCliente(nombre)

        then:"se retorna el cliente filtrado"
        respuesta.getClientes().size()==registros

        where:
        nombre|registros
        "Pedro"|1

    }

    def "eliminar pedido"(){
        given:"Lista de pedidos"


        when:"quiero buscar un prodcuto"
        def respuesta=serviciopd.eliminar(id)

        then:"se retorna el cliente filtrado"
        respuesta.isEliminado()==valorrespuesta

        where:
        id|valorrespuesta
        654|true
        100|false




    }



}