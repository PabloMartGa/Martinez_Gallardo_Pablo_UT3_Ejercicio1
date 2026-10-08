/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import clases.NaveDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAM2P
 */
public class LocalizadorConsultas {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/imperio_db";
    private static final String USER = "openpg";
    private static final String PASS = "openpgpwd";
    
    public static void main(String[] args) {
        System.out.println("Escaneando naves del imperio con hiperimpulsor activo >= 2");
        
        List<NaveDTO> navesFiltradas = buscarNavesHiperrapidas(2);
        
        for(NaveDTO nave: navesFiltradas){
            System.out.println(nave);
        }
    }
    
    public static List<NaveDTO> buscarNavesHiperrapidas(int potenciaMinima){
        String sql = "SELECT matricula, nombre, clase, potencia_hipermotor "
                + "FROM naves_imperiales "
                + "WHERE potencia_hipermotor >= ?;";
        
        List<NaveDTO> flotaDetectada = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setInt(1, potenciaMinima);
            
            try (ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    String mat = rs.getString("matricula");
                    String nom = rs.getString("nombre");
                    String cla = rs.getString("clase");
                    int pot = rs.getInt("potencia_hipermotor");
                    
                    flotaDetectada.add(new NaveDTO(mat, nom, cla, pot));
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Fallo en el barrido de holocron-consultas: " + e.getMessage());
        }
        
        return flotaDetectada;
    }
}
