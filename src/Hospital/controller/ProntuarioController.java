package Hospital.controller;

import Hospital.model.Prontuario;
import Hospital.service.ProntuarioService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class ProntuarioController {
    private final ProntuarioService service = new ProntuarioService();

    public void processarCriacao(String idPaciente, String historico, List<String> alergias){
        String idProntuario = UUID.randomUUID().toString().substring(0, 8);
        String dataAtual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Prontuario novoProntuario = new Prontuario(idProntuario, idPaciente, historico, dataAtual);
        novoProntuario.setAlergias(alergias);
        service.emitirNovoProntuario(novoProntuario);
    }

    public Prontuario processarBuscaPorPaciente(String idPaciente){
        return service.buscarPorIdPaciente(idPaciente);
    }
}
