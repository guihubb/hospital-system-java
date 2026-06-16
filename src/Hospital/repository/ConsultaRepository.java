package Hospital.repository;

import Hospital.model.Consulta;
import java.util.ArrayList;
import java.util.List;

public class ConsultaRepository {
    private List<Consulta> consultas = new ArrayList<>();
    private int nextId = 1;

    public void addConsulta(Consulta consulta) {
        consulta.setId(nextId++);
        consultas.add(consulta);
    }

    public Consulta getConsultaById(int id) {
        for (Consulta consulta : consultas) {
            if (consulta.getId() == id) {
                return consulta;
            }
        }
        return null;
    }

    public List<Consulta> getAllConsultas() {
        return new ArrayList<>(consultas);
    }

    public void updateConsulta(Consulta updatedConsulta) {
        for (int i = 0; i < consultas.size(); i++) {
            if (consultas.get(i).getId() == updatedConsulta.getId()) {
                consultas.set(i, updatedConsulta);
                return;
            }
        }
    }

    public void deleteConsulta(int id) {
        consultas.removeIf(consulta -> consulta.getId() == id);
    }
}
