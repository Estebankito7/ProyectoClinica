import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegistroAdmisionista extends JFrame {
    private JTextField campoNombre;
    private JTextField campoDocumento;
    private JTextField campoCorreo;
    private JTextField campoClave;
    private JTextField campoUsuario;
    private JPasswordField campoContraseña;
    private JButton botonRegistrar;
    private JFrame menuAdmisionista;
    private CallCenter callCenter;

    private static final String CLAVE_ESPECIFICA = "890303461";

    public RegistroAdmisionista(JFrame menuAdmisionista, CallCenter callCenter) {
        this.menuAdmisionista = menuAdmisionista;
        this.callCenter = callCenter;

        setTitle("Registro de Admisionista");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                menuAdmisionista.setVisible(true);
            }
        });

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel etiquetaTitulo = new JLabel("Ingrese los datos del nuevo Admisionista", SwingConstants.CENTER);
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(etiquetaTitulo, gbc);

        JLabel etiquetaNombre = new JLabel("Nombre:");
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(etiquetaNombre, gbc);

        campoNombre = new JTextField(15);
        gbc.gridx = 1;
        panel.add(campoNombre, gbc);

        JLabel etiquetaDocumento = new JLabel("Documento:");
        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(etiquetaDocumento, gbc);

        campoDocumento = new JTextField(15);
        gbc.gridx = 1;
        panel.add(campoDocumento, gbc);

        JLabel etiquetaCorreo = new JLabel("Correo:");
        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(etiquetaCorreo, gbc);

        campoCorreo = new JTextField(15);
        gbc.gridx = 1;
        panel.add(campoCorreo, gbc);

        JLabel etiquetaUsuario = new JLabel("Usuario:");
        gbc.gridy = 4;
        gbc.gridx = 0;
        panel.add(etiquetaUsuario, gbc);

        campoUsuario = new JTextField(15);
        gbc.gridx = 1;
        panel.add(campoUsuario, gbc);

        JLabel etiquetaContraseña = new JLabel("Contraseña:");
        gbc.gridy = 5;
        gbc.gridx = 0;
        panel.add(etiquetaContraseña, gbc);

        campoContraseña = new JPasswordField(15);
        gbc.gridx = 1;
        panel.add(campoContraseña, gbc);

        JLabel etiquetaClave = new JLabel("Clave IPS:");
        gbc.gridy = 6;
        gbc.gridx = 0;
        panel.add(etiquetaClave, gbc);

        campoClave = new JTextField(15);
        gbc.gridx = 1;
        panel.add(campoClave, gbc);

        botonRegistrar = new JButton("Registrar");
        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(botonRegistrar, gbc);

        add(panel);

        botonRegistrar.addActionListener(e -> {
            String nombre = campoNombre.getText();
            String documento = campoDocumento.getText();
            String correo = campoCorreo.getText();
            String usuario = campoUsuario.getText();
            String contraseña = new String(campoContraseña.getPassword());
            String clave = campoClave.getText();

            if (nombre.isEmpty() || documento.isEmpty() || correo.isEmpty() || usuario.isEmpty() || contraseña.isEmpty() || clave.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!clave.equals(CLAVE_ESPECIFICA)) {
                JOptionPane.showMessageDialog(this, "La clave ingresada es incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Admisionista nuevoAdmisionista = new Admisionista(nombre, documento, "N/A", "N/A", correo, usuario, contraseña);
                callCenter.agregarAdmisionista(nuevoAdmisionista);

                JOptionPane.showMessageDialog(this, "Admisionista registrado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                campoNombre.setText("");
                campoDocumento.setText("");
                campoCorreo.setText("");
                campoUsuario.setText("");
                campoContraseña.setText("");
                campoClave.setText("");
                menuAdmisionista.setVisible(true);
                dispose();
            }
        });
    }
}
