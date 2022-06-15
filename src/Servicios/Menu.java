
package Servicios;

import Entidades.Autor;
import Entidades.Libro;
import java.util.List;
import java.util.Scanner;

public class Menu {
       Scanner leer = new Scanner(System.in).useDelimiter("\n");
         
    LibroService ls= new LibroService(); 
    AutorService as= new AutorService();
    EditorialService es= new EditorialService();
    
    
    
public void Menu() throws Exception      { 
   String rta="";
    
  do{
    System.out.println("Bienvenidos a la libreria DE LOS MEJORES!");
    System.out.println("Que deseas realizar? 1.Crear una editorial \n 2.Crear un autor \n 3.Crear un libro \n 4. Buscar autor \n 5. Buscar un libro por titulo "
            + "\n 6. Buscar libros por editorial \n 7. Buscar libros por autor \n 8. Listar editoriales \n 9.Listar libros \n 10.Listar autores"
            + "\n 11. Bajas en Sistema \n 12. Altas en Sistema \n 13.Generar un prestamo de libro \n 13. Registro Nuevo Cliente \14.Lista Clientes Registrados");
    int operacion=leer.nextInt();
    
    switch (operacion){
        case 1:
            System.out.println("Ingresar editorial");
            es.crearEditorial();
             break;   
        case 2: 
            System.out.println("Ingresar autor en la base de datos");
            as.crearAutor();
             break;
        case 3:    
            System.out.println("Ingresar un libro en la base de datos");
            ls.crearLibro();
            break;
        case 4:
            System.out.println("Buscar un autor. Buscar: \n 1)Por ID \n 2)Por Nombre");
            int n= leer.nextInt();
           
            try{
            if(n==1){
             Autor aa=as.buscarPorId();
             System.out.println(aa);
            }else{
             Autor aa= as.buscarPorNombre(); 
             System.out.println(aa);
            }
            
            }catch (Exception e){
             throw new Exception("Intente nuevamente. Debe indicar el numero de la opción elegida");
                
            }
            break;
        case 5:
            System.out.println("Buscar Libro por titulo ");
            Libro la=ls.buscarPorTitulo();
            System.out.println(la);
            break;
        case 6:
            System.out.println("Buscar libros por Editorial ");
            ls.buscarPorEditorial();
            break;
        case 7:
            System.out.println("Buscar libros por autor");
            ls.buscarPorAutor();
            break;
        case 8:
            System.out.println("Lista Editoriales en el sistema ");
            es.ListaEditorial();
            break;
        case 9:
            System.out.println("Lista Libros en el sistema ");
            ls.ListaLibros();
            break;
        case 10:
            System.out.println("Lista Autores en el sistema ");
            break;
        
        case 11:
            System.out.println("Baja en el sistema \n Qué desea dar de baja? 1.Libro 2.Autor 3.Editorial ");
            int b=leer.nextInt();
            
            switch (b){
                case 1:
                    System.out.println("Se dará de baja un libro en el sistema ");
                    ls.BajaLibro();
                    System.out.println("La baja del libro ingresado se ha realizado correctamente ");
                    break;
                case 2:
                    System.out.println("Se dará de baja un autor en el sistema ");
                    as.BajaAutor();
                    System.out.println("La baja del autor ingresado se ha realizado correctamente ");
                    break;
                case 3:
                    System.out.println("Se dará de baja una editorial en el sistema ");
                    es.BajaEditorial();
                    System.out.println("La baja de la editorial ingresada se ha realizado correctamente ");
                    break;
            }
        case 12:
            System.out.println("Dar Alta en el Sistema \n Qué desea dar de baja? 1.Libro 2.Autor 3.Editorial ");
            int a=leer.nextInt();
            
            switch (a){
                case 1:
                    System.out.println("Se dará de alta un libro en el sistema ");
                    ls.AltaLibro();
                    System.out.println("La alta del libro ingresado se ha realizado correctamente ");
                    break;
                case 2:
                    System.out.println("Se dará de alta un autor en el sistema ");
                    as.AltaAutor();
                    System.out.println("La alta del autor ingresado se ha realizado correctamente ");
                    break;
                case 3:
                    System.out.println("Se dará de alta una editorial en el sistema ");
                    es.AltaEditorial();
                    System.out.println("La alta de la editorial ingresada se ha realizado correctamente ");
                    break;
            }
        
    }
   
    System.out.println("Desea realizar otra acción? S/N ");
     rta=leer.next();
 
    
}while(rta.equalsIgnoreCase("s"));
  
    System.out.println("Gracias por visitarnos! te esperamos para un proximo prestamo! ");
}





}