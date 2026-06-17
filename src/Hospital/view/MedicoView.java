package Hospital.view;

import Hospital.controller.MedicoController;
import Hospital.model.Especialidade;
import Hospital.model.Medico;

import java.util.Scanner;

public class MedicoView {

    private MedicoController controller;
    private Scanner scanner;

    public MedicoView(MedicoController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {

        int opcao = -1;

        while(opcao != 0){

            System.out.println("\n=== MENU MÉDICO ===");
            System.out.println("1 - Cadastrar Médico");
            System.out.println("2 - Listar Médicos");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){

                case 1:

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("CRM: ");
                    String crm = scanner.nextLine();

                    System.out.print("ID Especialidade: ");
                    int idEsp = scanner.nextInt();
                    scanner.nextLine();

                    Especialidade especialidade = new Especialidade(idEsp, "Especialidade");

                    Medico medico = new Medico(id, nome, crm, especialidade, cpf);

                    controller.cadastrar(medico);

                    System.out.println("Médico cadastrado!");
                    break;

                case 2:

                    System.out.println("\nLista de Médicos:");

                    for(Medico m : controller.listar()){
                        System.out.println(m);
                    }

                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
