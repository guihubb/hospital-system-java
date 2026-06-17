package Hospital.service;

import Hospital.model.Prontuario;
import Hospital.repository.ProntuarioRepository;

public class ProntuarioService {
    private ProntuarioRepository repository;
    public ProntuarioService(ProntuarioRepository prontuario) {
        this.repository = prontuario;
    }

    public void emitirNovoProntuario(Prontuario p){
        Prontuario prontuarioExistente = repository.buscarPorIdPaciente(p.getIdPaciente());

        if (prontuarioExistente != null){
            System.out.println("Erro: O paciente com ID " + p.getIdPaciente() + " já possui um prontuário ativo!");
            return;
        }

        repository.salvar(p);
        System.out.println("Novo prontuário emitido com sucesso para o paciente " + p.getIdPaciente());
    }

    public void vincularConsulta(String idProntuario, String idConsulta) {
        Prontuario prontuario = repository.buscarPorId(idProntuario);

        if (prontuario != null) {
            prontuario.getIdConsultas().add(idConsulta);
            repository.atualizar(prontuario);
            System.out.println("Consulta " + idConsulta + " vinculada ao prontuário " + idProntuario);
        } else {
            System.out.println("Erro: Prontuário com ID " + idProntuario + " não encontrado.");
        }
    }

    public void adicionarAlergia(String idProntuario, String alergia){
        Prontuario prontuario = repository.buscarPorId(idProntuario);

        if (prontuario != null){
            prontuario.getAlergias().add(alergia);
            repository.atualizar(prontuario);

            System.out.println("Alergia '" + alergia + "' adicionada ao prontuário " + idProntuario);
        } else {
            System.out.println("Erro: Prontuário com ID " + idProntuario + " não encontrado.");
        }
    }

    public Prontuario buscarPorIdPaciente(String idPaciente) {
        return repository.buscarPorIdPaciente(idPaciente);
    }
}
