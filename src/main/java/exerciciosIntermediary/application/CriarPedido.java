package exerciciosIntermediary.application;

import exerciciosIntermediary.domain.Lanche;
import exerciciosIntermediary.domain.Pedido;
import exerciciosIntermediary.repositories.PedidoRepository;

import java.util.List;

public class CriarPedido {
    private final PedidoRepository pedidoRepository;

    public CriarPedido(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido executar(List<Lanche> lanches) {
        Pedido pedido = new Pedido();
        for (Lanche lanche : lanches) {
            pedido.adicionarLanche(lanche);
        }
        pedidoRepository.salvar(pedido);
        return pedido;
    }
}
