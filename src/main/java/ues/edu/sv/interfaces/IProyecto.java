
package ues.edu.sv.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ues.edu.sv.model.Proyecto;


@Repository
public interface IProyecto extends CrudRepository<Proyecto, Integer>{
    
    }