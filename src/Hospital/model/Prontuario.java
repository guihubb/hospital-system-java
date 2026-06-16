package Hospital.model;

import java.util.ArrayList;
import java.util.List;

public class Prontuario {
    private String id;
    private String idPaciente;
    private List<String> idConsultas;
    private String historicoClinico;
    private List<String> alergias;
    private String dataCriacao;

    public Prontuario(String id, String paciente, String historicoClinico, String dataCriacao) {
        this.id = id;
        this.idPaciente = paciente;
        this.idConsultas = new ArrayList<>();
        this.historicoClinico = historicoClinico;
        this.alergias = new ArrayList<>();
        this.dataCriacao = dataCriacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public List<String> getIdConsultas() {
        return idConsultas;
    }

    public void setIdConsultas(List<String> idConsultas) {
        this.idConsultas = idConsultas;
    }

    public String getHistoricoClinico() {
        return historicoClinico;
    }

    public void setHistoricoClinico(String historicoClinico) {
        this.historicoClinico = historicoClinico;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
