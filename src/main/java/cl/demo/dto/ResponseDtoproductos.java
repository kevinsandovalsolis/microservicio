package cl.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ResponseDtoproductos {

    private List<Producto> productos;

}
