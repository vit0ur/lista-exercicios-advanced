package exerciciosIntermediary.repositories;

import exerciciosIntermediary.domain.Lanche;
import java.util.List;

public interface LancheRepository {
    void salvar(Lanche lanche);
    List<Lanche> listarTodos();
}