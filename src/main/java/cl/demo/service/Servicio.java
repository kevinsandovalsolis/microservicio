package cl.demo.service;


import cl.demo.dto.RequestDtoclientes;
import cl.demo.dto.ResponseDtoclientes;
import org.springframework.stereotype.Service;

@Service
public class Servicio {

    public ResponseDtoclientes ingresaCliente(RequestDtoclientes request){
        return ResponseDtoclientes.builder()
            .clientes(request.getClientes())
            .build();
    }
}
