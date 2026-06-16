package Hospital.service;
import Hospital.model.Medico;
import Hospital.repository.MedicoRepository;

import java.util.List;
public class MedicoService {

    private MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Medico medico) {

        if(medico == null) {
            throw new IllegalArgumentException();
        }

        repository.salvar(medico);
    }

    public List<Medico> listar() {
        return repository.listar();
    }
}
