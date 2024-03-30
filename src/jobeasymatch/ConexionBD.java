/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobeasymatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // Parámetros de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/local";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";
    
    // Método para establecer la conexión a la base de datos
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }
}
