package Hospital.controller;
import Hospital.model.Medico;
import Hospital.service.MedicoService;

import java.util.List;

public class MedicoController {

    private MedicoService service;

    public MedicoController(
            MedicoService service) {

        this.service = service;
    }

    public void cadastrar(Medico medico) {
        service.cadastrar(medico);
    }

    public List<Medico> listar() {
        return service.listar();
    }
}