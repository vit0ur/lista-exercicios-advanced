package exerciciosIntermediary.repositories;

import exerciciosIntermediary.domain.Quarto;
import java.util.List;

public interface QuartoRepository {
    void salvar (Quarto quarto);
    Quarto buscarPorNumero(int numero);
    List<Quarto> listar();
}
