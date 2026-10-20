/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDate;

/**
 *
 * @author facun
 */
public class Alumno {
    
    private int id=-1;
    private int dni;
    private String nombre;
    private LocalDate fecNac;
    private boolean activo;

    public Alumno(int id, int dni, String nombre, LocalDate fecNac, boolean activo) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.fecNac = fecNac;
        this.activo = activo;
    }
    
    public Alumno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return id+"-"+nombre;
    }
   
}
