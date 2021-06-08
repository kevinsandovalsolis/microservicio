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
                //junta nombre y apellido para mostrar un nombre completo
                .direccion(cliente.getRegion()+"-"+cliente.getComuna()+"-"+cliente.getCalle())
                //junta region, comuna y calle para mostrar una direccion completa
                .build();

    }

    public ClienteRegistroRequestDto getClienteIngresarBD(RequestDtoclientes cliente){
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
