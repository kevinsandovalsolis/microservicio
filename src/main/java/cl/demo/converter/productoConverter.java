package cl.demo.converter;


import cl.demo.dto.ClienteResponse;
import cl.demo.dto.ProductoResponse;
import cl.demo.dto.bd.Cliente;
import cl.demo.dto.bd.Producto;
import org.springframework.stereotype.Component;

@Component
public class productoConverter {

    public ProductoResponse getProductoBD(Producto producto){
        return ProductoResponse.builder()
                .tipo(producto.getTipo_producto())
                .costo(producto.getPrecio())
                .build();

    }
}
