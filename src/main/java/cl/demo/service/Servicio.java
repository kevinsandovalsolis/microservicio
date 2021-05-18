package cl.demo.service;


import cl.demo.dto.RequestDto;
import cl.demo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Servicio {

    public ResponseDto ingresaCliente(RequestDto request){
        return ResponseDto.builder()
            .clientes(request.getClientes())
            .build();
    }
}
