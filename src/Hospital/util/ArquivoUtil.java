package Hospital.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArquivoUtil {

    public static void gravarArquivo(String caminhoArquivo, String conteudo) {
        try {
            File arquivo = new File(caminhoArquivo);
            File pasta = arquivo.getParentFile();

            // Se a pasta (ex: 'dados') não existir, cria ela primeiro para não dar erro
            if (pasta != null && !pasta.exists()) {
                pasta.mkdirs();
            }

            // Grava o arquivo usando UTF_8 para garantir que acentos (á, ç, õ) não quebrem
            Files.writeString(Paths.get(caminhoArquivo), conteudo, StandardCharsets.UTF_8);
            System.out.println("[ArquivoUtil] Arquivo gravado com sucesso: " + caminhoArquivo);

        } catch (IOException e) {
            System.err.println("[ArquivoUtil] Erro crítico ao gravar o arquivo: " + e.getMessage());
        }
    }

    public static String lerArquivo(String caminhoArquivo) {
        try {
            File arquivo = new File(caminhoArquivo);
            if (!arquivo.exists()) {
                return "[]";
            }
            return Files.readString(Paths.get(caminhoArquivo), StandardCharsets.UTF_8);

        } catch (IOException e) {
            System.err.println("[ArquivoUtil] Erro crítico ao ler o arquivo: " + e.getMessage());
            return "[]";
        }
    }
}
