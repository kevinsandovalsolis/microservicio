package crontroller

import cl.demo.controller.Controladorcliente
import cl.demo.controller.Controladorpedido
import cl.demo.controller.Controladorproducto
import cl.demo.dto.Cliente
import cl.demo.dto.Pedido

import cl.demo.dto.RequestDtoclientes
import cl.demo.dto.RequestDtopedidos
import cl.demo.dto.ResponseDtoclientes
import cl.demo.dto.ResponseDtopedidos
import cl.demo.dto.ResponseDtoproductos
import cl.demo.dto.Responseeliminarpedido
import cl.demo.service.Serviciocliente
import cl.demo.service.Serviciopedido
import cl.demo.service.Servicioproducto
import spock.lang.Specification

/**
 * 
 *Test Service 
 * 
 *@author: kevin sandoval
 */
class ControladorSpect extends Specification {

    Controladorcliente controladorcl

    Serviciocliente serviciocl=Mock()

    Controladorpedido controladorpd

    Serviciopedido serviciopd=Mock()

    Controladorproducto controladorpr

    Servicioproducto serviciopr=Mock()



    void setup(){
        controladorcl=new Controladorcliente()
        controladorcl.serviciocliente=serviciocl

        controladorpd=new Controladorpedido()
        controladorpd.serviciopedido=serviciopd

        controladorpr=new Controladorproducto()
        controladorpr.servicioproducto=serviciopr

    }

    def "obtener cliente"(){
        given:"un nombre de cliente"
        def nombre="Juan"
        serviciocl.obtenerCliente(_) >> ResponseDtoclientes.builder()
                .clientes(Arrays.asList(Cliente.builder().nombre("juan").build()))
                .build()
        when: "se procesa solicitud"
        def respuesta=controladorcl.obtenerCliente("Juan")

        then: "respuesta"
        respuesta.getClientes().size()==1 && respuesta.getClientes().get(0).getNombre()=="juan"
    }

    def "ingresa pedido"(){
        given:"Lista de productos para un pedido"
        RequestDtopedidos request=RequestDtopedidos.builder()
                .pedidos(Arrays.asList(Pedido.builder()
                        .estado("estado de prueba")
                        .build()))
                .build();

        serviciopd.ingresaPedido(_) >> ResponseDtopedidos.builder()
                .estado("1")
                .build()

        when:"quiero ingresar un pedido"
        def respuesta=controladorpd.agregarPedido(request)

        then:"se ingresa el pedido y se retorna un id de pedido"
        respuesta.getEstado()=="1"
    }

    def "registro cliente"(){
        given:"Lista de datos para un cliente"
        RequestDtoclientes request=RequestDtoclientes.builder()
                .clientes(Arrays.asList(Cliente.builder()
                        .rut("rut de prueba")
                        .build()))
                .build();

        serviciocl.ingresaCliente(_) >> ResponseDtoclientes.builder()
                .rut("9999999")
                .build()

        when:"quiero ingresar un cliente"
        def respuesta=controladorcl.registroCliente(request)

        then:"se ingresa el cliente y se retorna un rut"
        respuesta.getRut()=="9999999"
    }

    def "filtrar producto"(){
        given:"un tipo de prodcuto"
        def tipo_producto="Prueba",preciomin=11111,preciomax=22222
        serviciopr.obtenerProducto(_,_,_) >> ResponseDtoproductos.builder()
                  .productos(Arrays.asList(Producto.builder()
                          .tipo_producto("prueba")
                          .precio(55555)
                          .build()))
                .build()
        when: "se procesa solicitud"
        def respuesta=controladorpr.obtenerProducto("Prueba",11111,22222)

        then: "respuesta"
        respuesta.getProductos().get(0).getTipo_producto()=="prueba"

    }

    def "eliminar pedido"(){
        given:"un numero de pedido"
        serviciopd.eliminar(_) >> Responseeliminarpedido.builder().build()

        when: "se procesa solicitud"
        def respuesta=controladorpd.eliminarPedido(654)

        then: "respuesta true si el pedio fue eliminado"
        respuesta.setEliminado(true)

    }

}
