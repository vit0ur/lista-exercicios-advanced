package exerciciosInitial.application;

import exerciciosInitial.domain.Aluno;
import exerciciosInitial.repositories.AlunoRepository;

public class CadastrarAluno {
    private final AlunoRepository repository;

    public void executar(String nome, String matricula, String curso){
        Aluno aluno = new Aluno(nome, matricula, curso);
        repository.salvar(aluno);
    }

    public CadastrarAluno(AlunoRepository repository) {
        this.repository = repository;
    }
}
