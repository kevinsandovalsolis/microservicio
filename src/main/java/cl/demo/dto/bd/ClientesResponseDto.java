package cl.demo.dto.bd;


import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientesResponseDto {


    private List<Cliente> clientes;

}
