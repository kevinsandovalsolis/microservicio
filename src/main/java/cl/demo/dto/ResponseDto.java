package cl.demo.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
public class ResponseDto {

    private String nombre;
    private String apellido;
    private LocalDate fecha;


    private List<Auto> autos;
}
