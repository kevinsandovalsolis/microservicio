package cl.demo.controller;

import cl.demo.dto.RequestDtoclientes;
import cl.demo.dto.ResponseDtoclientes;
import cl.demo.service.Serviciocliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controladorcliente {


    @Autowired
    private Serviciocliente serviciocliente;

    @PostMapping(value = "/registroCliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDtoclientes registroCliente(@RequestBody RequestDtoclientes request) {

        return serviciocliente.ingresaCliente(request);
    }

    @GetMapping(value = "/obtenerCliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDtoclientes obtenerCliente(@RequestParam String nombre) {

        return serviciocliente.obtenerCliente(nombre);
    }



}


