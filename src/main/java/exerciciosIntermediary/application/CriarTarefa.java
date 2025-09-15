package exerciciosIntermediary.application;

import exerciciosIntermediary.domain.Tarefa;
import exerciciosIntermediary.repositories.TarefaRepository;

public class CriarTarefa {
    private final TarefaRepository repository;

    public CriarTarefa(TarefaRepository repository) {
        this.repository = repository;
    }

    public void execute(String descricao) {
        repository.salvar(new Tarefa(descricao));
    }
}