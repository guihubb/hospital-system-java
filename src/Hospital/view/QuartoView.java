package Hospital.view;

import Hospital.controller.QuartoController;
import java.util.Scanner;

public class QuartoView {
    private QuartoController controller;

    public QuartoView(QuartoController controller) {
        this.controller = controller;
    }

    public void exibirTelaCadastro() {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Digite o número do Quarto: ");
            String numStr = scanner.nextLine();
            int numero = Integer.parseInt(numStr);

            System.out.println("\nEscolha o tipo do quarto:");
            System.out.println("1 - Enfermaria");
            System.out.println("2 - UTI");
            System.out.print("Opção: ");

            String tipoStr = scanner.nextLine();
            int tipo = Integer.parseInt(tipoStr);

            String mensagem = controller.processarCadastro(numero, tipo);

            System.out.println("\n--- Status do Cadastro ---");
            System.out.println(mensagem);
            System.out.println("--------------------------");

        } catch (NumberFormatException e) {
            System.out.println("\n[ERRO] Erro: Digite apenas números válidos.");
        }
    }
}