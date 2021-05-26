package cl.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Setter
@Getter
@Builder
public class RequestDtoclientes {

    private List<Cliente> clientes;
}


