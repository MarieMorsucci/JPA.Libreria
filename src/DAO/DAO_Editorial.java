
package DAO;

import Entidades.Autor;
import Entidades.Editorial;
import Entidades.Libro;
import java.util.ArrayList;
import java.util.List;

public final class DAO_Editorial extends DAO <Editorial>{
    
   @Override
   public void guardar(Editorial editorial) {
    super.guardar(editorial);
    
}

public void eliminar(long id) throws Exception{
    Editorial editorial=buscarPorId(id);
    super.eliminar(editorial);
     
}
 
public void bajaEditorial (Editorial edBaja){
    
    if(edBaja.getAlta()==false){
        System.out.println("La editorial ya se encuentra dado de baja ");
    } else{
   edBaja.setAlta(Boolean.FALSE);
    editar(edBaja);
    }
}

public void altaEditorial (Editorial edAlta){
    
    if(edAlta.getAlta()==true){
        System.out.println("El autor ya se encuentra dado de alta ");
    } else{
    edAlta.setAlta(Boolean.TRUE);
    editar(edAlta);
    }
}

public Editorial buscarPorId(long id)   {
    conectar();
    Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.id LIKE :id").setParameter("id", id).getSingleResult();
    desconectar();
    return editorial;
}

public Editorial buscarPorNombre(String aux)   {
    conectar();
    Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :aux").setParameter("aux",aux).getSingleResult();
    desconectar();
    return editorial;
}

public List<Editorial> listarEditorial (){
    
    conectar();
   List<Editorial> listaEditoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
    desconectar();
 return listaEditoriales;   
} 
    
    
    
    
    
    
}
