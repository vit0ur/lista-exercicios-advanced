package exerciciosIntermediary.application;

import exerciciosIntermediary.domain.Pedido;
import exerciciosIntermediary.repositories.PedidoRepository;

public class FinalizarPedido {
    private final PedidoRepository pedidoRepository;

    public FinalizarPedido(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void executar(Pedido pedido) {
        pedido.finalizar();
    }
}