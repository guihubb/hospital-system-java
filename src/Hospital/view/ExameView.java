package Hospital.view;

import Hospital.model.Exame;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ExameView {
    private Scanner scanner;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ExameView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("\n--- Menu de Exames ---");
        System.out.println("1. Adicionar Exame");
        System.out.println("2. Listar Exames");
        System.out.println("3. Buscar Exame por ID");
        System.out.println("4. Atualizar Exame");
        System.out.println("5. Cancelar Exame");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }

    public int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String lerTipoExame() {
        System.out.print("Tipo do exame: ");
        return scanner.nextLine();
    }

    public Date lerDataExame() {
        System.out.print("Data do exame (dd/MM/yyyy): ");
        try {
            return dateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
            return lerDataExame();
        }
    }

    public String lerPacienteExame() {
        System.out.print("Nome do paciente: ");
        return scanner.nextLine();
    }

    public String lerResultadoExame() {
        System.out.print("Resultado do exame (ou digite 'Aguardando'): ");
        return scanner.nextLine();
    }

    public int lerIdExame() {
        System.out.print("ID do exame: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Insira um número.");
            return lerIdExame();
        }
    }

    public void exibirListaExames(List<Exame> exames) {
        if (exames.isEmpty()) {
            System.out.println("Nenhum exame encontrado.");
        } else {
            System.out.println("\n--- Lista de Exames ---");
            for (Exame exame : exames) {
                System.out.println("ID: " + exame.getId() +
                        " | Tipo: " + exame.getTipo() +
                        " | Data: " + dateFormat.format(exame.getData()) +
                        " | Paciente: " + exame.getPaciente());
            }
        }
    }

    public void exibirDetalhesExame(Exame exame) {
        System.out.println("\n--- Detalhes do Exame ---");
        System.out.println("ID: " + exame.getId());
        System.out.println("Tipo: " + exame.getTipo());
        System.out.println("Data: " + dateFormat.format(exame.getData()));
        System.out.println("Paciente: " + exame.getPaciente());
        System.out.println("Resultado: " + exame.getResultado());
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
