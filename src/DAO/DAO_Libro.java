
package DAO;

import Entidades.Editorial;
import Entidades.Libro;
import java.util.List;

public final class DAO_Libro extends DAO <Libro>{
    
@Override
//Le mando override porque los metodos se escriben igual
public void guardar(Libro libro) {
    super.guardar(libro);
    
}

public void eliminar(long isbn) throws Exception{
    Libro libro=buscarPorISBN(isbn);
    super.eliminar(libro);
     
}
  
public void bajaLibro (Libro libroBaja){
    
    if(libroBaja.getAlta()==false){
        System.out.println("El libro ya se encuentra dado de baja ");
    } else{
   libroBaja.setAlta(Boolean.FALSE);
    editar(libroBaja);
    }
}

public void altaLibro (Libro libroAlta){
    
    if(libroAlta.getAlta()==true){
        System.out.println("El libro ya se encuentra dado de alta ");
    } else{
    libroAlta.setAlta(Boolean.TRUE);
    editar(libroAlta);
    }
}   
public Libro buscarPorISBN(long isbn)   {
    conectar();
    Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn").setParameter("isbn", isbn).getSingleResult();
    desconectar();
    return libro;
}

public Libro buscarPorTitulo(String aux)   {
    conectar();
    Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :aux").setParameter("aux", aux).getSingleResult();
    desconectar();
    return libro;
}


public List<Libro> listarLibros (){
    
    conectar();
    List<Libro> listaLibros = em.createQuery("SELECT l FROM Libro l").getResultList();
    desconectar();
 return listaLibros;   
}

public List<Libro> buscarPorAutorNombre(String aut)   {
    conectar();
    List<Libro> listaLibro2 = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :aut").setParameter("aut", aut).getResultList();
    desconectar();
    return listaLibro2;
}

public List<Libro> buscarPorEditorialNombre(String edi)   {
    conectar();
    List<Libro> listaLibro3 = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :edi").setParameter("edi", edi).getResultList();
    desconectar();
    return listaLibro3;
}
}
