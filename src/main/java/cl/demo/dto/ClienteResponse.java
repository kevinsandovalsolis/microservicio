package cl.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@Builder
@Getter
@Setter
public class ClienteResponse {
    private String nombre;
    private String direccion;
}
