/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import com.google.gson.Gson;
import modelo.Configuracion;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
/**
 *
 * @author delll 
 * Esta clase se encarga de :
 *Cargar la Configuración: Lee el archivo de configuración y devuelve un objeto Configuracion.
 * Recarga Dinámica: Monitorea el archivo de configuración y recarga los datos si hay cambios.
*/
public class ConfiguracionLoader {
     private static Configuracion configuracion;
    private static final String rutaArchivo = "resources/configuracion.txt";
    public static Configuracion cargarConfiguracion() {
        Gson gson = new Gson();
        Configuracion configuracion = null;
        try (FileReader reader = new FileReader(rutaArchivo)) {
            configuracion = gson.fromJson(reader, Configuracion.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configuracion;
    }
    public static void iniciarRecargaDinamica() {
        Path path = Paths.get(rutaArchivo);
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            path.getParent().register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
            System.out.println("Iniciando la monitorización de cambios en la configuración...");

            while (true) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY &&
                        event.context().toString().equals(path.getFileName().toString())) {
                        System.out.println("Archivo de configuración modificado. Recargando...");
                        cargarConfiguracion();
                    }
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
