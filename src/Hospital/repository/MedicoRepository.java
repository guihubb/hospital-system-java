package Hospital.repository;
import Hospital.model.Consulta;
import Hospital.model.Medico;
import Hospital.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;
public class MedicoRepository {
    private final String CAMINHO_ARQUIVO = "dados/medicos.json";

    private List<Medico> medicos;

    private List<Medico> lerArquivo(){
        medicos = JsonUtil.ler(CAMINHO_ARQUIVO, Medico.class);

        return  medicos != null ? medicos : new ArrayList<>();
    }

    public void salvar(Medico medico) {
        List<Medico> medicos = lerArquivo();
        medicos.add(medico);
        JsonUtil.salvar(CAMINHO_ARQUIVO, medicos);
    }

    public List<Medico> listar() {
        return lerArquivo();
    }
}