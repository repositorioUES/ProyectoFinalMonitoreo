
package ues.edu.sv.interfaceService;

import java.util.List;
import java.util.Optional;
import ues.edu.sv.model.Tarea;


public interface ITareaService {
    public List<Tarea>Listar();
    public Optional<Tarea>ListarId(int id);
    public int save(Tarea p);
    public void delete(int id);
}
