package cl.demo.service;


import cl.demo.cliente.bdCliente;
import cl.demo.dto.Cliente;
import cl.demo.dto.RequestDtoclientes;
import cl.demo.dto.ResponseDtoclientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Serviciocliente {

    @Autowired
    private bdCliente clienteBD;

    public ResponseDtoclientes ingresaCliente(RequestDtoclientes request){
        return ResponseDtoclientes.builder()
            .clientes(request.getClientes())
            .build();
    }


    public ResponseDtoclientes obtenerCliente(String nombre){
        List<Cliente> clientes=clienteBD.getClientes();



        return ResponseDtoclientes.builder().clientes(filtrar(clientes,nombre)).build();
    }

    private List<Cliente> filtrar(List<Cliente> clientes,String nombre){
        List<Cliente> clientesRespuesta=new ArrayList<>();
        for(Cliente clt: clientes) {//for normal
            if (clt.getNombre().equalsIgnoreCase(nombre)) {
                clientesRespuesta.add(clt);
            }else{

            }
        }
        return  clientesRespuesta;
    }


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



}


