package exerciciosIntermediary.application;

import exerciciosIntermediary.domain.Tarefa;
import exerciciosIntermediary.repositories.TarefaRepository;
import java.util.List;
import java.util.stream.Collectors;

public class ListarTarefasPendentes {
    private final TarefaRepository repository;

    public ListarTarefasPendentes(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<Tarefa> execute() {
        return repository.listarTodas().stream()
                .filter(t -> t.getStatus().equals("pendente"))
                .collect(Collectors.toList());
    }
}