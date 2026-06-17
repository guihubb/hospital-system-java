package Hospital.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> void salvar(String caminhoArquivo, List<T> lista) {
        File arquivo = new File(caminhoArquivo);
        if (arquivo.getParentFile() != null) {
            arquivo.getParentFile().mkdirs();
        }

        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar JSON: " + e.getMessage());
        }
    }

    public static <T> List<T> ler(String caminhoArquivo, Class<T> classe) {
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }
        try (FileReader reader = new FileReader(arquivo)) {

            Type tipoLista =
                    TypeToken.getParameterized(List.class, classe).getType();


            List<T> lista = gson.fromJson(reader, tipoLista);

            return lista != null ? lista : new ArrayList<>();

        } catch (IOException e) {

            System.err.println("Erro ao ler JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}