package Hospital.repository;

import Hospital.model.Internacao;
import Hospital.model.Prontuario;
import Hospital.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class InternacaoRepository {

    private final String CAMINHO_ARQUIVO = "dados/internacoes.json";
    private List<Internacao> internacoes;

    private List<Internacao> lerArquivo(){
        internacoes = JsonUtil.ler(CAMINHO_ARQUIVO, Internacao.class);

        return  internacoes != null ? internacoes : new ArrayList<>();
    }

    public void salvar(Internacao internacao) {
        List<Internacao> internacoes = lerArquivo();
        internacoes.add(internacao);
        JsonUtil.salvar(CAMINHO_ARQUIVO, internacoes);
    }
}
