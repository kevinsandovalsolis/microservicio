package cl.demo.dto.bd;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductosResponseDto {

    private List<Producto> productos;
}
