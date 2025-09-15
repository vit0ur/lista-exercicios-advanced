package exerciciosIntermediary.application;

import exerciciosIntermediary.domain.Tarefa;
import exerciciosIntermediary.repositories.TarefaRepository;

public class ConcluirTarefa {
    private final TarefaRepository repository;

    public ConcluirTarefa(TarefaRepository repository) {
        this.repository = repository;
    }

    public void execute(String descricao) {
        Tarefa tarefa = repository.buscarPorDescricao(descricao);
        tarefa.concluir();
    }
}