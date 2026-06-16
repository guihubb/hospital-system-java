package Hospital.model;

public class Convenio {
    private int id;
    private String nome;

    public Convenio(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double calcularDescontoExame(double valorBase) {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Convênio [ID: " + id + " | Nome: " + nome + " | Categoria: Padrão (0% Desc)]";
    }
}

