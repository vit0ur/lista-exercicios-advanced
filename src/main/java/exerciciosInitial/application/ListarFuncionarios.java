package exerciciosInitial.application;

import exerciciosInitial.dto.FuncionarioDTO;
import exerciciosInitial.repositories.FuncionarioRepository;
import java.util.List;
import java.util.stream.Collectors;

public class ListarFuncionarios {
    private final FuncionarioRepository repository;

    public ListarFuncionarios(FuncionarioRepository repository){
        this.repository = repository;
    }

    public List<FuncionarioDTO> executar(){
        return repository.listarTodos().stream()
                .map(funcionario -> new FuncionarioDTO(funcionario.getNome(), funcionario.getCargo(), funcionario.getSalario()))
                .collect(Collectors.toList());
    }
}
