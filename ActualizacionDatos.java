import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.awt.event.*;

public class ActualizacionDatos extends JFrame {

    public ActualizacionDatos(JFrame menupaciente, CallCenter callCenter) {

        // Configuración de la ventana del menú del paciente
        setTitle("Verificación de identidad");
        setSize(400, 300); // Tamaño ajustado para más espacio visual
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 240, 240)); // Fondo más claro

        // Panel del título
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(0, 123, 255)); // Fondo azul moderno
        JLabel titleLabel = new JLabel("Verificación de identidad");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE); // Texto en blanco
        titlePanel.add(titleLabel);

        // Panel del formulario
        JPanel formPanel = new JPanel();
        formPanel.setBackground(new Color(240, 240, 240)); // Fondo a juego
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Espaciado
        formPanel.setLayout(new GridLayout(2, 2, 10, 15)); // Espaciado vertical ajustado

        JLabel idLabel = new JLabel("Identificación:");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField idField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JPasswordField passwordField = new JPasswordField(15);

        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        // Panel para el botón
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 240, 240)); // Fondo a juego
        JButton changeButton = new JButton("Proceder al cambio de datos");
        changeButton.setBackground(new Color(220, 53, 69)); // Rojo moderno
        changeButton.setForeground(Color.WHITE); // Texto blanco
        changeButton.setFont(new Font("Arial", Font.BOLD, 14));
        changeButton.setFocusPainted(false); // Eliminar borde de enfoque
        changeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Mano al pasar el ratón
        changeButton.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15)); // Botón más espacioso
        buttonPanel.add(changeButton);

        // Agregar los paneles al marco principal
        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Mostrar la ventana
        setVisible(true);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto de los campos de entrada
                String identificacion = idField.getText();
                String password = new String(passwordField.getPassword());

                Iterator<Paciente> iterator = callCenter.getListaPacientes().iterator();
                while (iterator.hasNext()) {
                    Paciente paciente = iterator.next();
                    if (paciente.getDocumento().equals(identificacion) && paciente.getContraseña().equals(password)) {
                        FormularioCambio formularioCambio = new FormularioCambio(paciente, menupaciente);
                        formularioCambio.setVisible(true);
                        setVisible(false);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(ActualizacionDatos.this, "Paciente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Añadir un listener para detectar el cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Mostrar la ventana anterior al cerrar esta
                menupaciente.setVisible(true);
            }
        });
    }
}
