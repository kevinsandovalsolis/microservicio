package cl.demo.dto.bd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    private Integer id_producto;
    private String tipo_producto;
    private String descripcion;
    private Integer precio;
    private Integer stock;
}
