package cl.demo.controller;

import cl.demo.dto.RequestDtoclientes;
import cl.demo.dto.ResponseDtoclientes;
import cl.demo.service.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador {


    @Autowired
    private Servicio  servicio;

    @PostMapping(value = "/registroCliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDtoclientes metodo(@RequestBody RequestDtoclientes request) {

        return servicio.ingresaCliente(request);
    }

    @GetMapping(value = "/obtenerCliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDtoclientes obtenerCliente(@RequestParam String nombre) {

        return servicio.obtenerCliente(nombre);
    }


}


