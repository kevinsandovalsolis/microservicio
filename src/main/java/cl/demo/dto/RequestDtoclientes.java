package cl.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class RequestDtoclientes {

    private List<Cliente> clientes;
}


