package exerciciosInitial.infrastructure;

import exerciciosInitial.domain.Aluno;
import exerciciosInitial.repositories.AlunoRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAlunoRepository implements AlunoRepository {

    private List<Aluno> alunos = new ArrayList<>();

    @Override
    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> listarTodos(){
        return alunos;
    }
}
