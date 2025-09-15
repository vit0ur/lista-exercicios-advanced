package exerciciosInitial.repositories;

import exerciciosInitial.domain.Filme;
import java.util.Optional;

public interface FilmeRepository {
    Optional<Filme> buscarPorTitulo(String titulo);
}