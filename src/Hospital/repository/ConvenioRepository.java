package Hospital.repository;

import Hospital.model.Convenio;
import Hospital.model.Prontuario;
import Hospital.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class ConvenioRepository {
    private final String CAMINHO_ARQUIVO = "dados/convenios.json";
    private List<Convenio> convenios;

    private List<Convenio> lerArquivo(){
        convenios = JsonUtil.ler(CAMINHO_ARQUIVO, Convenio.class);

        return  convenios != null ? convenios : new ArrayList<>();
    }

    public void salvar(Convenio convenio) {
        List<Convenio> convenios1 = lerArquivo();
        convenios1.add(convenio);
        JsonUtil.salvar(CAMINHO_ARQUIVO, convenios1);
    }

    public List<Convenio> listarTodos() {
        return lerArquivo();
    }

    public Convenio buscarPorId(int id) {
        List<Convenio> convenios1 = lerArquivo();
        for (Convenio c : convenios1) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public boolean deletar(int id) {
        Convenio c = buscarPorId(id);
        if (c != null) {
            List<Convenio> convenios1 = lerArquivo();
            convenios1.remove(c);
            JsonUtil.salvar(CAMINHO_ARQUIVO, convenios1);
            return true;
        }
        return false;
    }
}