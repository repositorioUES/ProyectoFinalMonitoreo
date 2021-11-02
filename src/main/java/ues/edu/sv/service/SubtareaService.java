
package ues.edu.sv.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ues.edu.sv.interfaceService.ISubtareasService;
import ues.edu.sv.interfaces.ISubtarea;
import ues.edu.sv.model.Subtarea;

@Service
public class SubtareaService implements ISubtareasService{
    
    @Autowired
    private ISubtarea data;

    @Override
    public List<Subtarea> Listar() {
       return (List<Subtarea>)(data.findAll());
    }

    @Override
    public Optional<Subtarea> ListarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Subtarea p) {
       int res=0;
       Subtarea subtarea=data.save(p);
       if(!subtarea.equals(null)){
           res=1;
       }
       return res;
    }

    @Override
    public void delete(int id) {
       data.deleteById(id);
    }
    
    
}
