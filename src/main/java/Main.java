import exerciciosInitial.application.BuscarFilmePorTitulo;
import exerciciosInitial.application.CadastrarAluno;
import exerciciosInitial.application.ListarFuncionarios;
import exerciciosInitial.domain.Filme;
import exerciciosInitial.domain.Funcionario;
import exerciciosInitial.infrastructure.InMemoryAlunoRepository;
import exerciciosInitial.infrastructure.InMemoryFilmeRepository;
import exerciciosInitial.infrastructure.InMemoryFuncionarioRepository;
import exerciciosInitial.repositories.FilmeRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Parte 1 - Exercícios Fáceis ===");

        // Exercício 1 – Cadastro de Aluno
        InMemoryAlunoRepository alunoRepo = new InMemoryAlunoRepository();
        CadastrarAluno cadastrarAluno = new CadastrarAluno(alunoRepo);
        cadastrarAluno.executar("Vitor", "2025001", "Engenharia");
        System.out.println("Aluno cadastrado: " + alunoRepo);

        // Exercício 2 – Listagem de Funcionários
        InMemoryFuncionarioRepository funcionarioRepo = new InMemoryFuncionarioRepository();
        ListarFuncionarios listarFuncionarios = new ListarFuncionarios(funcionarioRepo);
        System.out.println("Lista de funcionários:");
        listarFuncionarios.executar().forEach(System.out::println);

        // Exercício 3 – Buscar Filme por Título
        InMemoryFilmeRepository filmeRepo = new InMemoryFilmeRepository();
        BuscarFilmePorTitulo buscarFilme = new BuscarFilmePorTitulo(filmeRepo);
        try {
            Filme filme = buscarFilme.executar("Matrix");
            System.out.println("Filme encontrado: " + filme);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== Parte 2 - Exercícios Intermediários ===");

        // Exercício 4 – Sistema de Reservas de Quartos
        QuartoRepository quartoRepo = new QuartoRepository();
        CadastrarQuarto cadastrarQuarto = new CadastrarQuarto(quartoRepo);
        ListarQuartos listarQuartos = new ListarQuartos(quartoRepo);
        ReservarQuarto reservarQuarto = new ReservarQuarto(quartoRepo);

        cadastrarQuarto.executar(new Quarto(101, "Solteiro"));
        cadastrarQuarto.executar(new Quarto(102, "Casal"));
        System.out.println("Quartos cadastrados:");
        listarQuartos.executar().forEach(System.out::println);

        reservarQuarto.executar(101);
        System.out.println("Após reservar quarto 101:");
        listarQuartos.executar().forEach(System.out::println);

        // Exercício 5 – Gerenciamento de Tarefas
        TarefaRepository tarefaRepo = new TarefaRepository();
        CriarTarefa criarTarefa = new CriarTarefa(tarefaRepo);
        ListarTarefasPendentes listarPendentes = new ListarTarefasPendentes(tarefaRepo);
        ConcluirTarefa concluirTarefa = new ConcluirTarefa(tarefaRepo);

        criarTarefa.executar(new Tarefa("Estudar Java"));
        criarTarefa.executar(new Tarefa("Praticar Clean Architecture"));
        System.out.println("Tarefas pendentes:");
        listarPendentes.executar().forEach(System.out::println);

        concluirTarefa.executar(1); // supondo que IDs são 1, 2
        System.out.println("Após concluir tarefa 1:");
        listarPendentes.executar().forEach(System.out::println);

        // Parte do main referente ao Exercício 6 – Lanchonete com Facade
        System.out.println("\n=== Exercício 6 – Sistema de Pedidos de Lanchonete (Facade) ===");

        LanchoneteFacade lanchonete = new LanchoneteFacade();

        lanchonete.cadastrarLanche("X-Burger", 15.0, true);
        lanchonete.cadastrarLanche("Cachorro-Quente", 10.0, false);

        System.out.println("Lanches disponíveis:");
        lanchonete.listarLanches().forEach(System.out::println);

        Pedido pedido = lanchonete.criarPedido(Arrays.asList("X-Burger"));
        System.out.println("Pedido criado: " + pedido);

        lanchonete.finalizarPedido(pedido.getId());
        System.out.println("Pedido finalizado: " + pedido);
    }
}