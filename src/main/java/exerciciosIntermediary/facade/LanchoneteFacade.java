package exerciciosIntermediary.facade;

import exerciciosIntermediary.application.CadastrarLanche;
import exerciciosIntermediary.application.CriarPedido;
import exerciciosIntermediary.application.FinalizarPedido;
import exerciciosIntermediary.application.ListarLanches;
import exerciciosIntermediary.domain.Lanche;
import exerciciosIntermediary.domain.Pedido;

import java.util.List;

public class LanchoneteFacade {
    private final CadastrarLanche cadastrarLanche;
    private final ListarLanches listarLanches;
    private final CriarPedido criarPedido;
    private final FinalizarPedido finalizarPedido;

    public LanchoneteFacade(CadastrarLanche cadastrarLanche,
                            ListarLanches listarLanches,
                            CriarPedido criarPedido,
                            FinalizarPedido finalizarPedido) {
        this.cadastrarLanche = cadastrarLanche;
        this.listarLanches = listarLanches;
        this.criarPedido = criarPedido;
        this.finalizarPedido = finalizarPedido;
    }

    public void cadastrarLanche(Lanche lanche) {
        cadastrarLanche.executar(lanche);
    }

    public List<Lanche> listarLanches() {
        return listarLanches.executar();
    }

    public Pedido criarPedido(List<Lanche> lanches) {
        return criarPedido.executar(lanches);
    }

    public void finalizarPedido(Pedido pedido) {
        finalizarPedido.executar(pedido);
    }
}
