
package ues.edu.sv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreProyecto;
    private String descripcion;
    private String ubicacion;
    private String supervisora;
    private String contratista;
    private String estado;
    
    public Proyecto(){
        
    }

    public Proyecto(int id, String nombreProyecto, String descripcion, String ubicacion, String supervisora, String contratista, String estado) {
        this.id = id;
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.supervisora = supervisora;
        this.contratista = contratista;
        this.estado = estado;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombreProyecto() {
        return nombreProyecto;
    }


    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getUbicacion() {
        return ubicacion;
    }


    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    public String getSupervisora() {
        return supervisora;
    }


    public void setSupervisora(String supervisora) {
        this.supervisora = supervisora;
    }


    public String getContratista() {
        return contratista;
    }


    public void setContratista(String contratista) {
        this.contratista = contratista;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
