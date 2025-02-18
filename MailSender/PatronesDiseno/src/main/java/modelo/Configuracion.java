/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.List;

/**
 *
 * @author delll
 */
public class Configuracion {


    private List<Servidor> servidores;
    private List<Protocolo> protocolos;
    private List<Cuenta> cuentas;

    // Getters y setters
    public List<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(List<Servidor> servidores) {
        this.servidores = servidores;
    }

    public List<Protocolo> getProtocolos() {
        return protocolos;
    }

    public void setProtocolos(List<Protocolo> protocolos) {
        this.protocolos = protocolos;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }


}
