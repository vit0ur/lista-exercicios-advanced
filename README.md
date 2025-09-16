# 🏗️ Clean Architecture – Exercícios em Java

Este repositório contém uma série de exercícios práticos para aprender e aplicar *Clean Architecture* em projetos Java, organizados em duas partes:

* *Parte 1:* exercícios fáceis, cada um com *uma entidade* e *um caso de uso*.
* *Parte 2:* exercícios intermediários, cada entidade possui *múltiplos casos de uso* e regras adicionais de negócio.

---

## 📂 Estrutura dos Exercícios

### Parte 1 – Exercícios fáceis

1. *Cadastro de Aluno*

   * Entidade: Aluno (nome, matrícula, curso)
   * Caso de uso: CadastrarAluno
   * Repositório: AlunoRepository (em memória)
   * Objetivo: Introduzir Clean Architecture básico.

2. *Listagem de Funcionários*

   * Entidade: Funcionario (nome, cargo, salário)
   * Caso de uso: ListarFuncionarios
   * Repositório: FuncionarioRepository
   * Objetivo: Praticar DTOs de saída.

3. *Buscar Filme por Título*

   * Entidade: Filme (título, gênero, ano)
   * Caso de uso: BuscarFilmePorTitulo
   * Regra: lançar exceção se não encontrado.
   * Objetivo: Introduzir erros de negócio.

---

### Parte 2 – Exercícios intermediários

4. *Sistema de Reservas de Quartos*

   * Entidade: Quarto (número, tipo, status)
   * Casos de uso: CadastrarQuarto, ListarQuartos, ReservarQuarto
   * Objetivo: múltiplos casos de uso na mesma entidade.

5. *Gerenciamento de Tarefas*

   * Entidade: Tarefa (descrição, status)
   * Casos de uso: CriarTarefa, ListarTarefasPendentes, ConcluirTarefa

6. *Sistema de Pedidos de Lanchonete*

   * Entidades:

     * Lanche (nome, preço, disponibilidade)
     * Pedido (lista de lanches, valor total, status)
   * Casos de uso: CadastrarLanche, ListarLanches, CriarPedido, FinalizarPedido
   * Regras extras:

     * Não permitir incluir lanche indisponível.
     * Pedido finalizado não pode ser alterado.

---
## 🧪 Como testar e validar os exercícios

Os testes estão organizados por caso de uso e podem ser rodados via Maven (mvn test).
Sugestões de validação:

* *Exercício 1 – Cadastro de Aluno*

  * Criar um objeto Aluno.
  * Executar CadastrarAluno.
  * Verificar se o AlunoRepository contém o aluno cadastrado.

* *Exercício 2 – Listagem de Funcionários*

  * Inserir funcionários no FuncionarioRepository.
  * Executar ListarFuncionarios.
  * Validar se retorna a lista completa de DTOs.

* *Exercício 3 – Buscar Filme por Título*

  * Adicionar filmes no FilmeRepository.
  * Buscar um título existente (deve retornar o filme).
  * Buscar título inexistente (deve lançar exceção).

* *Exercício 4 – Reservas de Quartos*

  * Cadastrar quartos.
  * Listar todos.
  * Reservar um quarto → status muda para *ocupado*.

* *Exercício 5 – Gerenciamento de Tarefas*

  * Criar tarefas.
  * Listar pendentes.
  * Concluir tarefa → status muda para *concluída*.

* *Exercício 6 – Pedidos de Lanchonete*

  * Cadastrar lanches (disponíveis e indisponíveis).
  * Criar pedido válido → valor total calculado.
  * Tentar incluir lanche indisponível → deve falhar.
  * Finalizar pedido → não deve permitir alterações posteriores.

---
## 📚 Objetivo do projeto

Este repositório serve como *laboratório prático* para estudar *Clean Architecture em Java*.
A ideia é começar simples (uma entidade + um caso de uso) e evoluir até cenários mais complexos com múltiplas entidades e validações de negócio.
