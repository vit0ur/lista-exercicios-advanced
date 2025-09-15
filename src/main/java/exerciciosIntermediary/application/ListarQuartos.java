package exerciciosIntermediary.application;

import exerciciosIntermediary.domain.Quarto;
import exerciciosIntermediary.repositories.QuartoRepository;

import java.util.List;

public class ListarQuartos {
    private final QuartoRepository repository;

    public ListarQuartos(QuartoRepository repository) {
        this.repository = repository;
    }

    public List<Quarto> execute() {
        return repository.listar();
    }
}
