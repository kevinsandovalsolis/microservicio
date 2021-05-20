package cl.demo.cliente;

import cl.demo.dto.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Arrays;

@Component
public class bdCliente {



    public List<Cliente> getClientes(){
        return Arrays.asList(
                Cliente.builder()
                        .telefono(111111111)
                        .rut("111")
                        .email("pedro.perez@gmail.com")
                        .nombre("Pedro")
                        .edad("30")
                        .direccion("calle 1")
                        .apellido("Perez")
                        .build(),
                Cliente.builder()
                        .telefono(222222222)
                        .rut("222")
                        .email("mariag@gmail.com")
                        .nombre("Maria")
                        .edad("20")
                        .direccion("calle 2")
                        .apellido("Gomez")
                        .build(),
                Cliente.builder()
                        .telefono(333333333)
                        .rut("333")
                        .email("juan@gmail.com")
                        .nombre("Juan")
                        .edad("35")
                        .direccion("calle 3")
                        .apellido("Muñoz")
                        .build(),
                Cliente.builder()
                        .telefono(444444444)
                        .rut("444")
                        .email("antonioa@gmail.com")
                        .nombre("Antonio")
                        .edad("32")
                        .direccion("calle 4")
                        .apellido("Aguila")
                        .build()
        );
    }
}
