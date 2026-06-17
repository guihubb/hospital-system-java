package Hospital.repository;

import Hospital.model.Paciente;
import Hospital.model.Prontuario;
import Hospital.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class PacienteRepository {

    private final String CAMINHO_ARQUIVO = "dados/pacientes.json";

    private List<Paciente> pacientes;

    private List<Paciente> lerArquivo(){
        pacientes = JsonUtil.ler(CAMINHO_ARQUIVO, Paciente.class);

        return  pacientes != null ? pacientes : new ArrayList<>();
    }


    public void salvar(Paciente paciente) {
        List<Paciente> pacientes = lerArquivo();
        pacientes.add(paciente);
        JsonUtil.salvar(CAMINHO_ARQUIVO, pacientes);
    }

    public List<Paciente> listarTodos() {
        return lerArquivo();
    }

    public Paciente buscarPorId(int id) {
        List<Paciente> pacientes = lerArquivo();
        for (Paciente p : pacientes) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean deletar(int id) {
        List<Paciente> pacientes = lerArquivo();
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getId() == id) {
                pacientes.remove(i);
                JsonUtil.salvar(CAMINHO_ARQUIVO, pacientes);
                return true;
            }
        }
        return false;
    }
}