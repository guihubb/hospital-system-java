package Hospital.service;
import Hospital.model.Especialidade;
import Hospital.repository.EspecialidadeRepository;

import java.util.List;
public class EspecialidadeService {

    private EspecialidadeRepository repository;

    public EspecialidadeService(
            EspecialidadeRepository repository) {

        this.repository = repository;
    }

    public void cadastrar(
            Especialidade especialidade) {

        repository.salvar(especialidade);
    }

    public List<Especialidade> listar() {
        return repository.listar();
    }
}