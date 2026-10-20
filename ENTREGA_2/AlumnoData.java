
package persistencia;

import entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class AlumnoData {
    
    private Connection con=null;
    
    public AlumnoData(miConexion conexion){
    
        this.con=conexion.buscarConexion();
    }

    public AlumnoData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    public void guardarAlumno(Alumno a){
    String sql="INSERT INTO alumno(dni,nombre,fechaNac,activo) VALUES(?,?,?,?)";
    
    try{
    PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,a.getDni());
            ps.setString(2,a.getNombre());
            ps.setDate(3,Date.valueOf(a.getFecNac()));
            ps.setBoolean(4,a.isActivo());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
            a.setId(rs.getInt(1));
            }else{
                System.out.println("No se pudo tener ID");
                System.out.println("Guardado");}
            ps.close();
                
    }catch(SQLException ex){
                    
                    System.out.println("Error al acceder a la tabla Alumno: ");
                    }
            
            
            
            
    }
    
    
    
public void actualizarAlumno(Alumno a){
        String sql = "UPDATE alumno SET dni = ?, nombre = ?, fechaNac = ?, activo = ? WHERE idAlumno = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,a.getDni());
            ps.setString(2,a.getNombre());
            ps.setDate(3, Date.valueOf(a.getFecNac()));
            ps.setBoolean(4,a.isActivo());
            ps.setInt(5,a.getId());
            
            
            int exito = ps.executeUpdate();
            if(exito == 1) {
                System.out.println("Alumno modificado");
            } else {
                System.out.println("El alumno no existe");
            }
            
            ps.close();
            
        } catch(SQLException ex){
            System.out.println("Error");
        }
    }
    
    
    
    public void borrarAlumno(int id){
    
    String query="DELETE FROM alumno WHERE idAlumno=?";
    
    try{
    PreparedStatement ps=con.prepareStatement(query);
    ps.setInt(1, id);
    ps.executeUpdate();
    ps.close();
    }catch(SQLException ex){
        System.out.println("Error");
    }
    
    }
    

   public List<Alumno> listarAlumnos() {
    List<Alumno> alumnos = new ArrayList<>();

    String sql = "SELECT idAlumno, dni, nombre, fechaNac, activo FROM alumno";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Alumno alumno = new Alumno();

            alumno.setId(rs.getInt("idAlumno"));
            alumno.setDni(rs.getInt("dni"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setFecNac(
                rs.getDate("fechaNac").toLocalDate()
            );
            alumno.setActivo(rs.getBoolean("activo"));

            alumnos.add(alumno);
        }

        rs.close();
        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(
            null,
            "Error al listar alumnos: " + ex.getMessage()
        );
    }

    return alumnos;
}
    
    
    public Alumno buscarAlumno(int id) {
        Alumno alumno = null;
        String sql = "SELECT dni, nombre, fechaNac, activo FROM alumno WHERE idAlumno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setId(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFecNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setActivo(rs.getBoolean("activo"));
            } else {
                System.out.println("No existe un alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
        return alumno;
    } //select 1
    
    // BAJA LOGICA (marcar al alumno como inactivo9
public void bajaLogica(int id) {
    String sql = "UPDATE alumno SET activo = 0 WHERE idAlumno = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int filas = ps.executeUpdate();

        if (filas > 0) {
            JOptionPane.showMessageDialog(null,
                "Alumno dado de baja correctamente.");
        } else {
            JOptionPane.showMessageDialog(null,
                "No existe un alumno con ese ID.");
        }

        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,
            "Error al dar de baja: " + ex.getMessage());
    }
}

// ALTA LOGICA (marcar al alumno como activo)
public void altaLogica(int id) {
    String sql = "UPDATE alumno SET activo = 1 WHERE idAlumno = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int filas = ps.executeUpdate();

        if (filas > 0) {
            JOptionPane.showMessageDialog(null,
                "Alumno dado de alta correctamente.");
        } else {
            JOptionPane.showMessageDialog(null,
                "No existe un alumno con ese ID.");
        }

        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,
            "Error al dar de alta: " + ex.getMessage());
    }
}
    
    }
    
    
    
    
    
    
    
    
    

