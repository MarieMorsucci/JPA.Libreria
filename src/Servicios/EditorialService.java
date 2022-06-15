
package Servicios;

import DAO.DAO_Editorial;
import Entidades.Editorial;
import Entidades.Libro;
import java.util.List;

import java.util.Scanner;

public class EditorialService {
   Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private LibroService libroserv;
    private AutorService autorserv;
    
    
private final DAO_Editorial DAO_ed;

    public EditorialService() {
        this.DAO_ed = new DAO_Editorial();
    }

    public void setLibroserv(LibroService libroserv) {
        this.libroserv = libroserv;
    }

    public void setAutorserv(AutorService autorserv) {
        this.autorserv = autorserv;
    }

   public Editorial crearEditorial(){
   try{
  
   System.out.println("Ingrese nombre de editorial ");
   String nombre=leer.next();
   if (nombre == null || nombre.trim().isEmpty()) {
                    throw new Exception("Debe indicar el nombre");
     }
   
   Editorial editorial=new Editorial();
   editorial.setNombre(nombre);
   
   DAO_ed.guardar(editorial);
   return editorial;
   }catch (Exception e){
       System.out.println(e.getMessage());
         return null;
   }
         
   }
    
   public Editorial buscarPorId(){
       try{
           System.out.println("Ingrese id del editorial");
           long id=leer.nextLong();
           return DAO_ed.buscarPorId(id);
       }catch(Exception e){
           System.out.println(e.getMessage());
           return null;
       }
        
   }
    
     public Editorial buscarPorNombre(){
       try{
           System.out.println("Ingrese nombre de editorial");
           String aux=leer.next();
           return DAO_ed.buscarPorNombre(aux);
       }catch(Exception e){
           System.out.println(e.getMessage());
           return null;
       }
        
      }
     
     public void BajaEditorial(){
         
       Editorial edBaja= buscarPorNombre();
        DAO_ed.bajaEditorial(edBaja);
         System.out.println("La editorial se dio de baja correctamente");
     
     }
     
      public void AltaEditorial(){
         
        Editorial edAlta= buscarPorNombre();
        DAO_ed.altaEditorial(edAlta);
         System.out.println("La editorial se dio de alta correctamente");
     
     }
      
     public void eliminarEditorial(){
        
         try{
         System.out.println("Ingrese id de Editorial a eliminar");   
         long aux= leer.nextLong();
         DAO_ed.eliminar(aux);
             System.out.println("Editorial eliminado");
         }catch(Exception e){
             System.out.println(e.getMessage());
             
         }
        
     }
     
     
      public void ListaEditorial(){
      List <Editorial>a1=DAO_ed.listarEditorial();
      
      for(Editorial aux: a1){
          System.out.println(a1.toString());  
      }
      
  }
}
