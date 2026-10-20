
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class miConexion {


    private String url = "jdbc:mariadb://localhost:3306/universidad";
    private String usuario = "root";
    private String password = "";

    private static Connection conexion = null;

    public Connection buscarConexion() {

        try {
            if (conexion == null || conexion.isClosed()) {
                Class.forName("org.mariadb.jdbc.Driver");

                conexion = DriverManager.getConnection(
                    url, usuario, password
                );
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(
                null,
                "No se pudo conectar a la base de datos: "
                + ex.getMessage()
            );
        }

        return conexion;
    }

    public static Connection getConnection() {
        miConexion nuevaConexion = new miConexion();
        return nuevaConexion.buscarConexion();
    }
}

