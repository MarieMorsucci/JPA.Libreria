
package Entidades;


import static java.lang.Boolean.TRUE;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Autor  {
    
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="Id_autor")        
private long id;
@Column(name="Nombre_autor") 
private String nombre;
@Column(name="Alta_autor") 
private Boolean alta;

    public Autor() {
    this.alta=TRUE;
    }

    public Autor(String nombre) {
        this.nombre = nombre;
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nombre=" + nombre + ", alta=" + alta + '}';
    }











}
