package Hospital.controller;

import Hospital.model.Consulta;
import Hospital.service.ConsultaService;
import Hospital.view.ConsultaView;

import java.util.Date;
import java.util.List;

public class ConsultaController {
    private ConsultaService service;
    private ConsultaView view;

    public ConsultaController(ConsultaService service, ConsultaView view) {
        this.service = service;
        this.view = view;
    }

    public void iniciar() {
        int opcao;
        do {
            view.exibirMenu();
            opcao = view.lerOpcao();

            switch (opcao) {
                case 1:
                    adicionarConsulta();
                    break;
                case 2:
                    listarConsultas();
                    break;
                case 3:
                    buscarConsultaPorId();
                    break;
                case 4:
                    atualizarConsulta();
                    break;
                case 5:
                    cancelarConsulta();
                    break;
                case 0:
                    view.exibirMensagem("Saindo...");
                    break;
                default:
                    view.exibirMensagem("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarConsulta() {
        view.exibirMensagem("--- Adicionar Nova Consulta ---");
        String paciente = view.lerPacienteConsulta();
        String medico = view.lerMedicoConsulta();
        Date data = view.lerDataConsulta();
        String descricao = view.lerDescricaoConsulta();

        Consulta novaConsulta = new Consulta(0, paciente, medico, data, descricao);
        try {
            service.registrarConsulta(novaConsulta);
            view.exibirMensagem("Consulta adicionada com sucesso!");
        } catch (IllegalArgumentException e) {
            view.exibirMensagem("Erro ao adicionar consulta: " + e.getMessage());
        }
    }

    private void listarConsultas() {
        view.exibirMensagem("--- Lista de Consultas ---");
        List<Consulta> consultas = service.listarTodasConsultas();
        if (consultas.isEmpty()) {
            view.exibirMensagem("Nenhuma consulta cadastrada.");
        } else {
            view.exibirListaConsultas(consultas);
        }
    }

    private void buscarConsultaPorId() {
        view.exibirMensagem("--- Buscar Consulta por ID ---");
        int id = view.lerIdConsulta();
        Consulta consulta = service.buscarConsulta(id);
        if (consulta != null) {
            view.exibirDetalhesConsulta(consulta);
        } else {
            view.exibirMensagem("Consulta com ID " + id + " não encontrada.");
        }
    }

    private void atualizarConsulta() {
        view.exibirMensagem("--- Atualizar Consulta ---");
        int id = view.lerIdConsulta();
        Consulta consultaExistente = service.buscarConsulta(id);

        if (consultaExistente == null) {
            view.exibirMensagem("Consulta com ID " + id + " não encontrada.");
            return;
        }

        String novoPaciente = view.lerPacienteConsulta();
        String novoMedico = view.lerMedicoConsulta();
        Date novaData = view.lerDataConsulta();
        String novaDescricao = view.lerDescricaoConsulta();

        consultaExistente.setPaciente(novoPaciente);
        consultaExistente.setMedico(novoMedico);
        consultaExistente.setData(novaData);
        consultaExistente.setDescricao(novaDescricao);

        try {
            service.atualizarConsulta(consultaExistente);
            view.exibirMensagem("Consulta atualizada com sucesso!");
        } catch (IllegalArgumentException e) {
            view.exibirMensagem("Erro ao atualizar consulta: " + e.getMessage());
        }
    }

    private void cancelarConsulta() {
        view.exibirMensagem("--- Cancelar Consulta ---");
        int id = view.lerIdConsulta();
        try {
            service.cancelarConsulta(id);
            view.exibirMensagem("Consulta com ID " + id + " cancelada com sucesso!");
        } catch (IllegalArgumentException e) {
            view.exibirMensagem("Erro ao cancelar consulta: " + e.getMessage());
        }
    }
}