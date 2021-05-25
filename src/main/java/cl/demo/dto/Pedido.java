package cl.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Pedido {

    private Integer numero_pedido;
    private Integer cliente_id;
    private String nombre_cliente;
    private String calle;
    private String ciudad;
    private String fecha_envio;
    private Integer producto_id;
    private String hora_de_empaquetado;
    private Integer cantidad_comprada;
    private String estado;


}
