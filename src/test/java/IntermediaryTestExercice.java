import exerciciosIntermediary.application.*;
import exerciciosIntermediary.infrastructure.*;
import static org.junit.jupiter.api.Assertions.*;
import exerciciosIntermediary.domain.*;
import exerciciosIntermediary.facade.LanchoneteFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class IntermediaryTestExercice {

    private InMemoryQuartoRepository repositoryQuarto;
    private InMemoryTarefaRepository repositoryTarefa;
    private LancheRepositoryImpl repositoryLanche;
    private PedidoRepositoryImpl repositoryPedido;

    private CadastrarQuarto cadastrarQuarto;
    private ReservarQuarto reservarQuarto;
    private ConcluirTarefa concluirTarefa;
    private CriarTarefa criarTarefa;
    private LanchoneteFacade facade;

    @BeforeEach
    void setup() {
        repositoryQuarto = new InMemoryQuartoRepository();
        repositoryTarefa = new InMemoryTarefaRepository();
        repositoryLanche = new LancheRepositoryImpl();
        repositoryPedido = new PedidoRepositoryImpl();

        cadastrarQuarto = new CadastrarQuarto(repositoryQuarto);
        reservarQuarto = new ReservarQuarto(repositoryQuarto);
        concluirTarefa = new ConcluirTarefa(repositoryTarefa);
        criarTarefa = new CriarTarefa(repositoryTarefa);

        facade = new LanchoneteFacade(new CadastrarLanche(repositoryLanche), new ListarLanches(repositoryLanche),
                                        new CriarPedido(repositoryPedido), new FinalizarPedido(repositoryPedido));
    }

    @Test
    void deveCadastrarQuartoComSucesso() {
        cadastrarQuarto.execute(201, "Simples", "ocupado");

        Quarto quarto = repositoryQuarto.buscarPorNumero(201);
        assertNotNull(quarto);
        assertEquals("Simples", quarto.getTipo());
        assertEquals("Livre", quarto.getStatus());
    }

    @Test
    void deveReservarQuartoComSucesso() {
        cadastrarQuarto.execute(202, "Duplo", "Reservado");

        reservarQuarto.execute(202);

        Quarto quarto = repositoryQuarto.buscarPorNumero(202);
        assertEquals("Reservado", quarto.getStatus());
    }

    @Test
    void deveCriarTarefaComSucesso() {
        criarTarefa.execute("Limpar o quarto");

        Tarefa tarefa = repositoryTarefa.buscarPorDescricao("Limpar o quarto");
        assertNotNull(tarefa);
        assertEquals("Limpar o quarto", tarefa.getDescricao());
    }

    @Test
    void deveConcluirTarefaComSucesso() {
        criarTarefa.execute("Arrumar a cama");

        concluirTarefa.execute("Arrumar a cama");

        Tarefa tarefa = repositoryTarefa.buscarPorDescricao("Arrumar a cama");
        assertEquals("concluída", tarefa.getStatus());
    }

    @Test
    void deveCadastrarEListarLanches() {
        Lanche lanche1 = new Lanche("X-Burguer", 12.0, true);
        Lanche lanche2 = new Lanche("X-Salada", 14.0, true);

        facade.cadastrarLanche(lanche1);
        facade.cadastrarLanche(lanche2);

        List<Lanche> lanches = facade.listarLanches();
        assertEquals(2, lanches.size());
        assertEquals("X-Burguer", lanches.get(0).getNome());
    }

    @Test
    void deveCriarEPersistirPedido() {
        Lanche lanche = new Lanche("X-Tudo", 18.0, true);
        facade.cadastrarLanche(lanche);

        List<Lanche> lanches = facade.listarLanches();
        Pedido pedido = facade.criarPedido(lanches);

        assertNotNull(pedido);
        assertEquals(1, pedido.getLanches().size());
        assertEquals("X-Tudo", pedido.getLanches().get(0).getNome());
    }

    @Test
    void deveFinalizarPedidoComSucesso() {
        Lanche lanche = new Lanche("X-Bacon", 16.0, true);
        facade.cadastrarLanche(lanche);

        Pedido pedido = facade.criarPedido(List.of(lanche));
        facade.finalizarPedido(pedido);

        assertTrue(pedido.isFinalizado());
    }
}