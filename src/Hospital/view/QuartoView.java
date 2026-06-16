package Hospital.view;

import Hospital.controller.QuartoController;

import javax.swing.JOptionPane;

public class QuartoView {
    private QuartoController controller;

    public QuartoView(QuartoController controller) {
        this.controller = controller;
    }

    public void exibirTelaCadastro() {
        try {
            String numStr = JOptionPane.showInputDialog("Digite o número do Quarto:");
            int numero = Integer.parseInt(numStr);

            String menuTipo = "Escolha o tipo do quarto:\n1 - Enfermaria\n2 - UTI";
            String tipoStr = JOptionPane.showInputDialog(menuTipo);
            int tipo = Integer.parseInt(tipoStr);


            String mensagem = controller.processarCadastro(numero, tipo);
            JOptionPane.showMessageDialog(null, mensagem);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Digite apenas números válidos.");
        }
    }
}
