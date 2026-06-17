package Hospital.model;

public class Medico extends Pessoa {

    private String crm;
    private Especialidade especialidade;


    public Medico(int id, String nome, String crm, Especialidade especialidade, String cpf) {
        super(id, nome, cpf);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", crm='" + crm + '\'' +
                ", especialidade=" +
                especialidade.getNome() +
                '}';
    }
}
