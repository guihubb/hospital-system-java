package Hospital.service;

import Hospital.model.Convenio;
import Hospital.model.ConvenioOuro;
import Hospital.model.ConvenioPrata;
import Hospital.repository.ConvenioRepository;

import java.util.List;

public class ConvenioService {
    private ConvenioRepository repository;

    public ConvenioService(ConvenioRepository repository) {
        this.repository = repository;
    }

    public String cadastrarConvenio(int id, String nome, int tipoCategoria) {
        if (nome == null || nome.trim().isEmpty()) {
            return "Erro: O nome do convênio não pode ser vazio.";
        }
        if (repository.buscarPorId(id) != null) {
            return "Erro: Já existe um convênio com o ID " + id;
        }

        Convenio novoConvenio;

        switch (tipoCategoria) {
            case 1:
                novoConvenio = new Convenio(id, nome);
                break;
            case 2:
                novoConvenio = new ConvenioPrata(id, nome);
                break;
            case 3:
                novoConvenio = new ConvenioOuro(id, nome);
                break;
            default:
                return "Erro: Categoria selecionada inválida.";
        }

        repository.salvar(novoConvenio);
        return "Convênio cadastrado com sucesso!";
    }

    public List<Convenio> listarConvenios() {
        return repository.listarTodos();
    }

    public Convenio buscarConvenio(int id) {
        return repository.buscarPorId(id);
    }

    public String removerConvenio(int id) {
        if (repository.deletar(id)) {
            return "Convênio removido com sucesso.";
        }
        return "Erro: Convênio não encontrado.";
    }
}