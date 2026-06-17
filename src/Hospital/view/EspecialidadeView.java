package Hospital.view;

import Hospital.model.Especialidade;

import java.util.List;

public class EspecialidadeView {
    public void mostrar(
            List<Especialidade> especialidades) {

        for(Especialidade e : especialidades) {
            System.out.println(e);
        }
    }
}
