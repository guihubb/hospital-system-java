package Hospital.model;

public class Paciente extends Pessoa {

    private Convenio convenio;

    public Paciente(int id, String nome, String cpf, Convenio convenio) {
        super(id, nome, cpf);
        this.cpf = cpf;
        this.convenio = convenio;
    }

    public Convenio getConvenio() { return convenio; }
    public void setConvenio(Convenio convenio) { this.convenio = convenio; }

    @Override
    public String toString() {
        String nomeConvenio = (convenio != null) ? convenio.getNome() : "Particular (Sem Convênio)";

        return "Paciente [ID=" + getId() + " | Nome=" + getNome() + " | CPF=" + getCpf() + " | Convênio=" + nomeConvenio + "]";
    }
}