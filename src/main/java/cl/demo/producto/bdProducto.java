package cl.demo.producto;

import cl.demo.dto.bd.ClientesResponseDto;
import cl.demo.dto.bd.ProductosResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class bdProducto {

    @Autowired
    private RestTemplate restTemplate;

    private String urlmsBase="http://localhost:8083";
    private String endpointProductoGet="/obtenerProducto";

    public ProductosResponseDto getProductos(String tipo_producto, Integer preciomin, Integer preciomax){
        UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl(urlmsBase+endpointProductoGet)
                .queryParam("tipo_producto", tipo_producto)
                .queryParam("preciomin", preciomin)
                .queryParam("preciomax", preciomax);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity formEntity = new HttpEntity<>(headers);

        ResponseEntity<ProductosResponseDto> respuesta= restTemplate.exchange(url.toUriString(), HttpMethod.GET,formEntity,ProductosResponseDto.class);

        return respuesta.getBody();

    }

}