/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DAM2P
 */
public class RegistrarNaves {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/imperio_db";
    private static final String USER = "openpg";
    private static final String PASS = "openpgpwd";
    
    public static void main(String[] args){
        registrarNaves("N-001", "TIE Fighter Alfa", "Caza", 0);
        registrarNaves("N-002", "Destructor Ejecutor", "Estelar", 4);
    }
    
    
    public static void registrarNaves(String matricula, String nombre, String clase, int potencia){
        
        String sql = "INSERT INTO naves_imperiales (matricula, nombre, clase, potencia_hipermotor) VALUES (?,?,?,?)";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setString(1, matricula);
            pstmt.setString(2, nombre);
            pstmt.setString(3, clase);
            pstmt.setInt(4, potencia);
            
            int registrosAfectados = pstmt.executeUpdate();
            
            System.out.println("Operacion DML completada. Registros añadidos: " + registrosAfectados);
            
        } catch (SQLException e) {
            System.err.println("Registro cancelado. Error: " + e.getMessage());
        }
    }
}
