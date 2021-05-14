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

    @GetMapping(value = "/demoget", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto getClienteFactoring() {
        return ResponseDto.builder().build();
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
        return "os parametros son: " + allParams.entrySet();
    }

    @GetMapping("/multivalue")
    public String getMultivalue(@RequestParam List<String> names) {
        return "Nombres son " + names;
    }

    @PostMapping(value = "/demopost", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto metodo(@RequestBody RequestDto request) {
        return servicio.metodo1(request);
    }


}


