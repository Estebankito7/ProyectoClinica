import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdmisionista extends JFrame {
    private JTextField campoClave;
    private JPasswordField campoContrasena;
    private JButton botonIngresar;
    private JButton botonRegistrarse;

    public MenuAdmisionista(JFrame programadecitas) {
        // Configuración de la ventana del menú del admisionista
        setTitle("Menú Admisionista");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());  // Usamos GridBagLayout para centrar los elementos
        setLocationRelativeTo(null);  // Centrar en la pantalla

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

        // Campo para la clave (usuario)
        JLabel etiquetaClave = new JLabel("Usuario:");
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

        // Acción para el botón "Ingresar"
        botonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoClave.getText();
                String contraseña = new String(campoContrasena.getPassword());

                if (Admisionista.validarCredenciales(usuario, contraseña)) {
                    JOptionPane.showMessageDialog(MenuAdmisionista.this, "Inicio de sesión exitoso.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    programadecitas.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(MenuAdmisionista.this, "Credenciales incorrectas. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        botonRegistrarse.addActionListener(e -> {
            RegistroAdmisionista registroAdmisionista = new RegistroAdmisionista(this);
            registroAdmisionista.setVisible(true);
            this.setVisible(false); // Ocultar la ventana actual
        });
        
}
}