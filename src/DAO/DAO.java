package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DAO <T> {
 
    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("JPA-LibreriaPU");
    protected EntityManager em= EMF.createEntityManager();
    
    protected void conectar() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }
    
    protected void guardar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    protected void editar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    protected void eliminar(T objeto) throws Exception{
      
        try{
        conectar();
        em.getTransaction().begin();
        //Hay que meter un merge primero para acceder a la edicion del objeto y de ahi recien borrar
        em.remove(em.merge(objeto));
        em.getTransaction().commit();
        desconectar();
        }catch (Exception e){
            em.getTransaction().rollback();
            desconectar();
            throw new Exception ("La entidad de tipo"+objeto.getClass().getSimpleName()+" no se ha podido eliminar ");
        }
    }
    
    
    
    
    
    
    
    
    
}
