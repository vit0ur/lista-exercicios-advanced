package exerciciosIntermediary.repositories;

import exerciciosIntermediary.domain.Pedido;
import java.util.List;

public interface PedidoRepository {
    void salvar(Pedido pedido);
    List<Pedido> listarTodos();
}