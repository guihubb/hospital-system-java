package Hospital.repository;

import Hospital.model.Prontuario;
import Hospital.util.JsonUtil;


import java.util.ArrayList;
import java.util.List;

public class ProntuarioRepository {
    private final String CAMINHO_ARQUIVO = "dados/prontuarios.json";

    private List<Prontuario> lerArquivo(){
        List<Prontuario> prontuarios = JsonUtil.lerProntuarios(CAMINHO_ARQUIVO);

        return  prontuarios != null ? prontuarios : new ArrayList<>();
    }

    public void salvar(Prontuario p){
        List<Prontuario> prontuarios = lerArquivo();
        prontuarios.add(p);
        JsonUtil.salvarProntuarios(CAMINHO_ARQUIVO, prontuarios);
    }

    public Prontuario buscarPorId(String id){
        List<Prontuario> prontuarios = lerArquivo();
        for (Prontuario p : prontuarios){
            if (p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    public Prontuario buscarPorIdPaciente(String idPaciente){
        List<Prontuario> prontuarios = lerArquivo();
        for (Prontuario p : prontuarios){
            if (p.getIdPaciente().equals(idPaciente)){
                return p;
            }
        }
        return null;
    }

    public List<Prontuario> listarTodos(){
        return lerArquivo();
    }

    public void atualizar(Prontuario p){
        List<Prontuario> prontuarios = lerArquivo();
        boolean atualizado = false;

        for (int i = 0; i < prontuarios.size(); i++) {
            if (prontuarios.get(i).getId().equals(p.getId())){
                prontuarios.set(i, p);
                atualizado = true;
                break;
            }
        }

        if (atualizado) {
            JsonUtil.salvarProntuarios(CAMINHO_ARQUIVO, prontuarios);
        } else {
            System.out.println("Prontuário com id " + p.getId() + " não encontrado para atualização.");
        }
    }
}
