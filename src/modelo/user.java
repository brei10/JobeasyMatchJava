/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jobeasymatch.ConexionBD;
import java.sql.*;
import java.sql.PreparedStatement;


/**
 *
 * @author BREINER
 */

public class user {
    // Método para registrar un nuevo usuario en la base de datos
    public static void registrarUsuario(String nombre, String correo, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        


        try {
            conn = ConexionBD.conectar();
            String sql = "INSERT INTO user (nombre, correo, password) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, correo);
            pstmt.setString(3, password);

            pstmt.executeUpdate();
            System.out.println("Usuario registrado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }

    // Método para verificar si ya existe un usuario con el correo dado
    public static boolean existeUsuario(String correo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean existe = false;

        try {
            conn = ConexionBD.conectar();
            String sql = "SELECT * FROM user WHERE correo = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, correo);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar usuario: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }

        return existe;
    }
    
     // Método para obtener la contraseña asociada a un correo electrónico
    public static String obtenerContraseña(String correo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String contraseña = null;

        try {
            conn = ConexionBD.conectar();
            String sql = "SELECT password FROM user WHERE correo = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, correo);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                contraseña = rs.getString("password");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener contraseña: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }

        return contraseña;
    }
}
