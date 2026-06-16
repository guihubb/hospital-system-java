package Hospital.repository;

import Hospital.model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteRepository {
    private List<Paciente> pacientes = new ArrayList<>();

    public void salvar(Paciente paciente) {
        pacientes.add(paciente);
    }

    public List<Paciente> listarTodos() {
        return pacientes;
    }

    public Paciente buscarPorId(int id) {
        for (Paciente p : pacientes) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean deletar(int id) {
        Paciente p = buscarPorId(id);
        if (p != null) {
            pacientes.remove(p);
            return true;
        }
        return false;
    }
}