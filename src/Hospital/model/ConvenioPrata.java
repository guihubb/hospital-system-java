package Hospital.model;

public class ConvenioPrata extends Convenio {
    public ConvenioPrata(int id, String nome) {
        super(id, nome);
    }

    @Override
    public double calcularDescontoExame(double valorBase) {
        return valorBase * 0.15;
    }

    @Override
    public String toString() {
        return "Convênio [ID: " + getId() + " | Nome: " + getNome() + " | Categoria: PRATA (15% Desc)]";
    }
}
