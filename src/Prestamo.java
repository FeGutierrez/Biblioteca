
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
public class Prestamo {
    
    private int id;
    private Cliente cliente;
    private Copia copia;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    
    DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
    
    public Prestamo(int id, Cliente cliente, Copia copia, Date fechaPrestamo) {
        this.id = id;
        this.cliente = cliente;
        this.copia = copia;
        this.fechaPrestamo = fechaPrestamo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Copia getCopia() {
        return copia;
    }

    public void setCopia(Copia copia) {
        this.copia = copia;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public Date sumarDias(Date fecha, int dias){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }
    
    public Date sumarHoras(Date fecha, int horas){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR)+ horas);        
        return calendar.getTime();
    }
    
    public void fechaFinalDeDevolucion(Date fecha, Copia copia){
        fecha = this.fechaPrestamo;
        int horas = copia.getLibro().getCategoria().getHorasPrestamo();
        Date fechaFinal = sumarHoras(fecha, horas);
        setFechaDevolucion(fechaFinal);        
    }
    
    
    
}
