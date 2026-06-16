package Hospital.service;

import Hospital.model.Consulta;
import Hospital.repository.ConsultaRepository;
import java.util.List;

public class ConsultaService {
    private ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public void registrarConsulta(Consulta consulta) {
        if (consulta.getMedico() == null || consulta.getMedico().isEmpty()) {
            throw new IllegalArgumentException("Nome do médico é obrigatório.");
        }
        if (consulta.getPaciente() == null || consulta.getPaciente().isEmpty()) {
            throw new IllegalArgumentException("Nome do paciente é obrigatório.");
        }
        repository.addConsulta(consulta);
    }

    public Consulta buscarConsulta(int id) {
        return repository.getConsultaById(id);
    }

    public List<Consulta> listarTodasConsultas() {
        return repository.getAllConsultas();
    }

    public void atualizarConsulta(Consulta consulta) {
        if (buscarConsulta(consulta.getId()) == null) {
            throw new IllegalArgumentException("Consulta não encontrada.");
        }
        repository.updateConsulta(consulta);
    }

    public void cancelarConsulta(int id) {
        if (buscarConsulta(id) == null) {
            throw new IllegalArgumentException("Consulta não encontrada.");
        }
        repository.deleteConsulta(id);
    }
}
