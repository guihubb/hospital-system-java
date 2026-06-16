package Hospital.repository;
import Hospital.model.Especialidade;

import java.util.ArrayList;
import java.util.List;
public class EspecialidadeRepository {

    private List<Especialidade> especialidades =
            new ArrayList<>();

    public void salvar(Especialidade especialidade) {
        especialidades.add(especialidade);
    }

    public List<Especialidade> listar() {
        return especialidades;
    }
}
