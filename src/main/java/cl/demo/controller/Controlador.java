package cl.demo.controller;

import cl.demo.dto.ResponseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {




    @GetMapping(value = "/demoget", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto getClienteFactoring() {
        return new ResponseDto("prueba");
    }
}
