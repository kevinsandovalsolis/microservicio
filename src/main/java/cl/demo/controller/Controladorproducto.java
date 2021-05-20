package cl.demo.controller;

import cl.demo.dto.RequestDtoproductos;
import cl.demo.dto.ResponseDtoproductos;
import cl.demo.service.Servicioproducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controladorproducto {


    @Autowired
    private Servicioproducto servicioproducto;


    @GetMapping(value = "/obtenerProducto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDtoproductos obtenerProducto(@RequestParam String tipo_producto,Integer precio) {

        return servicioproducto.obtenerProducto(tipo_producto,precio);
    }


}
