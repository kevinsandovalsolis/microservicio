package cl.demo.service;


import cl.demo.dto.RequestDto;
import cl.demo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Servicio {


    public ResponseDto metodo1(RequestDto request){

        return ResponseDto.builder()
                .nombre(request.getNombre())
                .fecha(request.getFecha())
                .autos(request.getAutos())
                .build();
    }
}
