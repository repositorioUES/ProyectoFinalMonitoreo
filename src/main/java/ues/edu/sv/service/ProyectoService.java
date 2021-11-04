
package ues.edu.sv.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ues.edu.sv.interfaceService.IProyectoService;
import ues.edu.sv.interfaces.IProyecto;
import ues.edu.sv.model.Proyecto;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    private IProyecto data;
    
    @Override
    public List<Proyecto> Listar() {
        return (List<Proyecto>)(data.findAll());
    }

    @Override
    public Optional<Proyecto> ListarId(int id) {
         return data.findById(id);
    }

    @Override
    public int save(Proyecto p) {
       int res=0;
       Proyecto proyecto=data.save(p);
       if(!proyecto.equals(null)){
           res=1;
       }
       return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
    
}
