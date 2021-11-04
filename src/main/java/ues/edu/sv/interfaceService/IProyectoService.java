
package ues.edu.sv.interfaceService;

import java.util.List;
import java.util.Optional;
import ues.edu.sv.model.Proyecto;


public interface IProyectoService {
    public List<Proyecto>Listar();
    public Optional<Proyecto>ListarId(int id);
    public int save(Proyecto p);
    public void delete(int id);
}
