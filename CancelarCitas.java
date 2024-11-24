import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.awt.event.*;

public class CancelarCitas extends JFrame {

    public CancelarCitas(JFrame menupaciente, CallCenter callCenter) {

        // Configuración de la ventana del menú del paciente
        setTitle("Cancelar Citas");
        setSize(450, 300); // Tamaño ajustado para más espacio visual
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 240, 240)); // Fondo claro

        // Panel del título
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(0, 123, 255)); // Fondo azul moderno
        JLabel titleLabel = new JLabel("Cancelar Cita");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE); // Texto en blanco
        titlePanel.add(titleLabel);

        // Panel del formulario
        JPanel formPanel = new JPanel();
        formPanel.setBackground(new Color(240, 240, 240)); // Fondo a juego
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes
        formPanel.setLayout(new GridLayout(3, 2, 10, 15)); // Espaciado entre filas

        // Añadir margenes al panel
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JLabel idLabel = new JLabel("Identificación:");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField idField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JPasswordField passwordField = new JPasswordField(15);

        JLabel serviceLabel = new JLabel("Especialidad:");
        serviceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        String[] opciones = { "Medicina General", "Odontología", "Optometría", "Pediatría" };
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 14));

        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(serviceLabel);
        formPanel.add(comboBox);

        // Panel para el botón
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 240, 240)); // Fondo a juego
        JButton cancelButton = new JButton("Cancelar Cita");
        cancelButton.setBackground(new Color(220, 53, 69)); // Rojo moderno
        cancelButton.setForeground(Color.WHITE); // Texto blanco
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelButton.setFocusPainted(false); // Eliminar borde de enfoque
        cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Mano al pasar el ratón
        cancelButton.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15)); // Botón más espacioso
        buttonPanel.add(cancelButton);

        // Agregar los paneles al marco principal
        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Mostrar la ventana
        setVisible(true);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto de los campos de entrada
                String identificacion = idField.getText();
                String password = new String(passwordField.getPassword());
                String especialidad = (String) comboBox.getSelectedItem(); // Obtener la especialidad seleccionada

                Iterator<Cita> iterator = callCenter.getListaCitas().iterator();
                while (iterator.hasNext()) {
                    Cita cita = iterator.next();
                    if (cita.getPaciente().getDocumento().equals(identificacion) && cita.getPaciente().getContraseña().equals(password) && cita.getArea().equals(especialidad)) {
                        iterator.remove();
                        callCenter.cancelarCita(callCenter, cita);
                        JOptionPane.showMessageDialog(menupaciente, "Cita Cancelada con exito", "Mensaje",
                        JOptionPane.WARNING_MESSAGE);
                        System.out.println("Cita cancelada con exito.");
                    }
                }
                JOptionPane.showMessageDialog(CancelarCitas.this, "No se encontró una cita con los datos proporcionados.", "Error", JOptionPane.ERROR_MESSAGE);
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
