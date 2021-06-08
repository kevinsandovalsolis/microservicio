package cl.demo.dto.bd;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private Integer cliente_id;
    private String nombre;
    private String apellido;
    private String correo;
    private String region;
    private String comuna;
    private String calle;
}
