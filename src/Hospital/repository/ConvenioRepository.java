package Hospital.repository;

import Hospital.model.Convenio;

import java.util.ArrayList;
import java.util.List;

public class ConvenioRepository {
    private List<Convenio> convenios = new ArrayList<>();

    public void salvar(Convenio convenio) {
        convenios.add(convenio);
    }

    public List<Convenio> listarTodos() {
        return convenios;
    }

    public Convenio buscarPorId(int id) {
        for (Convenio c : convenios) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public boolean deletar(int id) {
        Convenio c = buscarPorId(id);
        if (c != null) {
            convenios.remove(c);
            return true;
        }
        return false;
    }
}