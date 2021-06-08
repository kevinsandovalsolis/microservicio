package cl.demo.service;


import cl.demo.cliente.bdCliente;
import cl.demo.converter.clienteConverter;
import cl.demo.dto.ClienteResponse;
import cl.demo.dto.RequestDtoclientes;
import cl.demo.dto.ResponseDtoclientes;
import cl.demo.dto.ResponseRegistroClienteDto;
import cl.demo.dto.bd.ClienteRegistroResponseDto;
import cl.demo.dto.bd.ClientesResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Serviciocliente {

    @Autowired
    private bdCliente clienteBD;

    @Autowired
    private clienteConverter convertClient;

    public ResponseRegistroClienteDto ingresaCliente(RequestDtoclientes request){

        ClienteRegistroResponseDto respuesta=clienteBD.registroCliente(convertClient.getClienteIngesarBD(request));
        return ResponseRegistroClienteDto.builder()
            .correo(request.getCorreo())
            .id(respuesta.getId())
            .build();
    }


    public ResponseDtoclientes obtenerCliente(String correo){
        ClientesResponseDto clientes=clienteBD.getClientes(correo);

        return ResponseDtoclientes.builder().clienteResponses(convertClient.getClienteBD(clientes.getClientes().get(0))).build();
    }

    private List<ClienteResponse> filtrar(List<ClienteResponse> clienteResponses, String nombre){
        List<ClienteResponse> clientesRespuesta=new ArrayList<>();
        for(ClienteResponse clt: clienteResponses) {//for normal
            if (clt.getNombre().equalsIgnoreCase(nombre)) {
                clientesRespuesta.add(clt);
            }
        }
        return  clientesRespuesta;
    }

    /*
    private void ejemplos(){
        String cadena1="hola";
        String cadena2="hola";
        boolean igual1=!cadena1.equals(cadena2)&&cadena1.equals(cadena2);//booleano true o false ! para negar booleanos
        boolean igual2=1>2&&3<4;
        boolean igual3=1>2||3<4;
        String num1="20";
        String num2="20.5";
        int num11=Integer.parseInt(num1);
        double num12=Double.parseDouble(num1);
        String num3=String.valueOf(1);
        //== igualdad de numericos, != distinto en numerico, retorna boolean

        //variable primitivas para decimales float,double


    }

     */



}


