package exerciciosIntermediary.domain;

public class Lanche {
    private String nome;
    private double preco;
    private boolean disponivel;

    public Lanche(String nome, double preco, boolean disponivel) {
        this.nome = nome;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public boolean isDisponivel() { return disponivel; }
}
