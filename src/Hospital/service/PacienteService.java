package Hospital.service;

import Hospital.model.Convenio;
import Hospital.model.Paciente;
import Hospital.repository.PacienteRepository;

import java.util.List;

public class PacienteService {
    private PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public String cadastrarPaciente(int id, String nome, String cpf, Convenio convenio) {
        if (nome == null || nome.trim().isEmpty()) {
            return "Erro: O nome do paciente não pode ser vazio.";
        }
        if (cpf == null || cpf.trim().isEmpty()) {
            return "Erro: O CPF não pode ser vazio.";
        }
        if (repository.buscarPorId(id) != null) {
            return "Erro: Já existe um paciente com o ID " + id;
        }

        Paciente novoPaciente = new Paciente(id, nome, cpf, convenio);
        repository.salvar(novoPaciente);
        return "Paciente cadastrado com sucesso!";
    }

    public List<Paciente> listarPacientes() {
        return repository.listarTodos();
    }

    public Paciente buscarPaciente(int id) {
        return repository.buscarPorId(id);
    }

    public String removerPaciente(int id) {
        if (repository.deletar(id)) {
            return "Paciente removido com sucesso.";
        }
        return "Erro: Paciente não encontrado.";
    }
}