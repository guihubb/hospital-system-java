package Hospital.model;

import java.util.Date;

public class Exame {
    private int id;
    private String tipo;
    private Date data;
    private String paciente;
    private String resultado;

    public Exame() {
    }

    public Exame(int id, String tipo, Date data, String paciente, String resultado) {
        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.paciente = paciente;
        this.resultado = resultado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
