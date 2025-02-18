/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author delll
 */
public class Cuenta {
     private String direccionCorreo;
    private Servidor servidor;

    // Getters y setters
    public String getDireccionCorreo() {
        return direccionCorreo;
    }

    public void setDireccionCorreo(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }
}
