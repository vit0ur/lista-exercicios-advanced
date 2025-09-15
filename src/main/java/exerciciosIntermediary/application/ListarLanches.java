package exerciciosIntermediary.application;

import exerciciosIntermediary.domain.Lanche;
import exerciciosIntermediary.repositories.LancheRepository;
import java.util.List;

public class ListarLanches {
    private final LancheRepository lancheRepository;

    public ListarLanches(LancheRepository lancheRepository) {
        this.lancheRepository = lancheRepository;
    }

    public List<Lanche> executar() {
        return lancheRepository.listarTodos();
    }
}