package cl.demo.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Setter
@Getter
public class RequestDto {

    private List<Cliente> clientes;
    private List<Producto> productos;
}


