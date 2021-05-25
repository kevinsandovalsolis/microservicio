package cl.demo.controller;

import cl.demo.dto.*;
import cl.demo.service.Serviciopedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controladorpedido {

    @Autowired
    private Serviciopedido serviciopedido;




    /*
    @PostMapping(value = "/registroPedido", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDtopedidos metodo(@RequestBody RequestDtopedidos request) {

        return serviciopedido.ingresaPedido(request);
    }

    /*
    @GetMapping(value = "/añadirPedido", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDtopedidos añadirPedido(@RequestParam Integer numero_pedido, Integer cliente_id, String nombre_cliente,String calle,String ciudad,String fecha_envio, Integer producto_id,String hora_de_empaquetado,Integer cantidad_comprada,String estado) {

        return serviciopedido.añadirPedido(numero_pedido,cliente_id,nombre_cliente,calle,ciudad,fecha_envio,producto_id,hora_de_empaquetado,cantidad_comprada,estado);
    }


    @GetMapping(value = "/eliminarPedido", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDtopedidos eliminarPedido(@RequestParam Integer numero_pedido) {

        return serviciopedido.eliminarPedido(numero_pedido);
    }

     */

    @PostMapping(value = "/agregarPedido", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDtopedidos metodo(@RequestBody RequestDtopedidos request) {

        return serviciopedido.ingresaPedido(request);
    }

}
