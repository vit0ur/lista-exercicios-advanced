package exerciciosInitial.infrastructure;

import exerciciosInitial.domain.Funcionario;
import exerciciosInitial.repositories.FuncionarioRepository;

import java.util.Arrays;
import java.util.List;

public class InMemoryFuncionarioRepository implements FuncionarioRepository {

    private List<Funcionario> funcionarios = Arrays.asList(
        new Funcionario("Ana", "Gerente", 5000.0),
        new Funcionario("vitor", "Analista", 3000.0)
    );

    @Override
    public List<Funcionario> listarTodos() {
        return List.of();
    }
}
