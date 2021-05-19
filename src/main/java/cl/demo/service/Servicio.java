package cl.demo.service;


import cl.demo.cliente.bdCliente;
import cl.demo.dto.Cliente;
import cl.demo.dto.RequestDtoclientes;
import cl.demo.dto.ResponseDtoclientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Servicio {

    @Autowired
    private bdCliente clienteBD;

    public ResponseDtoclientes ingresaCliente(RequestDtoclientes request){
        return ResponseDtoclientes.builder()
            .clientes(request.getClientes())
            .build();
    }


    public ResponseDtoclientes obtenerCliente(String nombre){
        List<Cliente> clientes=clienteBD.getClientes();
        return ResponseDtoclientes.builder().clientes(clientes).build();
    }
}
