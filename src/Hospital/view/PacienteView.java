package Hospital.view;

import Hospital.controller.PacienteController;
import Hospital.model.Paciente;

import java.util.List;
import java.util.Scanner;

public class PacienteView {
    private PacienteController controller;
    private Scanner scanner;

    public PacienteView(PacienteController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- TELA DE PACIENTES ---");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Listar Pacientes");
            System.out.println("3. Buscar Paciente por ID");
            System.out.println("4. Remover Paciente");
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
                    telaBusca();
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
        System.out.println("\n[Cadastro de Paciente]");
        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o ID do Convênio (ou 0 para Particular): ");
        int idConvenio = scanner.nextInt();
        scanner.nextLine();

        String resultado = controller.processarCadastro(id, nome, cpf, idConvenio);
        System.out.println(resultado);
    }

    private void telaListagem() {
        System.out.println("\n[Lista de Pacientes]");
        List<Paciente> lista = controller.processarListagem();
        if (lista.isEmpty()) {
            System.out.println("Nenhum paciente registrado.");
        } else {
            for (Paciente p : lista) {
                System.out.println(p);
            }
        }
    }

    private void telaBusca() {
        System.out.println("\n[Buscar Paciente]");
        System.out.print("Digite o ID desejado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Paciente p = controller.processarBusca(id);
        if (p != null) {
            System.out.println("Resultado: " + p);
        } else {
            System.out.println("Paciente não encontrado!");
        }
    }

    private void telaRemocao() {
        System.out.println("\n[Remover Paciente]");
        System.out.print("Digite o ID do paciente a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String resultado = controller.processarRemocao(id);
        System.out.println(resultado);
    }
}