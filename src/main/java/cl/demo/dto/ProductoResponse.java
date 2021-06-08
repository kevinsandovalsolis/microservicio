package cl.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProductoResponse {
    private String tipo;
    private Integer costo;
}
