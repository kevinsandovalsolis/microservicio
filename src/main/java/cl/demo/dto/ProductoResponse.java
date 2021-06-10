package cl.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProductoResponse {

    private Integer id_producto;
    private String tipo_producto;
    private String descripcion;
    private Integer precio;

}
