package cl.demo.service;


import cl.demo.converter.productoConverter;
import cl.demo.dto.ProductoResponse;
import cl.demo.dto.bd.ClientesResponseDto;
import cl.demo.dto.bd.ProductosResponseDto;
import cl.demo.producto.bdProducto;
import cl.demo.dto.ResponseDtoproductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Servicioproducto {

    @Autowired
    private bdProducto productoBD;

    @Autowired
    private productoConverter convertProduct;



    public ResponseDtoproductos obtenerProducto(String tipo_producto,Integer preciomin,Integer preciomax){
        ProductosResponseDto productos=productoBD.getProductos(tipo_producto,preciomin,preciomax);

        return ResponseDtoproductos.builder().productoResponses(convertProduct.getProductoBD(productos.getProductos().get(0))).build();
    }

    private List<ProductoResponse> filtrar(List<ProductoResponse> productoResponses, String tipo_producto, Integer preciomin, Integer preciomax){
        List<ProductoResponse> productosRespuesta=new ArrayList<>();//lista productos filtrados
        for(ProductoResponse tpp: productoResponses) {//for normal
            if (tpp.getTipo().equalsIgnoreCase(tipo_producto)) {
                    if( ((tpp.getCosto()) >= preciomin) && ((tpp.getCosto()) <= preciomax) ){
                        productosRespuesta.add(tpp);
                    }

            }
        }
        return  productosRespuesta;
    }



}
