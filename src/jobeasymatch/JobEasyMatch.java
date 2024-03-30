/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jobeasymatch;
import vistas.inicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author BREINER
 */
public class JobEasyMatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conexion = null;
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        
        try {
            // Establecer la conexión
            conexion = ConexionBD.conectar();
            
            // Ejecutar una consulta
            String sql = "SELECT * FROM user";
            consulta = conexion.prepareStatement(sql);
            resultado = consulta.executeQuery();
            
            // Procesar los resultados
            while (resultado.next()) {
              
                System.out.println("CONECTADO A LA DB, TODO BIEN.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión y los recursos
            try {
                if (resultado != null) resultado.close();
                if (consulta != null) consulta.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    
        inicio viewMain = new inicio();
        viewMain.setVisible(true);
    }
    
}
}
