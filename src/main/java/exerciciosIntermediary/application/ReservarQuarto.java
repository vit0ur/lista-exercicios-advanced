package exerciciosIntermediary.application;

import exerciciosIntermediary.domain.Quarto;
import exerciciosIntermediary.repositories.QuartoRepository;

public class ReservarQuarto {
    private final QuartoRepository repository;

    public ReservarQuarto(QuartoRepository repository) {
        this.repository = repository;
    }

    public void execute(int numero) {
        Quarto quarto = repository.buscarPorNumero(numero);
        quarto.reservar();
    }
}
