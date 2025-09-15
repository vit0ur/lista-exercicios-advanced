package exerciciosIntermediary.domain;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Lanche> lanches = new ArrayList<>();
    private double valorTotal = 0.0;
    private boolean finalizado = false;

    public void adicionarLanche(Lanche lanche) {
        if (finalizado) throw new IllegalStateException("Pedido já finalizado!");
        if (!lanche.isDisponivel()) throw new IllegalArgumentException("Lanche indisponível!");
        lanches.add(lanche);
        valorTotal += lanche.getPreco();
    }

    public void finalizar() {
        if (finalizado) throw new IllegalStateException("Pedido já finalizado!");
        finalizado = true;
    }

    public List<Lanche> getLanches() { return lanches; }
    public double getValorTotal() { return valorTotal; }
    public boolean isFinalizado() { return finalizado; }
}
