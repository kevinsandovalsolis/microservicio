package cl.demo.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Producto {
    private Integer id_producto;
    private String tipo_producto;
    private String descripcion;
    private String precio;
    private Integer stock;
}
