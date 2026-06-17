package Hospital.view;

import Hospital.controller.ConvenioController;
import Hospital.model.Convenio;

import java.util.List;
import java.util.Scanner;

public class ConvenioView {
    private ConvenioController controller;
    private Scanner scanner;

    public ConvenioView(ConvenioController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- TELA DE CONVÊNIOS ---");
            System.out.println("1. Cadastrar Convênio");
            System.out.println("2. Listar Convênios");
            System.out.println("3. Simular Desconto de Exame");
            System.out.println("4. Remover Convênio");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada inválida!");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    telaCadastro();
                    break;
                case 2:
                    telaListagem();
                    break;
                case 3:
                    telaSimulacao();
                    break;
                case 4:
                    telaRemocao();
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void telaCadastro() {
        System.out.println("\n[Cadastro de Convênio]");
        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o Nome do Convênio: ");
        String nome = scanner.nextLine();

        System.out.println("Selecione a Categoria de Plano:");
        System.out.println("1 - Padrão");
        System.out.println("2 - Prata (15% de Desconto)");
        System.out.println("3 - Ouro (30% de Desconto)");
        System.out.print("Opção: ");
        int categoria = scanner.nextInt();
        scanner.nextLine();

        String resultado = controller.processarCadastro(id, nome, categoria);
        System.out.println(resultado);
    }

    private void telaListagem() {
        System.out.println("\n[Lista de Convênios]");
        List<Convenio> lista = controller.processarListagem();
        if (lista.isEmpty()) {
            System.out.println("Nenhum convênio registrado.");
        } else {
            for (Convenio c : lista) {
                System.out.println(c);
            }
        }
    }

    private void telaSimulacao() {
        System.out.println("\n[Simulação de Desconto]");
        System.out.print("Digite o ID do Convênio: ");
        int id = scanner.nextInt();
        System.out.print("Digite o valor bruto do Exame: R$ ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        String resultado = controller.simularCalculoExame(id, valor);
        System.out.println("\n" + resultado);
    }

    private void telaRemocao() {
        System.out.println("\n[Remover Convênio]");
        System.out.print("Digite o ID do convênio a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String resultado = controller.processarRemocao(id);
        System.out.println(resultado);
    }
}