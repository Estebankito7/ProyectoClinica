package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuAdmisionista extends JFrame {
    private JTextField campoClave;
    private JPasswordField campoContrasena;
    private JButton botonIngresar;
    private JButton botonRegistrarse;
    //private ProgramaDeCitas1 ventanaPrincipal;
    private JFrame programadecitas;

    public MenuAdmisionista(JFrame programadecitas) {
        // Guardar la referencia de la ventana principal
        this.programadecitas = programadecitas;

        // Configuración de la ventana del menú del admisionista
        setTitle("Programa de citas");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());  // Usamos GridBagLayout para centrar los elementos
        setLocationRelativeTo(null);  // Centrar en la pantalla

        // Agregar un listener para cuando se cierre esta ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Al cerrar esta ventana, volver a mostrar la ventana principal
                programadecitas.setVisible(true);
            }
        });

        // Crear un panel con GridBagLayout para posicionar los elementos
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Margen entre los elementos
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta de instrucciones
        JLabel etiquetaTitulo = new JLabel("Por favor ingrese sus credenciales", SwingConstants.CENTER);
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(etiquetaTitulo, gbc);

        // Campo para la clave
        JLabel etiquetaClave = new JLabel("Clave:");
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(etiquetaClave, gbc);

        campoClave = new JTextField(15);
        gbc.gridx = 1;
        panel.add(campoClave, gbc);

        // Campo para la contraseña
        JLabel etiquetaContrasena = new JLabel("Contraseña:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(etiquetaContrasena, gbc);

        campoContrasena = new JPasswordField(15);
        gbc.gridx = 1;
        panel.add(campoContrasena, gbc);

        // Botón de ingreso
        botonIngresar = new JButton("Ingresar");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(botonIngresar, gbc);

        // Botón de registrarse
        botonRegistrarse = new JButton("Registrarse");
        gbc.gridy = 4;
        panel.add(botonRegistrarse, gbc);

        // Agregar el panel a la ventana
        add(panel);
    }
}

