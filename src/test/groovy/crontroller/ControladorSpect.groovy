package crontroller

import cl.demo.controller.Controladorcliente
import cl.demo.controller.Controladorpedido
import cl.demo.dto.Cliente
import cl.demo.dto.Pedido
import cl.demo.dto.RequestDtopedidos
import cl.demo.dto.ResponseDtoclientes
import cl.demo.dto.ResponseDtopedidos
import cl.demo.service.Serviciocliente
import cl.demo.service.Serviciopedido
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



    void setup(){
        controladorcl=new Controladorcliente()
        controladorcl.serviciocliente=serviciocl

        controladorpd=new Controladorpedido()
        controladorpd.serviciopedido=serviciopd

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

    def "agregar pedido"(){
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
        respuesta.getNumero_pedidos()=="1"
    }

}
