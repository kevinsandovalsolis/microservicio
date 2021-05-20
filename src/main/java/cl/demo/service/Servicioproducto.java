package cl.demo.service;

import cl.demo.producto.bdProducto;
import cl.demo.dto.Producto;
import cl.demo.dto.RequestDtoproductos;
import cl.demo.dto.ResponseDtoproductos;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Servicioproducto {

    @Autowired
    private bdProducto productoBD;

    public ResponseDtoproductos ingresaProducto(RequestDtoproductos request){
        return ResponseDtoproductos.builder()
                .productos(request.getProductos())
                .build();
    }


    public ResponseDtoproductos obtenerProducto(String tipo_producto){
        List<Producto> productos=productoBD.getProductos();



        return ResponseDtoproductos.builder().productos(filtrar(productos,tipo_producto)).build();
    }

    private List<Producto> filtrar(List<Producto> productos,String tipo_producto){
        List<Producto> productosRespuesta=new ArrayList<>();
        for(Producto tpp: productos) {//for normal
            if (tpp.getTipo_producto().equalsIgnoreCase(tipo_producto)) {
                productosRespuesta.add(tpp);
            }else{

            }
        }
        return  productosRespuesta;
    }
}