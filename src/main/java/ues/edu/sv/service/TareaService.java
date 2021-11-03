
package ues.edu.sv.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ues.edu.sv.model.Tarea;
import ues.edu.sv.interfaces.ITarea;
import ues.edu.sv.interfaceService.ITareaService;
import ues.edu.sv.model.Subtarea;

@Service
public class TareaService implements ITareaService{
    
    @Autowired
    private ITarea data;

    @Override
    public List<Tarea> Listar() {
       return (List<Tarea>)(data.findAll());
    }

    @Override
    public Optional<Tarea> ListarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Tarea p) {
       int res=0;
       Tarea tarea=data.save(p);
       if(!tarea.equals(null)){
           res=1;
       }
       return res;
    }

    @Override
    public void delete(int id) {
       data.deleteById(id);
    }
    

}
