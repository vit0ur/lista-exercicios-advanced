package exerciciosInitial.exception;

public class FilmeNaoEncontradoException extends RuntimeException{
    public FilmeNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
