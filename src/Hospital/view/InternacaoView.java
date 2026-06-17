package Hospital.view;

import Hospital.controller.InternacaoController;
import java.util.Scanner;

public class InternacaoView {
    private InternacaoController controller;

    public InternacaoView(InternacaoController controller) {
        this.controller = controller;
    }

    public void exibirTelaInternacao() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do Paciente: ");
        String paciente = scanner.nextLine();

        if (paciente != null && !paciente.isEmpty()) {
            try {
                System.out.print("Número do Quarto para internar: ");
                String numStr = scanner.nextLine();
                int numeroQuarto = Integer.parseInt(numStr);

                String mensagem = controller.processarInternacao(paciente, numeroQuarto);

                System.out.println("\n--- Status da Internação ---");
                System.out.println(mensagem);
                System.out.println("----------------------------");

            } catch (NumberFormatException e) {
                System.out.println("\n[ERRO] Erro: Digite um número de quarto válido.");
            }
        }
    }
}
