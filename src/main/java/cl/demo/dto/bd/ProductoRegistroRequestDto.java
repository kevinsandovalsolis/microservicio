package cl.demo.dto.bd;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductoRegistroRequestDto {

    private String tipo_producto;
    private String descripcion;
    private Integer precio;
    private Integer stock;

}
