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
*/
    @GetMapping(value = "/eliminarPedido", produces = MediaType.APPLICATION_JSON_VALUE)
    public Responseeliminarpedido eliminarPedido(@RequestParam Integer numero_pedido) {

        return serviciopedido.eliminar(numero_pedido);
    }


    @PostMapping(value = "/agregarPedido", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDtopedidos agregarPedido(@RequestBody RequestDtopedidos request) {

        return serviciopedido.ingresaPedido(request);

    }

}
