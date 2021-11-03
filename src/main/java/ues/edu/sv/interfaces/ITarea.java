package ues.edu.sv.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ues.edu.sv.model.Tarea;

@Repository
public interface ITarea extends CrudRepository<Tarea, Integer>{
    
    }
