package Hospital.repository;

import Hospital.model.Quarto;

import java.util.ArrayList;
import java.util.List;

public class QuartoRepository {
    private List<Quarto> bancoDeDados = new ArrayList<>();

    public void salvar(Quarto quarto) {
        bancoDeDados.add(quarto);
    }

    public Quarto buscarPorNumero(int numero) {
        for (Quarto q : bancoDeDados) {
            if (q.getNumero() == numero) {
                return q;
            }
        }
        return null;
    }
}
