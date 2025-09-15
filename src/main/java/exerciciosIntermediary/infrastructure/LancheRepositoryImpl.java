package exerciciosIntermediary.infrastructure;

import exerciciosIntermediary.domain.Lanche;
import exerciciosIntermediary.repositories.LancheRepository;
import java.util.ArrayList;
import java.util.List;

public class LancheRepositoryImpl implements LancheRepository {
    private final List<Lanche> lanches = new ArrayList<>();
    @Override
    public void salvar(Lanche lanche) { lanches.add(lanche); }
    @Override
    public List<Lanche> listarTodos() { return lanches; }
}