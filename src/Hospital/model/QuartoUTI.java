package Hospital.model;

public class QuartoUTI extends Quarto {
    public QuartoUTI(int numero) { super(numero); }
    @Override
    public String getTipo() { return "UTI"; }
    @Override
    public double calcularDiaria() { return 1200.0; }
}
