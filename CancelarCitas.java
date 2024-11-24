import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.awt.event.*;

public class CancelarCitas extends JFrame {

    public CancelarCitas(JFrame menupaciente, CallCenter callCenter) {

        // Configuración de la ventana del menú del paciente
        setTitle("Cancelar Citas");
        setSize(400, 250);  // Aumenta ligeramente el tamaño para acomodar el ComboBox
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel del título
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Cancelar Cita");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleLabel);

        // Panel del formulario
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 10));  // Cambiado a 3 filas

        // Añadir margenes al panel
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JLabel idLabel = new JLabel("Identificación:");
        JTextField idField = new JTextField();
        JLabel passwordLabel = new JLabel("Contraseña:");
        JPasswordField passwordField = new JPasswordField();

        // Agregar el JComboBox
        JLabel serviceLabel = new JLabel("Especialidad:");
        String[] opciones = { "Medicina General", "Odontología", "Optometría", "Pediatría" };
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(serviceLabel);  // Etiqueta del ComboBox
        formPanel.add(comboBox);      // ComboBox

        // Panel para el botón
        JPanel buttonPanel = new JPanel();
        JButton cancelButton = new JButton("Cancelar Cita");
        cancelButton.setBackground(Color.RED);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
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
                String especialidad = (String) comboBox.getSelectedItem();  // Obtener la especialidad seleccionada

                Iterator<Cita> iterator = callCenter.getListaCitas().iterator();
                while (iterator.hasNext()) {
                    Cita cita = iterator.next();
                    System.out.println(cita.getPaciente().getDocumento().equals(identificacion));
                    if (cita.getPaciente().getDocumento().equals(identificacion) && cita.getPaciente().getContraseña().equals(password) && cita.getArea().equals(especialidad)) {
                        iterator.remove();
                        callCenter.cancelarCita(callCenter, cita);
                        JOptionPane.showMessageDialog(menupaciente, "Cita Cancelada con exito", "Mensaje",
                        JOptionPane.WARNING_MESSAGE);
                        System.out.println("Cita cancelada con exito.");
                    }
                }
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
