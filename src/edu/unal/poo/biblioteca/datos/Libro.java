package edu.unal.poo.biblioteca.datos;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Flexxo333
 */
public class Libro {
    private int id;
    private String titulo;
    private String isbn;
    private Autor autor;
    private Editorial editorial;
    private Categoria categoria;
    private ArrayList<Copia> copiasLibro = new ArrayList<>();
    private ArrayList<Copia> copiasPrestadas = new ArrayList<>();

    public Libro(String titulo, String isbn, Autor autor, Editorial editorial, Categoria categoria) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editorial = editorial;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Copia> getCopiasLibro() {
        return copiasLibro;
    }

    public void setCopiasLibro(ArrayList<Copia> copiasLibro) {
        this.copiasLibro = copiasLibro;
    }

    public ArrayList<Copia> getCopiasPrestadas() {
        return copiasPrestadas;
    }

    public void setCopiasPrestadas(ArrayList<Copia> copiasPrestadas) {
        this.copiasPrestadas = copiasPrestadas;
    }
    
    
    
}
