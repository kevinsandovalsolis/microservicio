package crontroller

import cl.demo.controller.Controladorcliente
import cl.demo.dto.Cliente
import cl.demo.dto.ResponseDtoclientes
import cl.demo.service.Serviciocliente
import spock.lang.Specification

/**
 * 
 *Test Service 
 * 
 *@author: kevin sandoval
 */
class ControladorSpect extends Specification {

    Controladorcliente controlador

    Serviciocliente servicio=Mock()



    void setup(){
        controlador=new Controladorcliente()
        controlador.serviciocliente=servicio
    }

    def "obtener cliente"(){
        given:"un nombre de cliente"
        def nombre="Juan"
        servicio.obtenerCliente(_) >> ResponseDtoclientes.builder()
                .clientes(Arrays.asList(Cliente.builder().nombre("juan").build()))
                .build()
        when: "se procesa solicutud"
        def respuesta=controlador.obtenerCliente("Juan")

        then: "respuesta"
        respuesta.getClientes().size()==1 && respuesta.getClientes().get(0).getNombre()=="juan"
    }


}
