package Hospital.model;

public class Internacao {
    private String nomePaciente;
    private Quarto quarto;

    public Internacao(String nomePaciente, Quarto quarto) {
        this.nomePaciente = nomePaciente;
        this.quarto = quarto;
    }

    public String getNomePaciente() { return nomePaciente; }
    public Quarto getQuarto() { return quarto; }
}
