/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author DAM2P
 */
public class NaveDTO {
    
    private String matricula;
    private String nombre;
    private String clase;
    private int potenciaHipermotor;

    public NaveDTO() {
    }

    public NaveDTO(String matricula, String nombre, String clase, int potenciaHipermotor) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.clase = clase;
        this.potenciaHipermotor = potenciaHipermotor;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
    }

    /**
     * @return the potenciaHipermotor
     */
    public int getPotenciaHipermotor() {
        return potenciaHipermotor;
    }

    /**
     * @param potenciaHipermotor the potenciaHipermotor to set
     */
    public void setPotenciaHipermotor(int potenciaHipermotor) {
        this.potenciaHipermotor = potenciaHipermotor;
    }
    
    
    @Override
    public String toString(){
        return "Matricula: " + matricula + " | Nombre: " + nombre + " | Clase: " + clase + " | Potencia: " + potenciaHipermotor;
    }
}
