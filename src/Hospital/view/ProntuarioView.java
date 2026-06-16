package Hospital.view;

import Hospital.controller.ProntuarioController;
import Hospital.model.Prontuario;
import Hospital.util.InputHelper;

import java.util.ArrayList;
import java.util.List;

public class ProntuarioView {
    private final ProntuarioController controller = new ProntuarioController();

    public void exibirFormularioCriacao(){
        System.out.println("\n=== EMISSÃO DE NOVO PRONTUÁRIO ===");

        String idPaciente = InputHelper.lerString("Digite o ID do Paciente");
        String historico = InputHelper.lerString("Digite o histórico Clínico Inicial");

        List<String> alergias = new ArrayList<>();
        System.out.println("Digite as alergias do paciente (ou digite 'FIM' para iniciar):");
        while (true){
            String alergia = InputHelper.lerString("- Alergia");
            if (alergia.equalsIgnoreCase("FIM")){
                break;
            }
            if (!alergia.trim().isEmpty()){
                alergias.add(alergia);
            }
        }

        controller.processarCriacao(idPaciente, historico, alergias);
    }

    public void exibirProntuarioCompleto(Prontuario p){
        if (p == null){
            System.out.println("\n  Nenhum prontuário encontrado para exibição.");
            return;
        }

        System.out.println("\n==================================================");
        System.out.println("              PRONTUÁRIO MÉDICO                   ");
        System.out.println("==================================================");
        System.out.println("ID do Prontuário : " + p.getId());
        System.out.println("ID do Paciente   : " + p.getIdPaciente());
        System.out.println("Data de Criação  : " + p.getDataCriacao());
        System.out.println("Histórico Clínico: " + p.getHistoricoClinico());
        System.out.println("--------------------------------------------------");

        System.out.println("ALERGIAS REGISTRADAS:");
        if (p.getAlergias() == null || p.getAlergias().isEmpty()){
            System.out.println(" -> Nenhuma alergia informada");
        } else {
            for (String alergia : p.getAlergias()){
                System.out.println("  * " + alergia);
            }
        }
        System.out.println("--------------------------------------------------");

        System.out.println("HISTÓRICO DE CONSULTAS (IDs):");
        if (p.getIdConsultas() == null || p.getIdConsultas().isEmpty()){
            System.out.println(" -> Nenhuma consulta vinculada a este prontuário.");
        } else {
            for (String idConsulta : p.getIdConsultas()){
                System.out.println("  * Consulta código: " + idConsulta);
            }
        }
        System.out.println("==================================================");
    }

    public void exibirMenu(){
        int op = -1;
        while (op !=0){
            System.out.println("\n--- MENU PRONTUÁRIO ---");
            System.out.println("1. Emitir Novo Prontuário");
            System.out.println("2. Buscar Prontuário por Paciente");
            System.out.println("0. Sair");

            op = InputHelper.lerInt("Escolha uma opção: ");
            try {
                switch (op){
                    case 1:
                        exibirFormularioCriacao();
                        break;
                    case 2:
                        String idBuscado = InputHelper.lerString("\nDigite o ID do paciente para busca: ");
                        Prontuario encontrado = controller.processarBuscaPorPaciente(idBuscado);
                        exibirProntuarioCompleto(encontrado);
                        break;
                    case 0:
                        System.out.println("Saindo do módulo de Prontuários...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido");
            }
        }
    }
}
