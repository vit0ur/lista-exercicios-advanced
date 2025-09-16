import exerciciosInitial.application.*;
import exerciciosInitial.domain.*;
import exerciciosInitial.infrastructure.*;
import static org.junit.jupiter.api.Assertions.*;
import exerciciosInitial.dto.FuncionarioDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class InitialTestExercice {

    private InMemoryAlunoRepository repositoryAluno;
    private InMemoryFilmeRepository repositoryFilme;
    private InMemoryFuncionarioRepository repositoryFuncionario;

    private CadastrarAluno cadastrarAluno;
    private BuscarFilmePorTitulo buscarFilmePorTitulo;
    private ListarFuncionarios listarFuncionarios;

    @BeforeEach
    void setup() {
        repositoryAluno = new InMemoryAlunoRepository();
        repositoryFilme = new InMemoryFilmeRepository();
        repositoryFuncionario = new InMemoryFuncionarioRepository();

        cadastrarAluno = new CadastrarAluno(repositoryAluno);
        buscarFilmePorTitulo = new BuscarFilmePorTitulo(repositoryFilme);
        listarFuncionarios = new ListarFuncionarios(repositoryFuncionario);
    }

    @Test
    void deveCadastrarAlunoComSucesso() {
        String nome = "Jose Vitor";
        String matricula = "20205177";
        String curso = "Engenharia";

        cadastrarAluno.executar(nome, matricula, curso);

        List<Aluno> alunos = repositoryAluno.listarTodos();
        assertEquals(1, alunos.size());

        Aluno aluno = alunos.get(0);
        assertEquals(nome, aluno.getNome());
        assertEquals(matricula, aluno.getMatricula());
        assertEquals(curso, aluno.getCurso());
    }

    @Test
    void deveListarFuncionariosConvertidosEmDTO() {
        List<FuncionarioDTO> funcionarios = listarFuncionarios.executar();

        assertEquals(2, funcionarios.size());

        FuncionarioDTO primeiro = funcionarios.get(0);
        assertEquals("Ana", primeiro.getNome());
        assertEquals("Gerente", primeiro.getCargo());
        assertEquals(5000.0, primeiro.getSalario());

        FuncionarioDTO segundo = funcionarios.get(1);
        assertEquals("vitor", segundo.getNome());
        assertEquals("Analista", segundo.getCargo());
        assertEquals(3000.0, segundo.getSalario());
    }

    @Test
    void deveRetornarFilmeQuandoTituloExiste() {
        Filme filme = buscarFilmePorTitulo.executar("Matrix");

        assertNotNull(filme);
        assertEquals("Matrix", filme.getTitulo());
        assertEquals("Ficção", filme.getGenero());
        assertEquals(1999, filme.getAno());
    }
}