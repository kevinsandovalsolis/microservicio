package cl.demo.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Producto {
    private Integer id_producto;
    private String tipo_producto;
    private String descripcion;
    private String precio;
    private Integer stock;
}
