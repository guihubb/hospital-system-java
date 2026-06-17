package Hospital.repository;

import Hospital.model.Prontuario;
import Hospital.model.Quarto;
import Hospital.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class QuartoRepository {
    private final String CAMINHO_ARQUIVO = "dados/quartos.json";

    private List<Quarto> quartos;

    private List<Quarto> lerArquivo(){
        quartos = JsonUtil.ler(CAMINHO_ARQUIVO, Quarto.class);

        return  quartos != null ? quartos : new ArrayList<>();
    }

    public void salvar(Quarto quarto) {
        List<Quarto> quartos = lerArquivo();
        quartos.add(quarto);
        JsonUtil.salvar(CAMINHO_ARQUIVO, quartos);
    }

    public Quarto buscarPorNumero(int numero) {
        List<Quarto> quartos = lerArquivo();
        for (Quarto q : quartos) {
            if (q.getNumero() == numero) {
                return q;
            }
        }
        return null;
    }
}
