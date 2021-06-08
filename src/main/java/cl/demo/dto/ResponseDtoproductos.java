package cl.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ResponseDtoproductos {

    private ProductoResponse productoResponses;
    //private List<Producto> productos;

}
