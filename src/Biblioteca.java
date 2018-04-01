
import java.util.ArrayList;
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
public class Biblioteca {
    
    private String nombre;
    private ArrayList<Libro> libros = new ArrayList<>();
    private ArrayList<Copia> copias = new ArrayList<>();
    private ArrayList<Editorial> editoriales = new ArrayList<>();
    private ArrayList<Autor> autores = new ArrayList<>();
    private ArrayList<Categoria> categorias = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Copia> copiasPrestadas = new ArrayList<>();
    private ArrayList<Prestamo> prestamosTotales = new ArrayList<>();

    public Biblioteca(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public ArrayList<Copia> getCopias() {
        return copias;
    }

    public void setCopias(ArrayList<Copia> copias) {
        this.copias = copias;
    }

    public ArrayList<Editorial> getEditoriales() {
        return editoriales;
    }

    public void setEditoriales(ArrayList<Editorial> editoriales) {
        this.editoriales = editoriales;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Copia> getCopiasPrestadas() {
        return copiasPrestadas;
    }

    public void setCopiasPrestadas(ArrayList<Copia> copiasPrestadas) {
        this.copiasPrestadas = copiasPrestadas;
    }

    public ArrayList<Prestamo> getPrestamosTotales() {
        return prestamosTotales;
    }

    public void setPrestamosTotales(ArrayList<Prestamo> prestamosTotales) {
        this.prestamosTotales = prestamosTotales;
    }
    
    public boolean crearAutor(String nombre, String apellido){
        Autor autor = new Autor(nombre, apellido);
        this.autores.add(autor);
        autor.setId(this.autores.size()-1);
        return true;
    }
    
    public boolean crearEditorial(String nombre, int nit){
        Editorial editorial = new Editorial(nombre, nit);
        this.editoriales.add(editorial);
        editorial.setId(this.editoriales.size()-1);
        return true;
    }
    
    public boolean crearCliente(int cedula, String nombre, String apellido, int estrato, boolean estudiante){
        Cliente cliente = new Cliente(cedula, nombre, apellido, estrato, estudiante);
        this.clientes.add(cliente);
        cliente.setId(this.clientes.size()-1);
        return true;
    }
    
    public boolean crearLibro(String titulo, String isbn, Autor autor, Editorial editorial, Categoria categoria){
        Libro libro = new Libro(titulo, titulo, autor, editorial, categoria);
        this.libros.add(libro);
        libro.setId(this.libros.size()-1);
        return true;
    }
    
    public boolean crearCategoria(String nombre, int horasPrestamo){
        Categoria categoria = new Categoria(nombre, horasPrestamo);
        this.categorias.add(categoria);
        categoria.setId(this.categorias.size()-1);
        return true;
    }
    
    public boolean crearCopia(Libro libro){
        Copia cop = new Copia(libro);
        this.copias.add(cop);
        cop.setId(this.copias.size()-1);
        libro.getCopiasLibro().add(cop);
        return true;
        
    };
    
    public boolean crearPrestamo(int id, Cliente cliente, Copia copia, Date date){
        //En cada prestamo se asocia un unico libro
        //Ya que las categorias dan fechas de devolucion diferentes
        
        if (cliente.getCopiasPrestadas().size()>=5) {
            return false;
            //Este IF valida si el cliente tiene adquiridas 5 copias a su 
            //nombre, en cuyo caso no registra el prestamo
        }
        
        Prestamo prestamo = new Prestamo(id, cliente, copia, date);
        this.copiasPrestadas.add(copia);
        this.prestamosTotales.add(prestamo);
        copia.getLibro().getCopiasLibro().add(copia);
        prestamo.fechaFinalDeDevolucion(date, copia);
        cliente.getCopiasPrestadas().add(copia);
        cliente.getPrestamos().add(prestamo);
        return true;
    };
    
    public int totalCopiasPrestadas(){
        return prestamosTotales.size();
    }
    
    public Libro libroConMasCopiasenPrestamo(){
        Libro masPrestamos = null;
        for (int i = 0; i < this.libros.size(); i++) {
            if (this.libros.get(i) != null && masPrestamos == null) {
                masPrestamos=this.libros.get(i);
            } else {
                if (this.libros.get(i)!=null && this.libros.get(i).getCopiasLibro().size() > masPrestamos.getCopiasLibro().size()) {
                    masPrestamos = this.libros.get(i);
                }
            }
        }
        return masPrestamos;
    }
    
    public void escribirPrestamos(){
        for (int i = 0; i < this.getPrestamosTotales().size(); i++) {
            System.out.println("ID: "+this.getPrestamosTotales().get(i).getCopia().getId()+
                    "    " + " Titulo: "+this.getPrestamosTotales().get(i).getCopia().getLibro().getTitulo()
            + "    " + "Cliente: "+this.getPrestamosTotales().get(i).getCliente().getNombre()+ "    "
            + "Fecha entrega: "+this.getPrestamosTotales().get(i).getFechaDevolucion());
        }
    }
    
    public void escribirEditoriales(){
        for (int i = 0; i < this.getEditoriales().size(); i++) {
            System.out.println("ID: "+this.getEditoriales().get(i).getId() + 
                    "  "+this.getEditoriales().get(i).getNombre());
        }
    }
    public void escribirCategorias(){
        for (int i = 0; i < this.getCategorias().size(); i++) {
            System.out.println("ID: "+this.getCategorias().get(i).getId() + 
                    "  "+this.getCategorias().get(i).getNombre());
        }
    }
    public void escribirAutores(){
        for (int i = 0; i < this.getAutores().size(); i++) {
            System.out.println("ID: "+  this.getAutores().get(i).getId()+"  "+ this.getAutores().get(i).getNombre() + " " +
                    this.getAutores().get(i).getApellido());
        }
    }
    
    public void escribirClientes(){
        for (int i = 0; i < this.getClientes().size(); i++) {
            System.out.println("ID: "+this.getClientes().get(i).getId()+ " " +
                    this.getClientes().get(i).getNombre());
        }
    }
    public void escribirLibros(){
        for (int i = 0; i < this.getLibros().size(); i++) {
            System.out.println("ID: "+this.getLibros().get(i).getId()
                    + "  " +this.getLibros().get(i).getTitulo());
        }
    }
    
    
    public void escribirCopias(){
        for (int i = 0; i < this.copias.size(); i++) {
            System.out.println("ID: "+this.getCopias().get(i).getId()+ 
                    " "+this.getCopias().get(i).getLibro().getTitulo());
        
        }
    }
    
}
