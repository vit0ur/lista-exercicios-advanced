package exerciciosIntermediary.infrastructure;

import exerciciosIntermediary.domain.Quarto;
import exerciciosIntermediary.repositories.QuartoRepository;
import java.util.ArrayList;
import java.util.List;

public class InMemoryQuartoRepository implements QuartoRepository {

    private List<Quarto> quartos = new ArrayList<>();

    @Override
    public void salvar(Quarto quarto) {
        quartos.add(quarto);
    }

    @Override
    public Quarto buscarPorNumero(int numero) {
        return quartos.stream()
                .filter(quarto -> quarto.getNumero() == numero)
                .findFirst().orElseThrow(()-> new RuntimeException("Quarto não encontrado!"));
    }

    @Override
    public List<Quarto> listar() {
        return quartos;
    }
}
