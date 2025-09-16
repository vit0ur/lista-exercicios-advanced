package exerciciosIntermediary.domain;

public class Quarto {
    private int numero;
    private String tipo;
    private String status;

    public Quarto(int numero, String tipo, String status){
        this.numero = numero;
        this.tipo = tipo;
        this.status = status;
    }

    public void reservar(){
        if (status.equals("disponivel")){
            status = "ocupado";
        }else if(status.equals("ocupado")){
            throw new IllegalStateException("Quarto indisponivel !");
        }else{
            status = "Reservado";
        }
    }

    public String toString(){
        return "Quarto: " + numero + " (" + tipo + ") - " + status;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getStatus() {
        return status;
    }
}
