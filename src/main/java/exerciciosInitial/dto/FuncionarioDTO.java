package exerciciosInitial.dto;

public class FuncionarioDTO {
    private String nome;
    private String cargo;
    private Double salario;

    public FuncionarioDTO(String nome, String matricula, Double curso){
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public Double getSalario() {
        return salario;
    }
}
