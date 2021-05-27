package cl.demo.producto;

import cl.demo.dto.Producto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class bdProducto {

    public List<Producto> getProductos(){
        return Arrays.asList(
                Producto.builder()
                        .id_producto(1)
                        .tipo_producto("Consola")
                        .descripcion("Dispositivo para jugar")
                        .precio(555555)
                        .stock(30)
                        .build(),
                Producto.builder()
                        .id_producto(2)
                        .tipo_producto("Juego")
                        .descripcion("Mando para jugar")
                        .precio(77775)
                        .stock(5)
                        .build(),
                Producto.builder()
                        .id_producto(3)
                        .tipo_producto("Periferico")
                        .descripcion("Accesorio para jugar")
                        .precio(88888)
                        .stock(10)
                        .build(),
                Producto.builder()
                        .id_producto(4)
                        .tipo_producto("Juego")
                        .descripcion("Titulo para jugar")
                        .precio(34222)
                        .stock(40)
                        .build(),
                Producto.builder()
                        .id_producto(5)
                        .tipo_producto("Juego")
                        .descripcion("Titulo para jugar")
                        .precio(15000)
                        .stock(40)
                        .build(),
                Producto.builder()
                        .id_producto(6)
                        .tipo_producto("Juego")
                        .descripcion("Titulo para jugar")
                        .precio(20000)
                        .stock(40)
                        .build()
        );
    }
}
