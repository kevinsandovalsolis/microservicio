package cl.demo.controller;

import cl.demo.constantes.Constantes;
import cl.demo.dto.RequestDto;
import cl.demo.dto.ResponseDto;
import cl.demo.service.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class Controlador {


    @Autowired
    private Servicio  servicio;

    @PostMapping(value = "/registroCliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto metodo(@RequestBody RequestDto request) {
        return servicio.ingresaCliente(request);
    }


}


