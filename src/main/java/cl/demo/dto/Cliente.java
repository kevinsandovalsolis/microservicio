package cl.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
public class Cliente {
    private String nombre;
    private String apellido;
    private String rut;
    private String edad;
    private String email;
    private Integer telefono;
    private String direccion;
}
