package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuPaciente extends JFrame {
    private JButton botonRegistrarse;
    private JButton botonSolicitudCitas;
    private JButton botonCancelarCitas;
    private JButton botonActualizacionDatos;
    private ProgramaDeCitas ventanaPrincipal;

    public MenuPaciente(ProgramaDeCitas ventanaPrincipal) {
        // Guardar la referencia de la ventana principal
        this.ventanaPrincipal = ventanaPrincipal;

        // Configuración de la ventana del menú del paciente
        setTitle("Programa de citas");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));  // Mantener GridLayout con 5 filas
        setLocationRelativeTo(null);  // Centrar en la pantalla

        // Agregar un listener para cuando se cierre esta ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Al cerrar esta ventana, volver a mostrar la ventana principal
                ventanaPrincipal.setVisible(true);
            }
        });

        // Crear el texto de bienvenida
        JLabel mensajeBienvenida = new JLabel("Bienvenido querido usuario, porfavor seleccione una opcion:", SwingConstants.CENTER);
        mensajeBienvenida.setFont(new Font("Arial", Font.BOLD, 14));

        // Crear los botones del menú
        botonRegistrarse = new JButton("Registrarse");
        botonSolicitudCitas = new JButton("Solicitud de citas");
        botonCancelarCitas = new JButton("Cancelar citas");
        botonActualizacionDatos = new JButton("Actualización de datos");

        // Agregar los elementos al panel con GridLayout
        add(mensajeBienvenida);  // Añadir el mensaje de bienvenida
        add(botonRegistrarse);
        add(botonSolicitudCitas);
        add(botonCancelarCitas);
        add(botonActualizacionDatos);
    }
}

