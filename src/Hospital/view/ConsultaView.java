package Hospital.view;

import Hospital.model.Consulta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsultaView {
    private Scanner scanner;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ConsultaView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("\n--- Menu de Consultas ---");
        System.out.println("1. Adicionar Consulta");
        System.out.println("2. Listar Consultas");
        System.out.println("3. Buscar Consulta por ID");
        System.out.println("4. Atualizar Consulta");
        System.out.println("5. Cancelar Consulta");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public Date lerDataConsulta() {
        System.out.print("Data da consulta (dd/MM/yyyy): ");
        try {
            return dateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
            return lerDataConsulta();
        }
    }

    public String lerMedicoConsulta() {
        System.out.print("Nome do médico: ");
        return scanner.nextLine();
    }

    public String lerPacienteConsulta() {
        System.out.print("Nome do paciente: ");
        return scanner.nextLine();
    }

    public String lerDescricaoConsulta() {
        System.out.print("Descrição da consulta: ");
        return scanner.nextLine();
    }

    public int lerIdConsulta() {
        System.out.print("ID da consulta: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Insira um número.");
            return lerIdConsulta();
        }
    }

    public void exibirListaConsultas(List<Consulta> consultas) {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta encontrada.");
        } else {
            System.out.println("\n--- Lista de Consultas ---");
            for (Consulta consulta : consultas) {
                System.out.println("ID: " + consulta.getId() +
                        " | Data: " + dateFormat.format(consulta.getData()) +
                        " | Médico: " + consulta.getMedico() +
                        " | Paciente: " + consulta.getPaciente());
            }
        }
    }

    public void exibirDetalhesConsulta(Consulta consulta) {
        System.out.println("\n--- Detalhes da Consulta ---");
        System.out.println("ID: " + consulta.getId());
        System.out.println("Data: " + dateFormat.format(consulta.getData()));
        System.out.println("Médico: " + consulta.getMedico());
        System.out.println("Paciente: " + consulta.getPaciente());
        System.out.println("Descrição: " + consulta.getDescricao());
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
