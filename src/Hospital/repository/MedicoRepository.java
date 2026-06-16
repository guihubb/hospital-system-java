package Hospital.repository;
import Hospital.model.Medico;

import java.util.ArrayList;
import java.util.List;
public class MedicoRepository {

    private List<Medico> medicos =
            new ArrayList<>();

    public void salvar(Medico medico) {
        medicos.add(medico);
    }

    public List<Medico> listar() {
        return medicos;
    }
}