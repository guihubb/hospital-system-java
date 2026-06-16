package Hospital.controller;

import Hospital.model.Exame;
import Hospital.service.ExameService;
import Hospital.view.ExameView;

import java.util.Date;
import java.util.List;

public class ExameController {
    private ExameService service;
    private ExameView view;

    public ExameController(ExameService service, ExameView view) {
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
                    adicionarExame();
                    break;
                case 2:
                    listarExames();
                    break;
                case 3:
                    buscarExamePorId();
                    break;
                case 4:
                    atualizarExame();
                    break;
                case 5:
                    cancelarExame();
                    break;
                case 0:
                    view.exibirMensagem("Saindo...");
                    break;
                default:
                    view.exibirMensagem("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarExame() {
        view.exibirMensagem("--- Adicionar Novo Exame ---");
        String tipo = view.lerTipoExame();
        Date data = view.lerDataExame();
        String paciente = view.lerPacienteExame();
        String resultado = view.lerResultadoExame();

        Exame novoExame = new Exame(0, tipo, data, paciente, resultado);
        try {
            service.registrarExame(novoExame);
            view.exibirMensagem("Exame adicionado com sucesso!");
        } catch (IllegalArgumentException e) {
            view.exibirMensagem("Erro ao adicionar exame: " + e.getMessage());
        }
    }

    private void listarExames() {
        view.exibirMensagem("--- Lista de Exames ---");
        List<Exame> exames = service.listarTodosExames();
        if (exames.isEmpty()) {
            view.exibirMensagem("Nenhum exame cadastrado.");
        } else {
            view.exibirListaExames(exames);
        }
    }

    private void buscarExamePorId() {
        view.exibirMensagem("--- Buscar Exame por ID ---");
        int id = view.lerIdExame();
        Exame exame = service.buscarExame(id);
        if (exame != null) {
            view.exibirDetalhesExame(exame);
        } else {
            view.exibirMensagem("Exame com ID " + id + " não encontrado.");
        }
    }

    private void atualizarExame() {
        view.exibirMensagem("--- Atualizar Exame ---");
        int id = view.lerIdExame();
        Exame exameExistente = service.buscarExame(id);

        if (exameExistente == null) {
            view.exibirMensagem("Exame com ID " + id + " não encontrado.");
            return;
        }

        String novoTipo = view.lerTipoExame();
        Date novaData = view.lerDataExame();
        String novoPaciente = view.lerPacienteExame();
        String novoResultado = view.lerResultadoExame();

        exameExistente.setTipo(novoTipo);
        exameExistente.setData(novaData);
        exameExistente.setPaciente(novoPaciente);
        exameExistente.setResultado(novoResultado);

        try {
            service.atualizarExame(exameExistente);
            view.exibirMensagem("Exame atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            view.exibirMensagem("Erro ao atualizar exame: " + e.getMessage());
        }
    }

    private void cancelarExame() {
        view.exibirMensagem("--- Cancelar Exame ---");
        int id = view.lerIdExame();
        try {
            service.cancelarExame(id);
            view.exibirMensagem("Exame com ID " + id + " cancelado com sucesso!");
        } catch (IllegalArgumentException e) {
            view.exibirMensagem("Erro ao cancelar exame: " + e.getMessage());
        }
    }
}
