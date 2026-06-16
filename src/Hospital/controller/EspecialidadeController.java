package Hospital.controller;

import Hospital.model.Especialidade;
import Hospital.service.EspecialidadeService;
import java.util.List;
public class EspecialidadeController {

    private EspecialidadeService service;

    public EspecialidadeController(
            EspecialidadeService service) {

        this.service = service;
    }

    public void cadastrar(
            Especialidade especialidade) {

        service.cadastrar(especialidade);
    }

    public List<Especialidade> listar() {
        return service.listar();
    }
}
