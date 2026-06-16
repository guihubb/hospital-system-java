package Hospital.controller;

import Hospital.service.QuartoService;

public class QuartoController {
    private QuartoService service;

    public QuartoController(QuartoService service) {
        this.service = service;
    }

    public String processarCadastro(int numero, int tipo) {
        try {
            service.cadastrarQuarto(numero, tipo);
            return "Sucesso: Quarto cadastrado!";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
}
