
package Servicios;

import DAO.DAO_Autor;
import Entidades.Autor;
import Entidades.Libro;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AutorService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private LibroService libroserv;
    private EditorialService editorialserv;
    
    
private final DAO_Autor DAO_aut;

    public AutorService() {
    this.DAO_aut = new DAO_Autor();
    }

    public void setLibroserv(LibroService libroserv) {
        this.libroserv = libroserv;
    }

    public void setEditorialserv(EditorialService editorialserv) {
        this.editorialserv = editorialserv;
    }
    


   public Autor crearAutor(){
   try{
       
   Autor autor=new Autor();
   
   System.out.println("Ingrese nombre del autor ");
   String nombre=leer.next();
   if (nombre == null || nombre.trim().isEmpty()) {
                    throw new Exception("Debe indicar el nombre");
     }
  
   autor.setNombre(nombre);
   
   DAO_aut.guardar(autor);
   return autor;
   
   }catch (Exception e){
       System.out.println(e.getMessage());
         return null;
   }
         
   }
    
   public Autor buscarPorId(){
       try{
           System.out.println("Ingrese id del autor");
           long id=leer.nextLong();
           return DAO_aut.buscarPorId(id);
       }catch(Exception e){
           System.out.println(e.getMessage());
           return null;
       }
        
   }
    
     public Autor buscarPorNombre(){
       try{
           System.out.println("Ingrese nombre del autor");
           String aux=leer.next();
           return DAO_aut.buscarPorNombre(aux);
       }catch(Exception e){
           System.out.println(e.getMessage());
           System.out.println("El autor ingresado no se encuentra en la base de datos ");
           return null;
       }
        
      }
     
     public void BajaAutor(){
         
        Autor autBaja= buscarPorNombre();
        DAO_aut.bajaAutor(autBaja);
         System.out.println("El autor se dio de baja correctamente");
     
     }
     
      public void AltaAutor(){
         
        Autor autAlta= buscarPorNombre();
        DAO_aut.altaAutor(autAlta);
         System.out.println("El autor se dio de alta correctamente");
     
     }
      
     public void eliminarAutor(){
        
         try{
         System.out.println("Ingrese id del autor a eliminar");   
         long aux= leer.nextLong();
         DAO_aut.eliminar(aux);
             System.out.println("Autor eliminado");
         }catch(Exception e){
             System.out.println(e.getMessage());
             
         }
        
     }


 public void ListaAutor(){
      List<Autor>a1 = new ArrayList();
              a1=DAO_aut.listarAutores();
      
      for(Autor aux: a1){
          System.out.println(a1.toString());  
      }
      
  }







}



    
