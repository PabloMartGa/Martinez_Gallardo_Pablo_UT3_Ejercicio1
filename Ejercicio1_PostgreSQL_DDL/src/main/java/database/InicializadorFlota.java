/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DAM2P
 */
public class InicializadorFlota {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/imperio_db";
    private static final String USER = "openpg";
    private static final String PASS = "openpgpwd";
    
    public static void main(String[] args){
        
        String sql = "CREATE TABLE IF NOT EXISTS naves_imperiales ("
                    + "matricula VARCHAR(10) PRIMARY KEY, "
                    + "nombre VARCHAR(100) NOT NULL, "
                    + "clase VARCHAR(50) NOT NULL, "
                    + "potencia_hipermotor INT NOT NULL);";
        
        System.out.println("Estableciendo canal seguro con la terminal del SGDB....");
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                Statement stmt = conn.createStatement()){

            stmt.execute(sql);
            
            System.out.println("Infraestructura DDL completada: Tabla 'naves_imperiales' verificada en el sector");
            
        } catch (SQLException e) {
            System.err.println("Error en la red DDL: " + e.getMessage());
        }
    }
}
