
package DAO;

import Entidades.Autor;
import Entidades.Editorial;
import java.util.List;

public final class DAO_Autor extends DAO<Autor>{
    
        
   @Override
   public void guardar(Autor autor) {
    super.guardar(autor);
    
}

public void eliminar(long id) throws Exception{
    Autor autor=buscarPorId(id);
    super.eliminar(autor);
     
}

public void bajaAutor (Autor autBaja){
    
    if(autBaja.getAlta()==false){
        System.out.println("El autor ya se encuentra dado de baja ");
    } else{
    autBaja.setAlta(Boolean.FALSE);
    editar(autBaja);
    }
}

public void altaAutor (Autor autAlta){
    
    if(autAlta.getAlta()==true){
        System.out.println("El autor ya se encuentra dado de alta ");
    } else{
    autAlta.setAlta(Boolean.TRUE);
    editar(autAlta);
    }
}



public Autor buscarPorId(long id)   {
    conectar();
    Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id LIKE :id").setParameter("id", id).getSingleResult();
    desconectar();
    return autor;
}

public Autor buscarPorNombre(String aux)   {
    conectar();
    Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :aux").setParameter("aux", aux).getSingleResult();
    desconectar();
    return autor;
}

public List<Autor> listarAutores (){
    
    conectar();
    List<Autor> listaAutores = em.createQuery("SELECT a FROM Autor a").getResultList();
    desconectar();
    
 return listaAutores;   
} 
    
  
    
    
    
}
