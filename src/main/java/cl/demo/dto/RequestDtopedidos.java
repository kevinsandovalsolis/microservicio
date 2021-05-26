package cl.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class RequestDtopedidos {

    private List<Pedido> pedidos;

}
