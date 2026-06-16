package Hospital.service;

import Hospital.model.Exame;
import Hospital.repository.ExameRepository;
import java.util.List;

public class ExameService {
    private ExameRepository repository;

    public ExameService(ExameRepository repository) {
        this.repository = repository;
    }

    public void registrarExame(Exame exame) {
        if (exame.getTipo() == null || exame.getTipo().isEmpty()) {
            throw new IllegalArgumentException("Tipo do exame é obrigatório.");
        }
        if (exame.getPaciente() == null || exame.getPaciente().isEmpty()) {
            throw new IllegalArgumentException("Nome do paciente é obrigatório.");
        }
        repository.addExame(exame);
    }

    public Exame buscarExame(int id) {
        return repository.getExameById(id);
    }

    public List<Exame> listarTodosExames() {
        return repository.getAllExames();
    }

    public void atualizarExame(Exame exame) {
        if (buscarExame(exame.getId()) == null) {
            throw new IllegalArgumentException("Exame não encontrado.");
        }
        repository.updateExame(exame);
    }

    public void cancelarExame(int id) {
        if (buscarExame(id) == null) {
            throw new IllegalArgumentException("Exame não encontrado.");
        }
        repository.deleteExame(id);
    }
}
