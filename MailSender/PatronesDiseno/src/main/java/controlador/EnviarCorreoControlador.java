/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Configuracion;
import vista.EnviarCorreo;
import javax.swing.*;
import modelo.Correo;

/**
 *
 * @author delll
 */
public class EnviarCorreoControlador {
    private Configuracion configuracion;
    private EnviarCorreo vista;

    public EnviarCorreoControlador(Configuracion configuracion, EnviarCorreo vista) {
        this.configuracion = configuracion;
        this.vista = vista;
        inicializarVista();
        añadirListeners();
    }

    

    // Inicializa los datos en los componentes de la vista
    private void inicializarVista() {
        // Cargar datos en los comboBox desde la configuración
        vista.getComboBoxServidor().setModel(new DefaultComboBoxModel<>(
                configuracion.getServidores().stream().map(s -> s.getNombre()).toArray(String[]::new)));
        vista.getComboBoxCuenta().setModel(new DefaultComboBoxModel<>(
                configuracion.getCuentas().stream().map(c -> c.getDireccionCorreo()).toArray(String[]::new)));
        vista.getComboBoxProtocolo().setModel(new DefaultComboBoxModel<>(
                configuracion.getProtocolos().stream().map(p -> p.getNombre()).toArray(String[]::new)));
    }

    // Añade los listeners a los componentes de la vista
    private void añadirListeners() {
        // Listener para el botón "Enviar"
        vista.getBtnEnviar().addActionListener(e -> enviarCorreo());
        
        // Listener para el botón "Salir"
        vista.getBtnSalir().addActionListener(e -> salir());
    }

    // Lógica para enviar el correo
    private void enviarCorreo() {
        // Crear un objeto Correo con los datos ingresados por el usuario
        Correo correo = new Correo();
        correo.setDestinatario(vista.getTextFieldDestinatario().getText());
        correo.setAsunto(vista.getTextFieldAsunto().getText());
        correo.setContenido(vista.getTextAreaContenido().getText());
        correo.setCuenta(configuracion.getCuentas().get(vista.getComboBoxCuenta().getSelectedIndex()));
        correo.setProtocolo(configuracion.getProtocolos().get(vista.getComboBoxProtocolo().getSelectedIndex()));

        // Aquí se agregaría la lógica para enviar el correo, por ejemplo, usando una librería de envío de emails
        // Mostrar un mensaje de éxito o error dependiendo del resultado
        JOptionPane.showMessageDialog(vista, "Correo enviado con éxito");
    }

    // Lógica para salir de la aplicación
    private void salir() {
        System.exit(0);
    }
}
