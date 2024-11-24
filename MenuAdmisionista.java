import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuAdmisionista extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private JButton botonIngresar;
    private JButton botonRegistrarse;

    @SuppressWarnings("unused")
    public MenuAdmisionista(JFrame programaDeCitas, CallCenter callCenter) {
        // Configuración de la ventana
        setTitle("Menú Admisionista");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear un panel con diseño
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta de instrucciones
        JLabel etiquetaTitulo = new JLabel("Por favor ingrese sus credenciales", SwingConstants.CENTER);
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(etiquetaTitulo, gbc);

        // Campo para el usuario
        JLabel etiquetaUsuario = new JLabel("Usuario:");
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(etiquetaUsuario, gbc);

        campoUsuario = new JTextField(15);
        gbc.gridx = 1;
        panel.add(campoUsuario, gbc);

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

        add(panel);

         // Acción al cerrar la ventana
         addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                programaDeCitas.setVisible(true);
            }
        });

        // Acción para el botón "Ingresar"
        botonIngresar.addActionListener(e -> {
            String usuario = campoUsuario.getText();
            String contraseña = new String(campoContrasena.getPassword());

            // Validar las credenciales con el CallCenter
            if (Admisionista.validarCredenciales(callCenter, usuario, contraseña)) {
                JOptionPane.showMessageDialog(MenuAdmisionista.this, "Inicio de sesión exitoso.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                
                // Abrir el menú de opciones del admisionista
                new MenuOpcionesAdmisionista(callCenter, programaDeCitas).setVisible(true);
                //dispose();
            } else {
                JOptionPane.showMessageDialog(MenuAdmisionista.this, "Credenciales incorrectas. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción para el botón "Registrarse"
        botonRegistrarse.addActionListener(e -> {
            RegistroAdmisionista registroAdmisionista = new RegistroAdmisionista(MenuAdmisionista.this, callCenter);
            registroAdmisionista.setVisible(true);
            MenuAdmisionista.this.setVisible(false);
        });
        

       
    }
}