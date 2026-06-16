package Hospital.view;

import Hospital.controller.InternacaoController;

import javax.swing.JOptionPane;

public class InternacaoView {
    private InternacaoController controller;

    public InternacaoView(InternacaoController controller) {
        this.controller = controller;
    }

    public void exibirTelaInternacao() {
        String paciente = JOptionPane.showInputDialog("Nome do Paciente:");
        if (paciente != null && !paciente.isEmpty()) {
            try {
                String numStr = JOptionPane.showInputDialog("Número do Quarto para internar:");
                int numeroQuarto = Integer.parseInt(numStr);

                String mensagem = controller.processarInternacao(paciente, numeroQuarto);
                JOptionPane.showMessageDialog(null, mensagem);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro: Digite um número de quarto válido.");
            }
        }
    }
}
