package Hospital;

import Hospital.controller.ConsultaController;
import Hospital.controller.ExameController;
import Hospital.controller.ConvenioController;
import Hospital.controller.PacienteController;
import Hospital.controller.InternacaoController;
import Hospital.controller.QuartoController;

import Hospital.repository.ConsultaRepository;
import Hospital.repository.ExameRepository;
import Hospital.repository.ConvenioRepository;
import Hospital.repository.PacienteRepository;
import Hospital.repository.InternacaoRepository;
import Hospital.repository.QuartoRepository;

import Hospital.service.ConsultaService;
import Hospital.service.ExameService;
import Hospital.service.ConvenioService;
import Hospital.service.PacienteService;
import Hospital.service.InternacaoService;
import Hospital.service.QuartoService;

import Hospital.view.ConsultaView;
import Hospital.view.ExameView;
import Hospital.view.ConvenioView;
import Hospital.view.PacienteView;
import Hospital.view.InternacaoView;
import Hospital.view.QuartoView;

import java.util.Scanner;

public class MainOficial {
    public static void main(String[] args) {
        QuartoRepository quartoRepo = new QuartoRepository();
        InternacaoRepository internacaoRepo = new InternacaoRepository();
        QuartoService quartoService = new QuartoService(quartoRepo);
        InternacaoService internacaoService = new InternacaoService(internacaoRepo, quartoRepo);
        QuartoController quartoController = new QuartoController(quartoService);
        InternacaoController internacaoController = new InternacaoController(internacaoService);
        QuartoView quartoView = new QuartoView(quartoController);
        InternacaoView internacaoView = new InternacaoView(internacaoController);

        ConvenioRepository convenioRepo = new ConvenioRepository();
        ConvenioService convenioService = new ConvenioService(convenioRepo);
        ConvenioController convenioController = new ConvenioController(convenioService);
        ConvenioView convenioView = new ConvenioView(convenioController);
        PacienteRepository pacienteRepo = new PacienteRepository();
        PacienteService pacienteService = new PacienteService(pacienteRepo);
        PacienteController pacienteController = new PacienteController(pacienteService, convenioService);
        PacienteView pacienteView = new PacienteView(pacienteController);

        ConsultaRepository consultaRepository = new ConsultaRepository();
        ConsultaService consultaService = new ConsultaService(consultaRepository);
        ConsultaView consultaView = new ConsultaView();
        ConsultaController consultaController = new ConsultaController(consultaService, consultaView);
        ExameRepository exameRepository = new ExameRepository();
        ExameService exameService = new ExameService(exameRepository);
        ExameView exameView = new ExameView();
        ExameController exameController = new ExameController(exameService, exameView);

        //quartoView.exibirTelaCadastro(); pra nao aparecer mais
        //internacaoView.exibirTelaInternacao(); pra nao aparecer mais

        Scanner scanner = new Scanner(System.in);
        int menuPrincipal = -1;

        while (menuPrincipal != 0) {
            System.out.println("=========================================");
            System.out.println("     SISTEMA HOSPITALAR INTEGRADO        ");
            System.out.println("=========================================");
            System.out.println("0. Sair do Sistema");
            System.out.println("1. Gerenciamento de Convênios");
            System.out.println("2. Gerenciamento de Pacientes");
            System.out.println("3. Gerenciamento de Internações");
            System.out.println("4. Gerenciamento de Quartos");
            System.out.println("5. Gerenciamento de Consultas");
            System.out.println("6. Gerenciamento de Exames");
            System.out.print("Selecione o módulo de acesso: ");

            try {
                menuPrincipal = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Opção inválida!");
                scanner.nextLine();
                continue;
            }

            switch (menuPrincipal) {
                case 0:
                    System.out.println("Encerrando o sistema operacional...");
                    break;
                case 1:
                    convenioView.exibirMenu();
                    break;
                case 2:
                    pacienteView.exibirMenu();
                    break;
                case 3:
                    internacaoView.exibirTelaInternacao();
                    break;
                case 4:
                    quartoView.exibirTelaCadastro();
                    break;
                case 5:
                    consultaController.iniciar();
                    break;
                case 6:
                    exameController.iniciar();
                    break;
                default:
                    System.out.println("Opção inexistente.");
            }
        }
        scanner.close();
    }
}