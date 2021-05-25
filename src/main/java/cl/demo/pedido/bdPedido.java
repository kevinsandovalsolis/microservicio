package cl.demo.pedido;

import cl.demo.dto.Pedido;
import cl.demo.dto.Producto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class bdPedido {

    public List<Pedido> getPedidos(){
        return Arrays.asList(//as list no deja eliminar y agregar objetos a la lista
                Pedido.builder()
                        .numero_pedido(654)
                        .cliente_id(3)
                        .nombre_cliente("Pablo")
                        .calle("avenida Jupiter")
                        .ciudad("Santiago")
                        .fecha_envio("5 de Septiembre")
                        .producto_id(7987)
                        .hora_de_empaquetado("10:30")
                        .cantidad_comprada(1)
                        .estado("despachado")
                        .build(),
                Pedido.builder()
                        .numero_pedido(159)
                        .cliente_id(6)
                        .nombre_cliente("Marta")
                        .calle("Los Arces")
                        .ciudad("Temuco")
                        .fecha_envio("28 de Enero")
                        .producto_id(8526)
                        .hora_de_empaquetado("23:15")
                        .cantidad_comprada(2)
                        .estado("retenido")
                        .build(),
                Pedido.builder()
                        .numero_pedido(753)
                        .cliente_id(7)
                        .nombre_cliente("Cristina")
                        .calle("calle rio verde")
                        .ciudad("Concepcion")
                        .fecha_envio("14 de Octubre")
                        .producto_id(8526)
                        .hora_de_empaquetado("14:05")
                        .cantidad_comprada(1)
                        .estado("despachado")
                        .build(),
                Pedido.builder()
                        .numero_pedido(147)
                        .cliente_id(5)
                        .nombre_cliente("Renato")
                        .calle("calle los saltos")
                        .ciudad("Antofagasta")
                        .fecha_envio("15 de Mayo")
                        .producto_id(7987)
                        .hora_de_empaquetado("15:49")
                        .cantidad_comprada(3)
                        .estado("retenido")
                        .build(),
                Pedido.builder()
                        .numero_pedido(682)
                        .cliente_id(8)
                        .nombre_cliente("Israel")
                        .calle("avenida pajaritos")
                        .ciudad("Santiago")
                        .fecha_envio("22 de Julio")
                        .producto_id(4268)
                        .hora_de_empaquetado("18:18")
                        .cantidad_comprada(1)
                        .estado("despachado")
                        .build()
        );

    }

}
