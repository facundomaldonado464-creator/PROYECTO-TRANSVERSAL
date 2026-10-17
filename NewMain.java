
//PRUEBA DE AGREGAR ALKUMNO//


package principal;

import entidades.Alumno;
import persistencia.AlumnoData;
import persistencia.miConexion;
import java.time.LocalDate;

public class NewMain {
    public static void main(String[] args) {
        
        miConexion conexion = new miConexion();
        AlumnoData aluData = new AlumnoData(conexion);
        
        Alumno alumnoNuevo = new Alumno(-1, 39123456, "Lautaro Rodriguez", LocalDate.of(1996, 10, 18), true);
        
        System.out.println("Intentando guardar");
        aluData.guardarAlumno(alumnoNuevo);
    }
}