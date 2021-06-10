package cl.demo.converter;


import cl.demo.dto.ClienteResponse;
import cl.demo.dto.ProductoResponse;
import cl.demo.dto.bd.Cliente;
import cl.demo.dto.bd.Producto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class productoConverter {

    public List<ProductoResponse> getProductoBD(List<Producto> producto){
        List<ProductoResponse> productolista= new ArrayList<>();
        for(Producto pl: producto){
            productolista.add(ProductoResponse.builder()
                    .tipo_producto(pl.getTipo_producto())
                    .descripcion(pl.getDescripcion())
                    .id_producto(pl.getId_producto())
                    .precio(pl.getPrecio())
                    .build());
        }
        return productolista;

    }
}
