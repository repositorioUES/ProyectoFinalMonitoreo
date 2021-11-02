
package ues.edu.sv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Subtarea {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subtarea;
    private String descripcion;
    private String fechafinalizacion;
    private int porcentaje;
    
    public Subtarea(){
        }

    public Subtarea(int id, String subtarea, String descripcion, String fechafinalizacion, int porcentaje) {
        this.id = id;
        this.subtarea = subtarea;
        this.descripcion = descripcion;
        this.fechafinalizacion = fechafinalizacion;
        this.porcentaje = porcentaje;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubtarea() {
        return subtarea;
    }

    public void setSubtarea(String subtarea) {
        this.subtarea = subtarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechafinalizacion() {
        return fechafinalizacion;
    }

    public void setFechafinalizacion(String fechafinalizacion) {
        this.fechafinalizacion = fechafinalizacion;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}