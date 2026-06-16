package Hospital.service;

import Hospital.model.Quarto;
import Hospital.model.QuartoEnfermaria;
import Hospital.model.QuartoUTI;
import Hospital.repository.QuartoRepository;

public class QuartoService {
    private QuartoRepository repository;

    public QuartoService(QuartoRepository repository) {
        this.repository = repository;
    }

    public void cadastrarQuarto(int numero, int tipo) throws Exception {

        if (numero <= 0) {
            throw new Exception("O número do quarto deve ser maior que zero.");
        }
        if (repository.buscarPorNumero(numero) != null) {
            throw new Exception("Já existe um quarto com este número cadastrado!");
        }

        Quarto novoQuarto;

        switch (tipo) {
            case 1:
                novoQuarto = new QuartoEnfermaria(numero);
                break;
            case 2:
                novoQuarto = new QuartoUTI(numero);
                break;
            default:
                throw new Exception("Tipo de quarto inválido.");
        }

        repository.salvar(novoQuarto);
    }
}
