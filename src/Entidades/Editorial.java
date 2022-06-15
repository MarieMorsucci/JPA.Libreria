
package Entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Editorial{

    
@Id
@Column(name="Id_EDITORIAL") 
@GeneratedValue(strategy= GenerationType.IDENTITY)
private long id;

@Column(name="Nombre_editorial") 
String nombre;

@Column(name="Alta_editorial") 
Boolean alta;

    public Editorial() {
        this.alta=true;
    }

    public Editorial(String nombre) {
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
        return "Editorial{" + "id=" + id + ", nombre=" + nombre + ", alta=" + alta + '}';
    }







}
