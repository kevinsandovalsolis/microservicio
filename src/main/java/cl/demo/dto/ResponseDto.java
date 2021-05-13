package cl.demo.dto;

public class ResponseDto {

    private String texto;

    public ResponseDto(String c){
        texto=c;
    }

    public String getTexto(){
        return texto;
    }

    public void setTexto(String texto){
        this.texto=texto;
    }
}
