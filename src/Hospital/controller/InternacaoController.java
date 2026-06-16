package Hospital.controller;

import Hospital.service.InternacaoService;

public class InternacaoController {
    private InternacaoService service;

    public InternacaoController(InternacaoService service) {
        this.service = service;
    }

    public String processarInternacao(String paciente, int numeroQuarto) {
        try {
            service.realizarInternacao(paciente, numeroQuarto);
            return "Sucesso: Paciente " + paciente + " internado no quarto " + numeroQuarto;
        } catch (Exception e) {
            return "Falha na Internação: " + e.getMessage();
        }
    }
}
