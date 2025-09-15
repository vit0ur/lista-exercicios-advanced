package exerciciosInitial.repositories;

import exerciciosInitial.domain.Funcionario;
import java.util.List;

public interface FuncionarioRepository {
    List<Funcionario> listarTodos();
}