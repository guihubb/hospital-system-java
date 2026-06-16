package Hospital.repository;

import Hospital.model.Exame;
import java.util.ArrayList;
import java.util.List;

public class ExameRepository {
    private List<Exame> exames = new ArrayList<>();
    private int nextId = 1;

    public void addExame(Exame exame) {
        exame.setId(nextId++);
        exames.add(exame);
    }

    public Exame getExameById(int id) {
        for (Exame exame : exames) {
            if (exame.getId() == id) {
                return exame;
            }
        }
        return null;
    }

    public List<Exame> getAllExames() {
        return new ArrayList<>(exames);
    }

    public void updateExame(Exame updatedExame) {
        for (int i = 0; i < exames.size(); i++) {
            if (exames.get(i).getId() == updatedExame.getId()) {
                exames.set(i, updatedExame);
                return;
            }
        }
    }

    public void deleteExame(int id) {
        exames.removeIf(exame -> exame.getId() == id);
    }
}
