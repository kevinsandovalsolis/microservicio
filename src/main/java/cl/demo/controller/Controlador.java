package cl.demo.controller;

import cl.demo.dto.ResponseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class Controlador {


    @GetMapping(value = "/demoget", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto getClienteFactoring() {
        return new ResponseDto("prueba");
    }

    @GetMapping("/ejemplo")
    public String getEjemplo(@RequestParam(required = false) String id, @RequestParam String name, @RequestParam String lastname) {
        return "ID: " + id + " nombre: " + name + " apellido: " + lastname;
    }

    @GetMapping("/ejemploptional")
    public String getEjemploptional(@RequestParam Optional<String> id) {
        return "ID: " + id.orElseGet(() -> "No provisto");
    }

    @GetMapping("/default")
    public String getDefault(@RequestParam(defaultValue = "prueba") String name) {
        return "nombre: " + name;
    }

    @PostMapping("/map")
    public String updateMap(@RequestParam Map<String,String> allParams) {
        return "Los parametros son: " + allParams.entrySet();
    }

    @PostMapping("/mapparam")
    public String updateMapparam(@RequestParam Map<String,String> allParams) {
        return "Parameters are " + allParams.entrySet();
    }

    @GetMapping("/multivalue")
    public String getMultivalue(@RequestParam List<String> names) {
        return "Nombres son " + names;
    }

}


