
package jpa.libreria;

import Servicios.AutorService;
import Servicios.EditorialService;
import Servicios.LibroService;
import Servicios.Menu;

public class JPALibreria {

    public static void main(String[] args) throws Exception {
    
    LibroService ls= new LibroService(); 
    AutorService as= new AutorService();
    EditorialService es= new EditorialService();
    Menu menu=new Menu();
    
    menu.Menu();
      
        
    }
    
}
