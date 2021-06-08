package cl.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Setter
@Getter
@Builder
public class RequestDtoclientes {

    private String nombre;
    private String apellido;
    private String correo;
    private String region;
    private String comuna;
    private String calle;
}


