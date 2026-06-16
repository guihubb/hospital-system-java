package Hospital.controller;

import Hospital.model.Convenio;
import Hospital.service.ConvenioService;

import java.util.List;

public class ConvenioController {
    private ConvenioService service;

    public ConvenioController(ConvenioService service) {
        this.service = service;
    }

    public String processarCadastro(int id, String nome, int tipoCategoria) {
        return service.cadastrarConvenio(id, nome, tipoCategoria);
    }

    public List<Convenio> processarListagem() {
        return service.listarConvenios();
    }

    public Convenio processarBusca(int id) {
        return service.buscarConvenio(id);
    }

    public String processarRemocao(int id) {
        return service.removerConvenio(id);
    }

    public String simularCalculoExame(int idConvenio, double valorExame) {
        Convenio c = service.buscarConvenio(idConvenio);
        if (c == null) {
            return "Convênio não encontrado. Valor integral: R$ " + valorExame;
        }

        double desconto = c.calcularDescontoExame(valorExame);
        double valorFinal = valorExame - desconto;

        return "Convênio: " + c.getNome() +
                "\nValor Original: R$ " + valorExame +
                "\nDesconto Concedido: R$ " + desconto +
                "\nValor Final Líquido: R$ " + valorFinal;
    }
}