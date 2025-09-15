package exerciciosInitial.application;

import exerciciosInitial.domain.Filme;
import exerciciosInitial.exception.FilmeNaoEncontradoException;
import exerciciosInitial.repositories.FilmeRepository;

public class BuscarFilmePorTitulo {
    private final FilmeRepository repository;

    public BuscarFilmePorTitulo(FilmeRepository repository){
        this.repository = repository;
    }

    public Filme executar(String titulo){
        return repository.buscarPorTitulo(titulo)
                .orElseThrow(() -> new FilmeNaoEncontradoException("Filme não encontrado: " + titulo));
    }
}
