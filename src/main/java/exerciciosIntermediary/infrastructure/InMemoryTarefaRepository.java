package exerciciosIntermediary.infrastructure;

import exerciciosIntermediary.domain.Tarefa;
import exerciciosIntermediary.repositories.TarefaRepository;
import java.util.ArrayList;
import java.util.List;

public class InMemoryTarefaRepository implements TarefaRepository {
    private List<Tarefa> tarefas = new ArrayList<>();

    @Override
    public void salvar(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    @Override
    public Tarefa buscarPorDescricao(String descricao) {
        return tarefas.stream()
                .filter(t -> t.getDescricao().equalsIgnoreCase(descricao))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada!"));
    }

    @Override
    public List<Tarefa> listarTodas() {
        return tarefas;
    }
}