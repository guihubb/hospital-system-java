package Hospital.repository;

import Hospital.model.Internacao;

import java.util.ArrayList;
import java.util.List;

public class InternacaoRepository {
    private List<Internacao> internacoes = new ArrayList<>();

    public void salvar(Internacao internacao) {
        internacoes.add(internacao);
    }
}
