/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author flopy
 */
public class Cursada {
    private int idCursada;
    private int idAlumno;
    private int idMateria;
    private int nota;
    
    public Cursada(){ 
        
    }

    public Cursada(int idCursada, int idAlumno, int idMateria, int nota) {
        this.idCursada = idCursada;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.nota = nota;
    }

    public int getIdCursada() {
        return idCursada;
    }

    public void setIdCursada(int idCursada) {
        this.idCursada = idCursada;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int IdMateria) {
        this.idMateria = IdMateria;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    @Override 
    public String toString() {
        return "Cursada{Id= " + idCursada + ", IdALumno= " + idAlumno + ", idMateria= " + idMateria + ", Nota= " + nota + "}";
    }
}
