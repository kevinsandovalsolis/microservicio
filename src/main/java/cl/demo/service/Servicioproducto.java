package cl.demo.service;


import cl.demo.converter.productoConverter;
import cl.demo.dto.ProductoResponse;
import cl.demo.dto.bd.ProductosResponseDto;
import cl.demo.producto.bdProducto;
import cl.demo.dto.ResponseDtoproductos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class Servicioproducto {

    @Autowired
    private bdProducto productoBD;

    @Autowired
    private productoConverter convertProduct;



    public ResponseDtoproductos obtenerProducto(String tipo_producto,Integer preciomin,Integer preciomax){
        ProductosResponseDto productos=productoBD.getProductos(tipo_producto,preciomin,preciomax);
    try {

        if (tipo_producto.equals("")&& (preciomax == null) && (preciomin == null)){

            List<ProductoResponse> filtrados = filtrarocho(convertProduct.getProductoBD(productos.getProductos()));
            //no recibe parametros
            return ResponseDtoproductos.builder().productoResponses(filtrados).build();
        } else if ((tipo_producto != null) && (preciomin == null) && (preciomax == null)) {
            List<ProductoResponse> filtrados = filtrarsiete(convertProduct.getProductoBD(productos.getProductos()), tipo_producto);
            //recibe tipo_producto
            return ResponseDtoproductos.builder().productoResponses(filtrados).build();

        }else if ((tipo_producto == null) && (preciomax >= 0) && (preciomin == null)) {
            List<ProductoResponse> filtrados = filtrarseis(convertProduct.getProductoBD(productos.getProductos()),preciomax);
            //recibe preciomax
            return ResponseDtoproductos.builder().productoResponses(filtrados).build();

        }else if ((tipo_producto == null) && (preciomax == null) && (preciomin >= 0)) {
            List<ProductoResponse> filtrados = filtrarcinco(convertProduct.getProductoBD(productos.getProductos()),preciomin);
            //recibe preciomin
            return ResponseDtoproductos.builder().productoResponses(filtrados).build();

        }else if ((tipo_producto != null) && (preciomax == null) && (preciomin >= 0)) {
            List<ProductoResponse> filtrados = filtrarcuatro(convertProduct.getProductoBD(productos.getProductos()),tipo_producto,preciomin);
            //recibe preciomin y tipo_producto
            return ResponseDtoproductos.builder().productoResponses(filtrados).build();

        }else if ((tipo_producto != null) && (preciomax >= 0) && (preciomin == null)) {
            List<ProductoResponse> filtrados = filtrartres(convertProduct.getProductoBD(productos.getProductos()),tipo_producto,preciomax);
            //recibe preciomax y tipo_producto
            return ResponseDtoproductos.builder().productoResponses(filtrados).build();

        }else if ((tipo_producto == null) && (preciomax >= 0) && (preciomin >= 0)) {
            List<ProductoResponse> filtrados = filtrardos(convertProduct.getProductoBD(productos.getProductos()),preciomin,preciomax);
            //recibe preciomax y preciomin
            return ResponseDtoproductos.builder().productoResponses(filtrados).build();

        }else if ((tipo_producto != null) && (preciomax >= 0) && (preciomin >= 0)) {
            List<ProductoResponse> filtrados = filtrar(convertProduct.getProductoBD(productos.getProductos()),tipo_producto,preciomax,preciomin);
            //recibe preciomax y preciomin
            return ResponseDtoproductos.builder().productoResponses(filtrados).build();

        }else{

            return null;
        }
    }catch(Exception e){
        log.error("Debe proveer numeros validos en preciomin y preciomax "+ e.getMessage() );
        throw e;
        }

    }

    //ningun parametro es recibido
    private List<ProductoResponse> filtrarocho(List<ProductoResponse> productoResponses){
        List<ProductoResponse> productosRespuesta=new ArrayList<>();//lista productos filtrados
        for(ProductoResponse tpp: productoResponses) {
            log.info("Ningun parametro fue ingresado");
        }
        return  productosRespuesta;
    }

    //no recibe preciomin ni preciomax
    private List<ProductoResponse> filtrarsiete(List<ProductoResponse> productoResponses,String tipo_producto){
        List<ProductoResponse> productosRespuesta=new ArrayList<>();//lista productos filtrados
        for(ProductoResponse tpp: productoResponses) {//for normal
            if (tpp.getTipo_producto().equalsIgnoreCase(tipo_producto)) {
                    productosRespuesta.add(tpp);
            }
        }
        return  productosRespuesta;
    }

    //no recibe preciomin ni tipo
    private List<ProductoResponse> filtrarseis(List<ProductoResponse> productoResponses, Integer preciomax){
        List<ProductoResponse> productosRespuesta=new ArrayList<>();//lista productos filtrados
        for(ProductoResponse tpp: productoResponses) {//for normal
            if( (tpp.getPrecio()) <= preciomax){
                productosRespuesta.add(tpp);
            }
        }
        return  productosRespuesta;
    }

    //no recibe preciomax ni tipo
    private List<ProductoResponse> filtrarcinco(List<ProductoResponse> productoResponses, Integer preciomin){
        List<ProductoResponse> productosRespuesta=new ArrayList<>();//lista productos filtrados
        for(ProductoResponse tpp: productoResponses) {//for normal
            if( (tpp.getPrecio()) >= preciomin){
                productosRespuesta.add(tpp);
            }
        }
        return  productosRespuesta;
    }

    //no recibe preciomax
    private List<ProductoResponse> filtrarcuatro(List<ProductoResponse> productoResponses, String tipo_producto, Integer preciomin){
        List<ProductoResponse> productosRespuesta=new ArrayList<>();//lista productos filtrados
        for(ProductoResponse tpp: productoResponses) {//for normal
            if (tpp.getTipo_producto().equalsIgnoreCase(tipo_producto)) {
                if( (tpp.getPrecio()) >= preciomin){
                    productosRespuesta.add(tpp);
                }
            }
        }
        return  productosRespuesta;
    }

    //no recibe preciomin
    private List<ProductoResponse> filtrartres(List<ProductoResponse> productoResponses, String tipo_producto, Integer preciomax){
        List<ProductoResponse> productosRespuesta=new ArrayList<>();//lista productos filtrados
        for(ProductoResponse tpp: productoResponses) {//for normal
            if (tpp.getTipo_producto().equalsIgnoreCase(tipo_producto)) {
                if( (tpp.getPrecio()) <= preciomax){
                    productosRespuesta.add(tpp);
                }
            }
        }
        return  productosRespuesta;
    }

    //no recibe tipo_producto
    private List<ProductoResponse> filtrardos(List<ProductoResponse> productoResponses, Integer preciomin, Integer preciomax){
        List<ProductoResponse> productosRespuesta=new ArrayList<>();//lista productos filtrados
        for(ProductoResponse tpp: productoResponses) {
            if( ((tpp.getPrecio()) >= preciomin) && ((tpp.getPrecio()) <= preciomax) ){
                productosRespuesta.add(tpp);
            }

        }
        return  productosRespuesta;
    }

    //recibe todos los parametros
    private List<ProductoResponse> filtrar(List<ProductoResponse> productoResponses, String tipo_producto, Integer preciomin, Integer preciomax){
        List<ProductoResponse> productosRespuesta=new ArrayList<>();//lista productos filtrados
        for(ProductoResponse tpp: productoResponses) {//for normal
            if (tpp.getTipo_producto().equalsIgnoreCase(tipo_producto)) {
                    if( ((tpp.getPrecio()) >= preciomin) && ((tpp.getPrecio()) <= preciomax) ){
                        productosRespuesta.add(tpp);
                    }
            }
        }
        return  productosRespuesta;
    }



}
