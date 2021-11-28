
package ues.edu.sv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subtareatabla")

public class Subtarea {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subtareaonline;
    private String descripcion;
    private String fechafinalizacion;
    private int porcentaje;
    private int idTareaAsignada;
    
    public Subtarea(){
        }

    public Subtarea(int id, String subtareaonline, String descripcion, String fechafinalizacion, int porcentaje, int idTareaAsignada) {
        this.id = id;
        this.subtareaonline = subtareaonline;
        this.descripcion = descripcion;
        this.fechafinalizacion = fechafinalizacion;
        this.porcentaje = porcentaje;
        this.idTareaAsignada = idTareaAsignada;
    }
    
    public int getIdTareaAsignada() {
        return idTareaAsignada;
    }

    public void setIdTareaAsignada(int tareaAsignada) {
        this.idTareaAsignada = tareaAsignada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubtareaonline() {
        return subtareaonline;
    }

    public void setSubtareaonline(String subtareaonline) {
        this.subtareaonline = subtareaonline;
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