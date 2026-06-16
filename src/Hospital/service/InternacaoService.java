package Hospital.service;

import Hospital.model.Internacao;
import Hospital.model.Quarto;
import Hospital.repository.InternacaoRepository;
import Hospital.repository.QuartoRepository;

public class InternacaoService {
    private InternacaoRepository internacaoRepository;
    private QuartoRepository quartoRepository;

    public InternacaoService(InternacaoRepository intRepo, QuartoRepository qrtRepo) {
        this.internacaoRepository = intRepo;
        this.quartoRepository = qrtRepo;
    }

    public void realizarInternacao(String paciente, int numeroQuarto) throws Exception {
        if (paciente == null || paciente.trim().isEmpty()) {
            throw new Exception("O nome do paciente é obrigatório.");
        }

        Quarto quarto = quartoRepository.buscarPorNumero(numeroQuarto);

        if (quarto == null) {
            throw new Exception("Quarto não encontrado no sistema.");
        }

        if (quarto.isOcupado()) {
            throw new Exception("O quarto escolhido já está ocupado por outro paciente.");
        }



        quarto.setOcupado(true);
        Internacao novaInternacao = new Internacao(paciente, quarto);
        internacaoRepository.salvar(novaInternacao);
    }
}
