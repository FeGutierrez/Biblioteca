package co.co.edu.unal.poo.biblioteca.vista;


import edu.unal.poo.biblioteca.datos.Libro;
import edu.unal.poo.biblioteca.datos.Biblioteca;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Flexxo333
 */
public class Vistas {

    public Vistas() {
    }
    //FORMATOS DE ESCRITURA
    
    public void escribirUnLibro(Libro libro){
        System.out.println("ID: " + libro.getId() + "\tTITULO: " + libro.getTitulo() + " \tAUTOR:" + libro.getAutor().getNombre()+" "+ libro.getAutor().getApellido());
    }
    
    public void escribirPrestamosBiblioteca(Biblioteca biblioteca){
        for (int i = 0; i < biblioteca.getPrestamosTotales().size(); i++) {
            System.out.println("ID: "+biblioteca.getPrestamosTotales().get(i).getCopia().getId()+
                    "    " + " Titulo: "+biblioteca.getPrestamosTotales().get(i).getCopia().getLibro().getTitulo()
            + "    " + "Cliente: "+biblioteca.getPrestamosTotales().get(i).getCliente().getNombre()+ "    "
            + "Fecha entrega: "+biblioteca.getPrestamosTotales().get(i).getFechaDevolucion());
        }
            System.out.println("\n");
    }
        
    public void escribirEditoriales(Biblioteca biblioteca){
        for (int i = 0; i < biblioteca.getEditoriales().size(); i++) {
            System.out.println("ID: "+biblioteca.getEditoriales().get(i).getId() + 
                    "  "+biblioteca.getEditoriales().get(i).getNombre());
        }
        System.out.println("\n");
    }
    public void escribirCategorias(Biblioteca biblioteca){
        for (int i = 0; i < biblioteca.getCategorias().size(); i++) {
            System.out.println("ID: "+biblioteca.getCategorias().get(i).getId() + 
                    "  "+biblioteca.getCategorias().get(i).getNombre() + " \t Horas: "+biblioteca.getCategorias().get(i).getHorasPrestamo());
        }
    }
    public void escribirAutores(Biblioteca biblioteca){
        for (int i = 0; i < biblioteca.getAutores().size(); i++) {
            System.out.println("ID: "+  biblioteca.getAutores().get(i).getId()+"  "+ biblioteca.getAutores().get(i).getNombre() + " " +
                    biblioteca.getAutores().get(i).getApellido());
        }
        System.out.println("\n");
    }
    
    public void escribirClientes(Biblioteca biblioteca){
        for (int i = 0; i < biblioteca.getClientes().size(); i++) {
            System.out.println("ID: "+biblioteca.getClientes().get(i).getId()+ " " +
                    biblioteca.getClientes().get(i).getNombre());
        }
    }
    public void escribirLibros(Biblioteca biblioteca){
        for (int i = 0; i < biblioteca.getLibros().size(); i++) {
            System.out.println("ID: "+biblioteca.getLibros().get(i).getId()
                    + "  " +biblioteca.getLibros().get(i).getTitulo());
        }
        System.out.println("\n");
    }
    
    
    public void escribirCopias(Biblioteca biblioteca){
        for (int i = 0; i < biblioteca.getCopias().size(); i++) {
            System.out.println("ID: "+biblioteca.getCopias().get(i).getId()+ 
                    " "+biblioteca.getCopias().get(i).getLibro().getTitulo());
        
        }
        System.out.println("\n");
    }
    
    public void escribirLibrosxCliente(Biblioteca biblioteca,int id){
        for (int i = 0; i < biblioteca.getClientes().get(id).getCopiasPrestadas().size(); i++) {
            System.out.println("ID CLIENTE: " + biblioteca.getClientes().get(id).getId() + " \t TITULO: " +
                    biblioteca.getClientes().get(id).getCopiasPrestadas().get(i).getLibro().getTitulo());
        } 
        System.out.println("\n");
    }
    
    public int totalCopiasPrestadas(Biblioteca biblioteca){
        return biblioteca.getPrestamosTotales().size();        
    }
    
    public Libro libroConMasCopiasenPrestamo(Biblioteca biblioteca){
        Libro masPrestamos = null;
        for (int i = 0; i < biblioteca.getLibros().size(); i++) {
            if (biblioteca.getLibros().get(i).getCopiasPrestadas() != null && masPrestamos == null) {
                masPrestamos=biblioteca.getLibros().get(i);
            } else {
                if (biblioteca.getLibros().get(i).getCopiasPrestadas()!=null && biblioteca.getLibros().get(i).getCopiasPrestadas().size() > masPrestamos.getCopiasPrestadas().size()) {
                    masPrestamos = biblioteca.getLibros().get(i);
                }
            }
        }
        return masPrestamos;
    }
            
    
    
}
