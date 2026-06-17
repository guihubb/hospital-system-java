package Hospital.view;

import Hospital.model.Medico;

import java.util.List;

public class MedicoView {
    public void mostrar(List<Medico> medicos) {
        for(Medico medico : medicos) {
            System.out.println(medico);
        }
    }
}
