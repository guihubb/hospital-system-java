package Hospital.controller;

import Hospital.model.Convenio;
import Hospital.model.Paciente;
import Hospital.service.ConvenioService;
import Hospital.service.PacienteService;

import java.util.List;

public class PacienteController {
    private PacienteService service;
    private ConvenioService convenioService;

    public PacienteController(PacienteService service, ConvenioService convenioService) {
        this.service = service;
        this.convenioService = convenioService;
    }

    public String processarCadastro(int id, String nome, String cpf, int idConvenio) {
        Convenio convenio = convenioService.buscarConvenio(idConvenio);
        return service.cadastrarPaciente(id, nome, cpf, convenio);
    }

    public List<Paciente> processarListagem() {
        return service.listarPacientes();
    }

    public Paciente processarBusca(int id) {
        return service.buscarPaciente(id);
    }

    public String processarRemocao(int id) {
        return service.removerPaciente(id);
    }
}