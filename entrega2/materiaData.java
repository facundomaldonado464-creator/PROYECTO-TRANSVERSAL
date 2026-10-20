/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author flopy
 */
public class materiaData {
    public void insertar(Materia m) throws SQLException {
        String sql = "INSERT INTO materia (nombre, anio, activo) VALUES (?,?,?)";
        try (Connection con = miConexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnio());
            ps.setBoolean(3, m.isActivo());
            ps.executeUpdate();
        }
    }
    
    public void borrar(int idMateria) throws SQLException {
        String sql = "DELETE FROM materia WHERE idMateria=?";
        try (Connection con = miConexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, idMateria);
            ps.executeUpdate();
        }
                
    }
    
    public void bajaLogica(int idMateria) throws SQLException {
        String sql = "UPDATE materia SET activo=0 WHERE idMateria=?";
        try (Connection con = miConexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, idMateria);
            ps.executeUpdate();
            
        }
    }
    
    public void altaLogica(int idMateria) throws SQLException {
        String sql = "UPDATE materia SET activo=1 WHERE idMateria=?";
        try (Connection con = miConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idMateria);
            ps.executeUpdate();
        }
    }
    
    public Materia buscar(int idMateria) throws SQLException {
        String sql = "SELECT * FROM materia WHERE idMateria=?";
        try (Connection con = miConexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idMateria);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Materia(
                            rs.getInt("idMateria"),
                            rs.getString("nombre"),
                            rs.getInt("anio"),
                            rs.getBoolean("activo")
                    );
                }
            }
        }
    return null;
    }
    
public List<Materia> listarTodas() throws SQLException {
    List<Materia> lista = new ArrayList<>();
    String sql = "SELECT * FROM materia";
    try (Connection con = miConexion.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            lista.add(new Materia(
              rs.getInt("idMateria"),
              rs.getString("nombre"),
              rs.getInt("anio"),
              rs.getBoolean("activo")
            ));
        }
    }
    
    return lista;
        
    }

public void actualizar(Materia m) throws SQLException {
    String sql = "UPDATE materia SET nombre=?, anio=?, activo=? "
               + "WHERE idMateria=?";

    try (Connection con = miConexion.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, m.getNombre());
        ps.setInt(2, m.getAnio());
        ps.setBoolean(3, m.isActivo());
        ps.setInt(4, m.getIdMateria());

        int filas = ps.executeUpdate();

        if (filas == 0) {
            throw new SQLException(
                "No existe una materia con ese ID."
            );
        }
    }
}

}

        
  


