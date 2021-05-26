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


}
