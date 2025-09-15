package exerciciosIntermediary.application;

import exerciciosIntermediary.domain.Lanche;
import exerciciosIntermediary.repositories.LancheRepository;

public class CadastrarLanche {
    private final LancheRepository lancheRepository;

    public CadastrarLanche(LancheRepository lancheRepository) {
        this.lancheRepository = lancheRepository;
    }

    public void executar(Lanche lanche) {
        lancheRepository.salvar(lanche);
    }
}