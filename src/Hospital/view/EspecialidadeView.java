package Hospital.view;

import Hospital.controller.EspecialidadeController;
import Hospital.model.Especialidade;

import java.util.Scanner;

public class EspecialidadeView {

    private EspecialidadeController controller;
    private Scanner scanner = new Scanner(System.in);

    public EspecialidadeView(EspecialidadeController controller) {

        this.controller = controller;
    }

    public void exibirMenu() {

        int opcao = -1;

        while(opcao != 0){

            System.out.println("\n=== MENU ESPECIALIDADE ===");
            System.out.println("1 - Cadastrar Especialidade");
            System.out.println("2 - Listar Especialidades");
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

                    Especialidade especialidade = new Especialidade(id, nome);

                    controller.cadastrar(especialidade);

                    System.out.println("Especialidade cadastrada!");
                    break;

                case 2:

                    System.out.println("\nLista de Especialidades:");

                    for(Especialidade e : controller.listar()) {
                        System.out.println(e);
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
