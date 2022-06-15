package Servicios;

import DAO.DAO_Editorial;
import DAO.DAO_Libro;
import Entidades.Autor;
import Entidades.Editorial;
import Entidades.Libro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibroService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    EditorialService edserv= new EditorialService() ;
    AutorService autorserv= new AutorService();

    private final DAO_Libro DAO_lib;

    public LibroService() {
        this.DAO_lib = new DAO_Libro();
    }
//
//    public void setEdserv(EditorialService edserv) {
//        this.edserv = edserv;
//    }
//
//    public void setAutorserv(AutorService autorserv) {
//        this.autorserv = autorserv;
//    }
    
    

    public Libro crearLibro() {
        
            try {
                 Autor autor=new Autor();
                 Editorial editorial= new Editorial();
                
                System.out.println("Ingrese título ");
                String titulo = leer.next();
                if (titulo == null || titulo.trim().isEmpty()) {
                    throw new Exception ("Debe indicar el titulo");
                }
                System.out.println("Ingrese año del libro ");
                Integer anio = leer.nextInt();
                if (anio == null|| anio<1800 || anio>2045) {
                    throw new Exception ("Debe indicar año del libro");
                }
                
                
                //Validacion de existencia de autor y editorial. Retorna autor y editorial si es que existe
                
                autor=autorserv.buscarPorNombre();
                
                System.out.println("----------------1 ");
                
               if (autor == null ) {
                   System.out.println("Ingrese información sobre el autor ");
                   autor=autorserv.crearAutor();
               }
                System.out.println("----------------2 ");
                
                
                editorial=edserv.buscarPorNombre();
                if(editorial==null){
                    System.out.println("Ingrese información de editorial ");
                   editorial= edserv.crearEditorial();
                }
                
                System.out.println("Ingrese cantidad de ejemplares iniciales ");
                Integer ejemplares = leer.nextInt();
                if (ejemplares == null || ejemplares == 0) {
                    throw new Exception ("Debe indicar ejemplares iniciales");
                }
            
            Libro libro = new Libro();
            
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresRestantes(libro.getEjemplares());
            libro.setAutor(autor);
            libro.setEditorial(editorial);

            DAO_lib.guardar(libro);
            return libro;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public Libro buscarPorId() {
        try {
            System.out.println("Ingrese id del libro");
            long isbn = leer.nextLong();
            return DAO_lib.buscarPorISBN(isbn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public Libro buscarPorTitulo() {
        try {
            System.out.println("Ingrese nombre del libro");
            String aux = leer.next();
           
            return DAO_lib.buscarPorTitulo(aux);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    
    public void buscarPorAutor() throws Exception{
        try{
        System.out.println("Ingrese nombre de autor a buscar");
        String aut=leer.next();
        List<Libro> listaLibroporAutor= DAO_lib.buscarPorAutorNombre(aut);
      
        for(Libro libro : listaLibroporAutor){
            System.out.println(libro.toString());
        }
        }catch (Exception e){
            System.out.println(e.getMessage());
           throw new Exception ("El autor indicado no posee libros cargado");
        }
      
    }
    
     public void buscarPorEditorial() throws Exception{
        try{
        System.out.println("Ingrese nombre de editorial a buscar");
        String edi=leer.next();
        List<Libro> listaLibroporEditorial= DAO_lib.buscarPorEditorialNombre(edi);
      
        for(Libro libro : listaLibroporEditorial){
            System.out.println(libro.toString());
        }
        }catch (Exception e){
            System.out.println(e.getMessage());
           throw new Exception ("La editorial indicada no posee libros cargado");
        }
     
    }
    
    public void BajaLibro() {

        Libro libroBaja = buscarPorTitulo();
        DAO_lib.bajaLibro(libroBaja);
        System.out.println("El libro se dio de baja correctamente");

    }

    public void AltaLibro() {

        Libro libroAlta = buscarPorTitulo();
        DAO_lib.altaLibro(libroAlta);
        System.out.println("El libro se dio de alta correctamente");

    }

    public void eliminarLibro() {

        try {
            System.out.println("Ingrese id de libro a eliminar");
            long aux = leer.nextLong();
            DAO_lib.eliminar(aux);
            System.out.println("Editorial eliminado");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
    
    
  public void ListaLibros(){
      List <Libro>a1=DAO_lib.listarLibros();
      
      for(Libro aux: a1){
          System.out.println(a1);  
      }
      
  }
}

