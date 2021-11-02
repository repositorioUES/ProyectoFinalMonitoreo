package ues.edu.sv.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ues.edu.sv.model.Subtarea;

@Repository
public interface ISubtarea extends CrudRepository<Subtarea, Integer>{
    
    }
