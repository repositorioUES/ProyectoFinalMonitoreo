
package ues.edu.sv.interfaceService;

import java.util.List;
import java.util.Optional;
import ues.edu.sv.model.Subtarea;


public interface ISubtareasService {
    public List<Subtarea>Listar();
    public Optional<Subtarea>ListarId(int id);
    public int save(Subtarea p);
    public void delete(int id);
}
