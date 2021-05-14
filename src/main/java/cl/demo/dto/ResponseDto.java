package cl.demo.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ResponseDto {

    private String nombre;
    private String apellido;

    public ResponseDto(String x,String z){
        nombre=x;
        apellido=z;
    }

}
