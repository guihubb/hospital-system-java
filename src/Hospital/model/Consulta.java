package Hospital.model;

import java.util.Date;

public class Consulta {
    private int id;
    private String paciente;
    private String medico;
    private Date data;
    private String descricao;

    public Consulta() {
    }

    public Consulta(int id, String paciente, String medico, Date data, String descricao) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
