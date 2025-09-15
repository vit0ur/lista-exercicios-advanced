package exerciciosIntermediary.domain;

public class Tarefa {
    private String descricao;
    private String status; // "pendente" ou "concluída"

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.status = "pendente";
    }

    public String getDescricao() { return descricao; }
    public String getStatus() { return status; }

    public void concluir() {
        if (!status.equals("concluída")) {
            status = "concluída";
        }
    }

    @Override
    public String toString() {
        return descricao + " - " + status;
    }
}
