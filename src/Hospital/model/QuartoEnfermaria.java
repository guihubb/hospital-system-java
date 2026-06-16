package Hospital.model;

public class QuartoEnfermaria extends Quarto {
    public QuartoEnfermaria(int numero) { super(numero); }
    @Override
    public String getTipo() { return "Enfermaria"; }
    @Override
    public double calcularDiaria() { return 150.0; }
}
