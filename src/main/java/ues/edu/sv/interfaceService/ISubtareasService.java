
package ues.edu.sv.interfaceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import ues.edu.sv.model.Subtarea;


public interface ISubtareasService {
    public List<Subtarea>Listar();
    public Optional<Subtarea>ListarId(int id);
    public ArrayList<Subtarea> ListarIdTarea(int idTarea);
    public int save(Subtarea p, int idTareaAsignada);
    public void delete(int id);
}
