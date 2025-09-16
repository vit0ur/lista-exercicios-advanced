package exerciciosInitial.infrastructure;

import exerciciosInitial.domain.Filme;
import exerciciosInitial.repositories.FilmeRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InMemoryFilmeRepository implements FilmeRepository {

    private List<Filme> filmes = Arrays.asList(
        new Filme("Matrix", "Ficção", 1999),
        new Filme("Mad Max", "Ação", 1989)
    );

    @Override
    public Optional<Filme> buscarPorTitulo(String titulo) {
        return filmes.stream()
                .filter(filme -> filme.getTitulo().equalsIgnoreCase(titulo))
                .findFirst();
    }
}