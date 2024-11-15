package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegistroPaciente extends JFrame {
    private JFrame menupaciente;
    private JTextField camponombre;
    private JTextField campoapellido;
    private JTextField campodocumento;
    private JPasswordField campocontraseña;
    private JButton botonRegistrarse;

    public RegistroPaciente(JFrame menupaciente) {
        this.menupaciente = menupaciente;

        // Configuración de la ventana del menú del admisionista
        setTitle("Programa de citas");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());  // Usamos GridBagLayout para centrar los elementos
        setLocationRelativeTo(null);  // Centrar en la pantalla

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

       
        // Crear un panel con GridBagLayout para posicionar los elementos
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Margen entre los elementos
        gbc.fill = GridBagConstraints.HORIZONTAL;

       // Etiqueta de instrucciones
       JLabel etiquetaTitulo = new JLabel("Por favor ingrese sus credenciales", SwingConstants.CENTER);
       etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 14));
       gbc.gridx = 0;
       gbc.gridy = 0;
       gbc.gridwidth = 2;
       panel.add(etiquetaTitulo, gbc);


       // Campo para el nombre
       JLabel etiquetanombre = new JLabel("Nombre:");
       gbc.gridy = 1;
       gbc.gridwidth = 1;
       panel.add(etiquetanombre, gbc);

       camponombre = new JTextField(15);
       gbc.gridx = 1;
       panel.add(camponombre, gbc);

       // Campo para el apellido
       JLabel etiquetapellido = new JLabel("Apellido:");
       gbc.gridy = 2;
       gbc.gridx = 0;
       gbc.gridwidth = 1;
       panel.add(etiquetapellido, gbc);

       campoapellido = new JTextField(15);
       gbc.gridx = 1;
       panel.add(campoapellido, gbc);

       // Campo para el documento
       JLabel etiquetadocumento = new JLabel("Identificación");
       gbc.gridy = 3;
       gbc.gridx = 0;
       gbc.gridwidth = 1;
       panel.add(etiquetadocumento, gbc);

       campodocumento = new JTextField(15);
       gbc.gridx = 1;
       panel.add(campodocumento, gbc);

       // Campo para la contraseña
       JLabel etiquetacontraseña = new JLabel("Contraseña:");
       gbc.gridx = 0;
       gbc.gridy = 4;
       panel.add(etiquetacontraseña, gbc);

       campocontraseña = new JPasswordField(15);
       gbc.gridx = 1;
       panel.add(campocontraseña, gbc);


        // Añadir un listener para detectar el cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Mostrar la ventana anterior al cerrar esta
                menupaciente.setVisible(true);
            }
        });

        // Botón de registrarse
        botonRegistrarse = new JButton("Registrarse");
        gbc.gridy = 5;
        panel.add(botonRegistrarse, gbc);

        // Texto
        //JLabel label = new JLabel("¡Ingrese los datos seleccionados!");
        //label.setBounds(0, 50, 200, 30);
         //add(label);
         add(panel);
    }
}