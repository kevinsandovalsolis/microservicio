package cl.demo.dto.bd;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRegistroRequestDto {

    private String nombre;
    private String apellido;
    private String correo;
    private String region;
    private String comuna;
    private String calle;

}
