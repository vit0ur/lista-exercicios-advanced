import exerciciosInitial.application.BuscarFilmePorTitulo;
import exerciciosInitial.application.CadastrarAluno;
import exerciciosInitial.application.ListarFuncionarios;
import exerciciosInitial.domain.Filme;
import exerciciosInitial.dto.FuncionarioDTO;
import exerciciosInitial.infrastructure.InMemoryAlunoRepository;
import exerciciosInitial.infrastructure.InMemoryFuncionarioRepository;
import exerciciosInitial.infrastructure.InMemoryFilmeRepository;
import exerciciosIntermediary.application.*;
import exerciciosIntermediary.domain.Lanche;
import exerciciosIntermediary.domain.Pedido;
import exerciciosIntermediary.facade.LanchoneteFacade;
import exerciciosIntermediary.infrastructure.InMemoryQuartoRepository;
import exerciciosIntermediary.infrastructure.InMemoryTarefaRepository;
import exerciciosIntermediary.infrastructure.LancheRepositoryImpl;
import exerciciosIntermediary.infrastructure.PedidoRepositoryImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Cadastro de Aluno
        InMemoryAlunoRepository alunoRepo = new InMemoryAlunoRepository();
        CadastrarAluno cadastrarAluno = new CadastrarAluno(alunoRepo);

        cadastrarAluno.executar("João Silva", "2025001", "Engenharia");
        System.out.println("Aluno cadastrado: " + alunoRepo.listarTodos().get(0).getNome());

        System.out.println("====================== ======================");

        //Listagem de Funcionários
        InMemoryFuncionarioRepository funcRepo = new InMemoryFuncionarioRepository();
        ListarFuncionarios listarFuncionarios = new ListarFuncionarios(funcRepo);

        List<FuncionarioDTO> listaFuncionarios = listarFuncionarios.executar();
        listaFuncionarios.forEach(f -> System.out.println("Funcionários: " + " - " + f.getNome() + ", " + f.getCargo() + ", " + f.getSalario()));

        System.out.println("====================== ======================");

        //Buscar Filme por Título
        InMemoryFilmeRepository filmeRepo = new InMemoryFilmeRepository();
        BuscarFilmePorTitulo buscarFilme = new BuscarFilmePorTitulo(filmeRepo);

        try {
             Filme filme = buscarFilme.executar(filmeRepo.buscarPorTitulo("matrix").get().getTitulo());
             System.out.println("Filme encontrado: " + filme.getTitulo() + " (" + filme.getAno() + ")" + filme.getGenero());
        } catch (RuntimeException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

        System.out.println("====================== ======================");

        //Reservas de Quartos
        InMemoryQuartoRepository quartoRepo = new InMemoryQuartoRepository();
        CadastrarQuarto cadastrarQuarto = new CadastrarQuarto(quartoRepo);

        cadastrarQuarto.execute(828, "luxo", "disponivel");
        cadastrarQuarto.execute(803, "basico", "disponivel");
        cadastrarQuarto.execute(402, "medio", "ocupado");

        ListarQuartos listarQuartos = new ListarQuartos(quartoRepo);
        System.out.println("Todos quartos:");
        listarQuartos.execute().forEach(q -> System.out.println("Quartos: " + " - " + q.getNumero() + ", " + q.getTipo() + ", " + q.getStatus()));

        ReservarQuarto reservarQuarto = new ReservarQuarto(quartoRepo);
        reservarQuarto.execute(828);

        System.out.println("====================== ======================");

        //Gerenciamento de Tarefas
        InMemoryTarefaRepository tarefaRepo = new InMemoryTarefaRepository();
        CriarTarefa criarTarefa = new CriarTarefa(tarefaRepo);

        criarTarefa.execute("Programar um app.");

        ListarTarefasPendentes listarPendentes = new ListarTarefasPendentes(tarefaRepo);
        listarPendentes.execute().forEach(t-> System.out.println("Tarefa: " + t.getDescricao()));

        ConcluirTarefa concluirTarefa = new ConcluirTarefa(tarefaRepo);
        concluirTarefa.execute("Programar um app.");

        listarPendentes.execute().forEach(t-> System.out.println("Tarefa: " + t.getDescricao()));

        System.out.println("====================== ======================");

        //Pedidos de Lanchonete
        LancheRepositoryImpl lancheRepo = new LancheRepositoryImpl();
        PedidoRepositoryImpl pedidoRepo = new PedidoRepositoryImpl();

        LanchoneteFacade facade = new LanchoneteFacade(new CadastrarLanche(lancheRepo), new ListarLanches(lancheRepo), new CriarPedido(pedidoRepo), new FinalizarPedido(pedidoRepo));

        facade.cadastrarLanche(new Lanche("X-Burguer", 15.0, true));
        facade.cadastrarLanche(new Lanche("Cachorro-Quente", 10.0, false));

        System.out.println("Lanches disponíveis:");
        facade.listarLanches().forEach(l -> System.out.println(" - " + l.getNome() + " por R$" + l.getPreco() + (l.isDisponivel() ? "" : " (INDISPONÍVEL)")));

        Pedido pedido = facade.criarPedido(lancheRepo.listarTodos());
        System.out.println("Valor do pedido: " + pedido.getValorTotal());

        facade.finalizarPedido(pedido);
        System.out.println("Status após finalizar: " + pedido.isFinalizado());
    }
}