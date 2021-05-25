package cl.demo.service;

import cl.demo.dto.*;
import cl.demo.pedido.bdPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Serviciopedido {

    @Autowired
    private bdPedido pedidoBD;

    /*public ResponseDtopedidos eliminarPedido(Integer numero_pedido){
        List<Pedido> pedidos=pedidoBD.getPedidos();

        return ResponseDtopedidos.builder().pedidos(eliminar(pedidos,numero_pedido)).build();
    }*/

    private List<Pedido> eliminar(List<Pedido> pedidos, Integer numero_pedido) {
        List<Pedido> pedidosRespuesta= new ArrayList<>(pedidos);//se crea una nueva lista con los datos de la anterior
        int pedidoeliminar=-1;
        for(int i=0; i<pedidos.size(); i++) {//for normal
            if (pedidos.get(i).getNumero_pedido().equals(numero_pedido)) {

                    pedidoeliminar=i;
            break;
            }

        }
        pedidosRespuesta.remove(pedidoeliminar);
        return pedidosRespuesta;
    }

    public ResponseDtopedidos ingresaPedido(RequestDtopedidos parametros){
        List<Pedido> pedidos=new ArrayList<>(pedidoBD.getPedidos());
        for(Pedido pd: parametros.getPedidos() ) {
            pedidos.add(Pedido.builder()
                    .cantidad_comprada(pd.getCantidad_comprada())
                    .calle(pd.getCalle())
                    .ciudad(pd.getCiudad())
                    .cliente_id(pd.getCliente_id())
                    .estado(pd.getEstado())
                    .fecha_envio(pd.getFecha_envio())
                    .build());
        }
        System.out.print(pedidos);
        return ResponseDtopedidos.builder()
                .numero_pedidos(String.valueOf(pedidos.size()))
                .build();
    }


    /*
    public ResponseDtopedidos ingresaPedido(RequestDtopedidos request){
        return ResponseDtopedidos.builder()
                .pedidos(request.getPedidos())
                .build();
    }

    public ResponseDtopedidos añadirPedido(Integer numero_pedido, Integer cliente_id, String nombre_cliente,String calle,String ciudad,String fecha_envio, Integer producto_id,String hora_de_empaquetado,Integer cantidad_comprada,String estado){
        List<Pedido> pedidos=pedidoBD.getPedidos();

        return ResponseDtopedidos.builder().pedidos(añadir(pedidos,numero_pedido,cliente_id,nombre_cliente,calle,ciudad,fecha_envio,producto_id,hora_de_empaquetado,cantidad_comprada,estado)).build();
    }

    private List<Pedido> añadir(List<Pedido> pedidos,Integer numero_pedido, Integer cliente_id, String nombre_cliente,String calle,String ciudad,String fecha_envio, Integer producto_id,String hora_de_empaquetado,Integer cantidad_comprada,String estado){
        List<Pedido> pedidosRespuesta=new ArrayList<>();//lista pedios filtrados
        for(Pedido pd: pedidos){
            pedidosRespuesta.add(0,pd);

        }
        return  pedidosRespuesta;
    }

     */

}
