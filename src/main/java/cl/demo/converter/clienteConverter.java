package cl.demo.converter;

import cl.demo.dto.ClienteResponse;
import cl.demo.dto.RequestDtoclientes;
import cl.demo.dto.bd.Cliente;
import cl.demo.dto.bd.ClienteRegistroRequestDto;
import org.springframework.stereotype.Component;

@Component
public class clienteConverter {


    public ClienteResponse getClienteBD(Cliente cliente){
        return ClienteResponse.builder()
                .nombre(cliente.getNombre()+" "+cliente.getApellido())
                .direccion(cliente.getRegion()+"-"+cliente.getComuna()+"-"+cliente.getCalle())
                .build();

    }

    public ClienteRegistroRequestDto getClienteIngesarBD(RequestDtoclientes cliente){
        return ClienteRegistroRequestDto.builder()
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .comuna(cliente.getComuna())
                .region(cliente.getRegion())
                .calle(cliente.getCalle())
                .correo(cliente.getCorreo())
                .build();

    }
}
