package exerciciosIntermediary.repositories;

import exerciciosIntermediary.domain.Tarefa;
import java.util.List;

public interface TarefaRepository {
    void salvar(Tarefa tarefa);
    Tarefa buscarPorDescricao(String descricao);
    List<Tarefa> listarTodas();
}
