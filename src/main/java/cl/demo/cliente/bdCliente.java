package cl.demo.cliente;

import cl.demo.dto.bd.ClienteRegistroRequestDto;
import cl.demo.dto.bd.ClienteRegistroResponseDto;
import cl.demo.dto.bd.ClientesResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class bdCliente {


    @Autowired
    private RestTemplate restTemplate;

    private String urlmsBase="http://localhost:8083";
    private String endpointClienteGet="/obtenerCliente";
    private String endpointClienteAgregar="/registroCliente";



    public ClientesResponseDto getClientes(String correo){
        UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl(urlmsBase+endpointClienteGet)
                .queryParam("correo", correo);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity formEntity = new HttpEntity<>(headers);

        ResponseEntity<ClientesResponseDto> respuesta= restTemplate.exchange(url.toUriString(), HttpMethod.GET,formEntity,ClientesResponseDto.class);

        return respuesta.getBody();

    }

    public ClienteRegistroResponseDto registroCliente(ClienteRegistroRequestDto request){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity formEntity = new HttpEntity<>(request,headers);

        ResponseEntity<ClienteRegistroResponseDto> respuesta= restTemplate.exchange(urlmsBase+endpointClienteAgregar, HttpMethod.POST,formEntity,ClienteRegistroResponseDto.class);

        return respuesta.getBody();

    }
}
