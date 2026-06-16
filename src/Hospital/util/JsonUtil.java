package Hospital.util;

import Hospital.model.Prontuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void salvarProntuarios(String caminhoArquivo, List<Prontuario> prontuarios){
        File arquivo = new File(caminhoArquivo);
        if (arquivo.getParentFile() != null){
            arquivo.getParentFile().mkdirs();
        }

        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(prontuarios, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo JSON: " + e.getMessage());
        }
    }

    public static List<Prontuario> lerProntuarios(String caminhoArquivo){
        File arquivo = new File(caminhoArquivo);

        if(!arquivo.exists()){
            return new ArrayList<>();
        }

        try(FileReader reader = new FileReader(arquivo)){
            Type tipoLista = new TypeToken<ArrayList<Prontuario>>(){}.getType();
            List<Prontuario> lista = gson.fromJson(reader, tipoLista);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e){
            System.err.println("Erro ao ler o arquivo JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
