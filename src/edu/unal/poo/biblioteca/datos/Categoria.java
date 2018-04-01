package edu.unal.poo.biblioteca.datos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Flexxo333
 */
public class Categoria {
    
    private int id;
    private String nombre;
    private int horasPrestamo;

    public Categoria(String nombre, int horasPrestamo) {
        this.nombre = nombre;
        this.horasPrestamo = horasPrestamo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasPrestamo() {
        return horasPrestamo;
    }

    public void setHorasPrestamo(int horasPrestamo) {
        this.horasPrestamo = horasPrestamo;
    }
    
    

    
}
