package Hospital.repository;

import Hospital.model.Exame;
import Hospital.model.Prontuario;
import Hospital.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class ExameRepository {
    private List<Exame> exames;
    private int nextId = 1;

    private final String CAMINHO_ARQUIVO = "dados/exames.json";

    private List<Exame> lerArquivo(){
        exames = JsonUtil.ler(CAMINHO_ARQUIVO, Exame.class);

        return  exames != null ? exames : new ArrayList<>();
    }

    public void addExame(Exame exame) {
        exame.setId(nextId++);
        List<Exame> exames = lerArquivo();
        exames.add(exame);
        JsonUtil.salvar(CAMINHO_ARQUIVO, exames);
    }

    public Exame getExameById(int id) {
        List<Exame> exames = lerArquivo();
        for (Exame exame : exames) {
            if (exame.getId() == id) {
                return exame;
            }
        }
        return null;
    }

    public List<Exame> getAllExames() {
        return lerArquivo();
    }

    public void updateExame(Exame updatedExame) {
        List<Exame> exames = lerArquivo();
        for (int i = 0; i < exames.size(); i++) {
            if (exames.get(i).getId() == updatedExame.getId()) {
                exames.set(i, updatedExame);
                JsonUtil.salvar(CAMINHO_ARQUIVO, exames);
                return;
            }
        }
    }

    public void deleteExame(int id) {
        List<Exame> exames = lerArquivo();
        exames.removeIf(exame -> exame.getId() == id);
        JsonUtil.salvar(CAMINHO_ARQUIVO, exames);
    }
}
