package Hospital.repository;
import Hospital.model.Especialidade;
import Hospital.model.Prontuario;
import Hospital.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;
public class EspecialidadeRepository {

    private final String CAMINHO_ARQUIVO = "dados/especialidades.json";

    List<Especialidade> especialidades;

    private List<Especialidade> lerArquivo(){
        especialidades = JsonUtil.ler(CAMINHO_ARQUIVO, Especialidade.class);

        return  especialidades != null ? especialidades : new ArrayList<>();
    }

    public void salvar(Especialidade especialidade) {
        List<Especialidade> especialidades = lerArquivo();
        especialidades.add(especialidade);
        JsonUtil.salvar(CAMINHO_ARQUIVO, especialidades);
    }

    public List<Especialidade> listar() {
        return lerArquivo();
    }
}
