package cl.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ResponseRegistroClienteDto {
    private int id;
    private String correo;
}
