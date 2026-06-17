package Hospital.repository;

import Hospital.model.Consulta;
import Hospital.model.Prontuario;
import Hospital.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class ConsultaRepository {
    private final String CAMINHO_ARQUIVO = "dados/consultas.json";
    private List<Consulta> consultas;
    private int nextId = 1;

    private List<Consulta> lerArquivo(){
        consultas = JsonUtil.ler(CAMINHO_ARQUIVO, Consulta.class);

        return  consultas != null ? consultas : new ArrayList<>();
    }

    public void addConsulta(Consulta consulta) {
        consulta.setId(nextId++);
        List<Consulta> consultas = lerArquivo();
        consultas.add(consulta);
        JsonUtil.salvar(CAMINHO_ARQUIVO, consultas);
    }

    public Consulta getConsultaById(int id) {
        List<Consulta> consultas = lerArquivo();
        for (Consulta consulta : consultas) {
            if (consulta.getId() == id) {
                return consulta;
            }
        }
        return null;
    }

    public List<Consulta> getAllConsultas() {
        return lerArquivo();
    }

    public void updateConsulta(Consulta updatedConsulta) {
        List<Consulta> consultas = lerArquivo();
        for (int i = 0; i < consultas.size(); i++) {
            if (consultas.get(i).getId() == updatedConsulta.getId()) {

                consultas.set(i, updatedConsulta);
                JsonUtil.salvar(CAMINHO_ARQUIVO, consultas);
                return;
            }
        }
    }

    public void deleteConsulta(int id) {
        List<Consulta> consultas = lerArquivo();
        consultas.removeIf(consulta -> consulta.getId() == id);
        JsonUtil.salvar(CAMINHO_ARQUIVO, consultas);
    }
}
