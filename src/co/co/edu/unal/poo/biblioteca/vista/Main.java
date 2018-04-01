package co.co.edu.unal.poo.biblioteca.vista;

import edu.unal.poo.biblioteca.datos.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Flexxo333
 */
public class Main {

    
    public static void main(String[] args) {
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
        Date date = new Date();
        Vistas v = new Vistas();
        
        
        //Biblioteca    
        Biblioteca biblioteca1 = new Biblioteca("Luis Angel Arango");
        
        System.out.println("Bienvenido al modulo de administración de préstamos de la biblioteca " + biblioteca1.getNombre() 
                + "a continuacion, encontrara todos los items registrados (Editoriales, Autores, Categorias de los libros, los \nclientes que han realizado registro "
                        + "y las copias de cada libro, con su ID, el cual es único, para realizar operaciones entre estos items \npor favor use el ID que aparece en pantalla)");
        //Editoriales
        biblioteca1.crearEditorial("Mundo", 12344556);
        biblioteca1.crearEditorial("Espasa", 45618754);
        System.out.println("EDITORIALES REGISTRADAS");
        v.escribirEditoriales(biblioteca1);
        //biblioteca1.escribirEditoriales();
//        for (int i = 0; i < biblioteca1.getEditoriales().size(); i++) {
//            System.out.println("ID: "+biblioteca1.getEditoriales().get(i).getId() + 
//                    "  "+biblioteca1.getEditoriales().get(i).getNombre());
//        }
        
        //Categorias
        biblioteca1.crearCategoria("reserva", 3);
        biblioteca1.crearCategoria("coleccion", 48);
        biblioteca1.crearCategoria("especiales sin restricción", 120);
        biblioteca1.crearCategoria("PRUEBA", 500);
        System.out.println("CATEGORIAS REGISTRADAS");
        v.escribirCategorias(biblioteca1);
        //biblioteca1.escribirCategorias();
//        for (int i = 0; i < biblioteca1.getCategorias().size(); i++) {
//            System.out.println("ID: "+biblioteca1.getCategorias().get(i).getId() + 
//                    "  "+biblioteca1.getCategorias().get(i).getNombre());
//        }
        
        //Autores
        biblioteca1.crearAutor("Gabriel", "García Marquez");
        biblioteca1.crearAutor("José", "Asunción Silva");
        System.out.println("AUTORES REGISTRADOS");
        v.escribirAutores(biblioteca1);
        //biblioteca1.escribirAutores();
//        for (int i = 0; i < biblioteca1.getAutores().size(); i++) {
//            System.out.println("ID: "+  biblioteca1.getAutores().get(i).getId()+"  "+ biblioteca1.getAutores().get(i).getNombre() + " " +
//                    biblioteca1.getAutores().get(i).getApellido());
//        }
        //Clientes
        System.out.println("CLIENTES REGISTRADOS");
        biblioteca1.crearCliente(12345489, "Johan", "Gutierrez", 2, true);
        biblioteca1.crearCliente(65465189, "Nycole", "Gutierrez", 2, false);
        biblioteca1.crearCliente(54651156, "Yaryz", "Fonseca", 3, true);
        v.escribirClientes(biblioteca1);
        //biblioteca1.escribirClientes();
//        for (int i = 0; i < biblioteca1.getClientes().size(); i++) {
//            System.out.println("ID: "+biblioteca1.getClientes().get(i).getId()+ " " +
//                    biblioteca1.getClientes().get(i).getNombre());
//        }
        //Libros
        System.out.println("LIBROS REGISTRADOS");

        biblioteca1.crearLibro("100 años de soledad", "222222", biblioteca1.getAutores().get(0), biblioteca1.getEditoriales().get(0), biblioteca1.getCategorias().get(0));
        biblioteca1.crearLibro("El perfume", "33333", biblioteca1.getAutores().get(1), biblioteca1.getEditoriales().get(1), biblioteca1.getCategorias().get(1));
        biblioteca1.crearLibro("Estrategias de un ganador", "444444", biblioteca1.getAutores().get(1), biblioteca1.getEditoriales().get(1), biblioteca1.getCategorias().get(2));
        v.escribirLibros(biblioteca1);
//biblioteca1.escribirLibros();
//        for (int i = 0; i < biblioteca1.getLibros().size(); i++) {
//            System.out.println("ID: "+biblioteca1.getLibros().get(i).getId()
//                    + "  " +biblioteca1.getLibros().get(i).getTitulo());
//        }
      
        //Copias        
        biblioteca1.crearCopia(biblioteca1.getLibros().get(0));
        biblioteca1.crearCopia(biblioteca1.getLibros().get(0));
        biblioteca1.crearCopia(biblioteca1.getLibros().get(0));
        biblioteca1.crearCopia(biblioteca1.getLibros().get(1));
        biblioteca1.crearCopia(biblioteca1.getLibros().get(1));
        biblioteca1.crearCopia(biblioteca1.getLibros().get(1));
        biblioteca1.crearCopia(biblioteca1.getLibros().get(2));
        biblioteca1.crearCopia(biblioteca1.getLibros().get(2));
        biblioteca1.crearCopia(biblioteca1.getLibros().get(2));
        biblioteca1.crearCopia(biblioteca1.getLibros().get(0));
        System.out.println("COPIAS REGISTRADAS EN LA BIBLIOTECA");
        v.escribirCopias(biblioteca1);
//        biblioteca1.escribirCopias();
//        for (int i = 0; i < biblioteca1.getCopias().size(); i++) {
//            System.out.println("ID: "+biblioteca1.getCopias().get(i).getId()+ 
//                    " "+biblioteca1.getCopias().get(i).getLibro().getTitulo());
//        }
        
        
        //Prestamos
        biblioteca1.crearPrestamo(1, biblioteca1.getClientes().get(0), biblioteca1.getCopias().get(7), date);
        biblioteca1.crearPrestamo(1, biblioteca1.getClientes().get(0), biblioteca1.getCopias().get(7), date);
        biblioteca1.crearPrestamo(1, biblioteca1.getClientes().get(2), biblioteca1.getCopias().get(3), date);
        biblioteca1.crearPrestamo(1, biblioteca1.getClientes().get(2), biblioteca1.getCopias().get(3), date);
        biblioteca1.crearPrestamo(1, biblioteca1.getClientes().get(2), biblioteca1.getCopias().get(3), date);
        biblioteca1.crearPrestamo(1, biblioteca1.getClientes().get(2), biblioteca1.getCopias().get(0), date);
        biblioteca1.crearPrestamo(1, biblioteca1.getClientes().get(0), biblioteca1.getCopias().get(7), date);
        biblioteca1.crearPrestamo(1, biblioteca1.getClientes().get(0), biblioteca1.getCopias().get(7), date);
        System.out.println("PRESTAMOS");
        v.escribirPrestamosBiblioteca(biblioteca1);
//biblioteca1.escribirPrestamos();
//        for (int i = 0; i < biblioteca1.getPrestamosTotales().size(); i++) {
//            System.out.println("ID: "+biblioteca1.getPrestamosTotales().get(i).getCopia().getId()+
//                    "  " +biblioteca1.getPrestamosTotales().get(i).getCopia().getLibro().getTitulo()
//            + "  " + biblioteca1.getPrestamosTotales().get(i).getCliente().getNombre()+ "  "
//            + biblioteca1.getPrestamosTotales().get(i).getFechaDevolucion());
//        }
System.out.println("LIBROS X CLIENTE");
v.escribirLibrosxCliente(biblioteca1, 2);

//        biblioteca1.escribirLibrosxCliente(1);

         System.out.println("FECHA ACTUAL " + sdf.format(date));
         System.out.println("\n*COPIAS TOTALES PRESTADAS*");
         System.out.println(v.totalCopiasPrestadas(biblioteca1));
         
         System.out.println("\n*LIBRO CON MAS PRESTAMOS*");
         v.escribirUnLibro(v.libroConMasCopiasenPrestamo(biblioteca1));

         
         //System.out.println(biblioteca1.libroConMasCopiasenPrestamo().getTitulo());

        System.out.println("\n\n");

    }

}
