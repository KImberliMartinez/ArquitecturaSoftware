/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.patronesdiseno;

import controlador.EnviarCorreoControlador;
import java.io.File;
import modelo.Configuracion;
import util.ConfiguracionLoader;
import vista.Menu;
/**
 *
 * @author delll
 */
public class PatronesDiseno {

    public static void main(String[] args) {
        String rutaArchivo = "resources/configuracion.txt";
        System.out.println(new File(rutaArchivo).getAbsolutePath());
        // Iniciar la recarga dinámica de la configuración
        new Thread(ConfiguracionLoader::iniciarRecargaDinamica).start();
        // Cargar la configuración desde el archivo de texto
        Configuracion configuracion = ConfiguracionLoader.cargarConfiguracion();
 if (configuracion != null) {
            System.out.println(configuracion.getServidores());
                Menu menuView = new Menu(configuracion);
        menuView.setVisible(true);
    
        } else {
            System.out.println("Failed to load configuration.");
        }
    }
        // Crear y mostrar la vista del menú
    
}
