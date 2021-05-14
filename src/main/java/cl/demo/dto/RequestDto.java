package cl.demo.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
public class RequestDto {

    private String nombre;
    private String apellido;
}
