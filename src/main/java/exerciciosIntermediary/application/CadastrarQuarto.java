package exerciciosIntermediary.application;

import exerciciosIntermediary.domain.Quarto;
import exerciciosIntermediary.repositories.QuartoRepository;

public class CadastrarQuarto {
    private QuartoRepository repository;

    public CadastrarQuarto(QuartoRepository repository){
        this.repository = repository;
    }

    public void execute(int numero, String tipo, String status){
        Quarto quarto = new Quarto(numero, tipo, status);
        repository.salvar(quarto);
    }
}
