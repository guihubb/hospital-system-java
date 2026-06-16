package Hospital.model;

public class ConvenioOuro extends Convenio {
    public ConvenioOuro(int id, String nome) {
        super(id, nome);
    }

    @Override
    public double calcularDescontoExame(double valorBase) {
        return valorBase * 0.30;
    }

    @Override
    public String toString() {
        return "Convênio [ID: " + getId() + " | Nome: " + getNome() + " | Categoria: OURO (30% Desc)]";
    }
}
