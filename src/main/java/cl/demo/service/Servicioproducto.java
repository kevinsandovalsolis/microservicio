package cl.demo.service;

import cl.demo.producto.bdProducto;
import cl.demo.dto.Producto;
import cl.demo.dto.RequestDtoproductos;
import cl.demo.dto.ResponseDtoproductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Servicioproducto {

    @Autowired
    private bdProducto productoBD;



    /*
    public ResponseDtoproductos ingresaProducto(RequestDtoproductos request){
        return ResponseDtoproductos.builder()
                .productos(request.getProductos())
                .build();
    }
    */



    public ResponseDtoproductos obtenerProducto(String tipo_producto,Integer preciomin,Integer preciomax){
        List<Producto> productos=productoBD.getProductos();

        return ResponseDtoproductos.builder().productos(filtrar(productos,tipo_producto,preciomin,preciomax)).build();
    }

    private List<Producto> filtrar(List<Producto> productos,String tipo_producto,Integer preciomin,Integer preciomax){
        List<Producto> productosRespuesta=new ArrayList<>();//lista productos filtrados
        for(Producto tpp: productos) {//for normal
            if (tpp.getTipo_producto().equalsIgnoreCase(tipo_producto)) {
                    if( ((tpp.getPrecio()) >= preciomin) && ((tpp.getPrecio()) <= preciomax) ){
                        productosRespuesta.add(tpp);
                    }

            }
        }
        return  productosRespuesta;
    }



}
